package com.example.mod12apirest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.coroutineScope
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    val clientHttp = OkHttpClient.Builder().build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val requestCitations = Request.Builder()
            .url("https://kaamelott.chaudie.re/api/all")
            .addHeader("charcode","utf-8")
            .addHeader("content-type","application/json")
            .build()
        clientHttp.newCall(requestCitations).enqueue(object : Callback {
            //Pas de connexion internet, URL est pas bonne (impossible à résoudre)...
            override fun onFailure(call: Call, e: IOException) {
                Log.e(TAG, "onFailure: $e", )
            }
            //Le serveur répond (404 500 200 201)
            override fun onResponse(call: Call, response: Response) {
                Log.i(TAG, "onResponse: ${response.body?.string()}")
                if(response.body != null){
                    //Je transforme la string de retour en un Objet JSON (manipulable en Kotlin)
                    val citationJSON = JSONObject(response.body!!.string())
                    //De cet objet JSON je récupère le tableau JSON "citation" qui contient les citations
                    val listCitationsJSON = citationJSON.getJSONArray("citation")
                    val listCitationType = object : TypeToken<List<Citation>>() {}.type
                    val arrayListCitation : ArrayList<Citation> = Gson().fromJson(
                        listCitationsJSON.toString(), listCitationType)
                    arrayListCitation.forEach {
                        Log.i(TAG, "onResponse: ${it.citation} dite par ${it.infos.personnage}")
                    }
                }
            }
        })
    }
}