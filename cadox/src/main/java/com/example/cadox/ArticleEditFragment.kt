package com.example.cadox

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.cadox.databinding.FragmentArticleEditBinding
import com.example.cadox.databinding.FragmentArticleViewBinding
import com.example.cadox.repository.ArticleRepository


class ArticleEditFragment : Fragment() {
    lateinit var faeb : FragmentArticleEditBinding
    val args by navArgs<ArticleEditFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        faeb = FragmentArticleEditBinding.inflate(inflater, container, false)
        return faeb.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        faeb.article = args.article
    }

}