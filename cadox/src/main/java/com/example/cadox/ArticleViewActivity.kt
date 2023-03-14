package com.example.cadox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.cadox.repository.ArticleRepository

class ArticleViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_view)
        val labelArticle = findViewById<TextView>(R.id.labelDetailArticle)
        labelArticle.setText(ArticleRepository.getArticle(1).toString())
    }
}