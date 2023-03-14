package com.example.cadox.dao

import com.example.cadox.dao.db.ArticleDaoDbImpl
import com.example.cadox.dao.memory.ArticleDaoMemoryImpl
import com.example.cadox.dao.rest.ArticleDaoRestImpl

//Configure et fournis une dao selon le type de source et le type de données.
//On peut retrouver les méthodes getArticleDao ou par exemple getUserDao
//les différents types de sources dont DB ou Memory ou REST
object DaoFactory {
    fun getArticleDao(type: DaoType) :IArticleDao =
        when (type){
            DaoType.DB -> ArticleDaoDbImpl()
            DaoType.MEMORY -> ArticleDaoMemoryImpl()
            DaoType.REST -> ArticleDaoRestImpl()
            //DaoType.REST_DEV -> ArticleDaoMemoryImpl(URL_SERVER, 30)
            //DaoType.REST_PROD -> ArticleDaoMemoryImpl(URL_SERVER, 30)
        }

    //fun getUserDao(type: DaoType) :IUserDao =
    //    when (type){
    //        DaoType.DB -> UserDaoMemoryImpl()
    //        DaoType.MEMORY -> UserDaoMemoryImpl()
    //        DaoType.REST -> UserDaoMemoryImpl()
    //    }


}