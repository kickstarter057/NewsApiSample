package com.sample.myapplication.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.sample.myapplication.utility.AppConstant

@Dao
interface HeadlinesDao {
    @Query("SELECT * FROM ${AppConstant.PERSON_TABLE}")
    fun getHeadLines(): ArrayList<Article>

    @Insert
    fun insertHeadlines(vararg articles: Article)
}

