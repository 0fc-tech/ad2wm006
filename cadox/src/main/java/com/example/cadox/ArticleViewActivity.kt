package com.example.cadox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.RatingBar
import android.widget.TextView
import com.example.cadox.repository.ArticleRepository
import com.google.android.material.snackbar.Snackbar

class ArticleViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_view)
        val textViewDate = findViewById<TextView>(R.id.textViewDate)
        val textViewPrice = findViewById<TextView>(R.id.textViewPrice)
        val textViewUrl = findViewById<TextView>(R.id.textViewUrl)
        val textViewRefArticle = findViewById<TextView>(R.id.textViewRefArticle)
        val textViewTitleArticle = findViewById<TextView>(R.id.textViewTitleArticle)
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        val imageButtonUrl = findViewById<ImageButton>(R.id.imageButtonUrl)
        val imageButtonEdit = findViewById<ImageButton>(R.id.imageButtonEdit)
        val checkBox = findViewById<CheckBox>(R.id.checkBox)
        val article = ArticleRepository.getArticle(3)
        if(article != null){
            textViewDate.text = article.dateAchat.toString()
            textViewPrice.text = "${article.prix}€"
            textViewUrl.text = article.url
            textViewRefArticle.text = article.description
            textViewTitleArticle.text = article.intitule
            ratingBar.rating = article.niveau.toFloat()
            checkBox.isChecked = article.achete ?: false
            imageButtonUrl.setOnClickListener {
                Snackbar.make(it,
                    article.url ?: "",
                    1000).show()
            }
        }

    }
}






