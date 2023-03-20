package com.example.cadox.viewmodel

import androidx.lifecycle.ViewModel
import com.example.cadox.repository.ArticleRepository

class ArticleViewViewModel : ViewModel() {
    var article = ArticleRepository.getArticle(2)
}