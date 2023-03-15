package com.example.cadox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.RatingBar
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.cadox.databinding.ActivityArticleViewBinding
import com.example.cadox.repository.ArticleRepository
import com.google.android.material.snackbar.Snackbar
import java.time.Instant
import java.time.LocalDate
import java.util.Date

class ArticleViewActivity : AppCompatActivity() {
    lateinit var aavb : ActivityArticleViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Je récupère l'instance du binding grâce à mon fichier layout XML
        aavb = DataBindingUtil.setContentView(this,R.layout.activity_article_view)
        //Dans AAVB je retrouver toutes les vues ET variables de mon fichiers Layout
        aavb.article = ArticleRepository.getArticle(1)
        if(aavb.article != null){
             aavb.textViewDate.text = if(aavb.article?.dateAchat == null){
                Date(1678877335000L).toString()
            }else{
                 aavb.article!!.dateAchat.toString()
             }
            aavb.imageButtonUrl.setOnClickListener {
                Snackbar.make(it,
                    aavb.article?.url ?: "",
                    1000).show()
            }
        }

    }
}






