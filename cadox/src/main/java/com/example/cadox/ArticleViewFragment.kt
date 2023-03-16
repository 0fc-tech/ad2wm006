package com.example.cadox

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.cadox.databinding.FragmentArticleViewBinding
import com.example.cadox.repository.ArticleRepository
import com.google.android.material.snackbar.Snackbar
import java.util.*


class ArticleViewFragment : Fragment() {
    lateinit var favb : FragmentArticleViewBinding
    //retourne la vue à afficher
    // On a un fichier Layout XML qu'on doit transformer en vue pour l'afficher
    //Et on doit aussi récupérer une instance binding
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
                Snackbar.make(it,
                    favb.article?.url ?: "",
                    1000).show()
            }
            favb.imageButtonEdit.setOnClickListener {
                findNavController().navigate(
                    ArticleViewFragmentDirections.actionViewEdit(favb.article!!)
                )
            }
        }
    }
}