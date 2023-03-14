package com.example.cadox.repository

import com.example.cadox.bo.Article
import com.example.cadox.dao.DaoFactory
import com.example.cadox.dao.DaoType

//c'est ici que la partie IHM récupérera les datas.
//C'est cette classe qui s'occupera de récupérer les données en fonction de la
//Dao source
//Par exemple:
// Si on ne peut pas récuéprer les données sur Internet, on les prends en mémoire ou DB

object ArticleRepository {
    private val daoMemory = DaoFactory.getArticleDao(DaoType.MEMORY)
    private val daoRest = DaoFactory.getArticleDao(DaoType.REST)
    private val daoDb = DaoFactory.getArticleDao(DaoType.DB)
    //Le = est l'équivalent du return avec une seule instruction

    fun getArticle(id:Long, isOffline:Boolean = false) : Article? {
        val articleMemory = daoMemory.selectById(id)
        if(articleMemory == null){
            return daoRest.selectById(id);
        }else{
            return articleMemory
        }
    }

}