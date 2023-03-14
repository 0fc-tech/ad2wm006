package com.example.cadox.dao

import com.example.cadox.bo.Article


//Squelette d'une implémentation de la DAO pour les articles
//Ici on ajoute les méthodes qui vont devoir être implémentées
// selon tout les types de sources (DB / REST/ MEMORY)
//CAD qu'à chaque fois qu'on veut rajouter une source, on implémente IArticleDao
interface IArticleDao {
    fun selectById(id: Long): Article?
   //fun addArticle(article: Article)
   //fun deleteById(id: Long)
}