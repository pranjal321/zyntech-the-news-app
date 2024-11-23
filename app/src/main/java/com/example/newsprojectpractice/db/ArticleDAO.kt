package com.example.newsprojectpractice.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsprojectpractice.models.Article

@Dao
abstract class ArticleDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun upsert(article: Article): Long

    @Query("SELECT * FROM articles")
    abstract fun getAllArticles(): LiveData<List<Article>>

    @Delete
    abstract suspend fun deleteArticle(article: Article)
}