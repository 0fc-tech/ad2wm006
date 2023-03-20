package com.example.cadox

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import com.example.cadox.databinding.FragmentArticleViewBinding
import com.example.cadox.repository.ArticleRepository
import com.google.android.material.snackbar.Snackbar
import android.Manifest
import java.util.*


class ArticleViewFragment : Fragment() {
    lateinit var favb : FragmentArticleViewBinding
    //retourne la vue à afficher
    // On a un fichier Layout XML qu'on doit transformer en vue pour l'afficher
    //Et on doit aussi récupérer une instance binding
    val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()){isGranted ->
        Intent().apply {
            data = Uri.parse("sms:06123456789")
            putExtra("sms_body", "Pour me faire un cadeau, tu peux m'offrir ça : ${favb.article!!.intitule}\n" +
                    "Cela ne coute que ${favb.article!!.prix} euros et cela me fera vraiment plaisir :) Merci ! ")
            action = Intent.ACTION_SENDTO
            startActivity(this)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        favb = FragmentArticleViewBinding.inflate(inflater, container, false)
        return favb.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        favb.article = ArticleRepository.getArticle(1)
        if(favb.article != null){
            favb.textViewDate.text = if(favb.article?.dateAchat == null){
                Date(1678877335000L).toString()
            }else{
                favb.article!!.dateAchat.toString()
            }
            favb.imageButtonUrl.setOnClickListener {
                Intent().apply {
                    data = Uri.parse(favb.article!!.url)
                    action = Intent.ACTION_VIEW
                    startActivity(this)
                }
            }
            favb.imageButtonSms.setOnClickListener {
                requestPermissionLauncher.launch(Manifest.permission.SEND_SMS)

            }
            favb.imageButtonEdit.setOnClickListener {
                findNavController().navigate(
                    ArticleViewFragmentDirections.actionViewEdit(favb.article!!)
                )
            }
        }
    }
}