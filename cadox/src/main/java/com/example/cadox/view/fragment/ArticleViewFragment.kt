package com.example.cadox.view.fragment

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
import android.Manifest
import androidx.fragment.app.viewModels
import com.example.cadox.viewmodel.ArticleViewViewModel
import java.util.*


class ArticleViewFragment : Fragment() {
    lateinit var favb : FragmentArticleViewBinding
    val viewModel by viewModels<ArticleViewViewModel>()
    //retourne la vue à afficher
    // On a un fichier Layout XML qu'on doit transformer en vue pour l'afficher
    //Et on doit aussi récupérer une instance binding
    val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()){isGranted ->
        Intent().apply {
            data = Uri.parse("sms:06123456789")
            putExtra("sms_body", "Pour me faire un cadeau, tu peux m'offrir ça : ${viewModel.article!!.intitule}\n" +
                    "Cela ne coute que ${viewModel.article!!.prix} euros et cela me fera vraiment plaisir :) Merci ! ")
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
        //favb.article = ArticleRepository.getArticle(1)
        favb.vm = viewModel
        if(viewModel.article != null){
            favb.textViewDate.text = if(viewModel.article?.dateAchat == null){
                Date(1678877335000L).toString()
            }else{
                viewModel.article!!.dateAchat.toString()
            }
            favb.imageButtonUrl.setOnClickListener {
                Intent().apply {
                    data = Uri.parse(viewModel.article!!.url)
                    action = Intent.ACTION_VIEW
                    startActivity(this)
                }
            }
            favb.imageButtonSms.setOnClickListener {
                requestPermissionLauncher.launch(Manifest.permission.SEND_SMS)

            }
            favb.imageButtonEdit.setOnClickListener {
                findNavController().navigate(
                    ArticleViewFragmentDirections.actionViewEdit(viewModel.article!!)
                )
            }
        }
    }
}