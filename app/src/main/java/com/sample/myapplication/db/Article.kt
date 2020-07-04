package com.sample.myapplication.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sample.myapplication.utility.AppConstant.PERSON_TABLE

@Entity(tableName = PERSON_TABLE)
data class Article(
    @PrimaryKey(autoGenerate = true) var id: String? = null,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "image") var imageUrl: String,
    @ColumnInfo(name = "desc") var desc: String,
    @ColumnInfo(name = "author") var author: String,
    @ColumnInfo(name = "publish") var publish: String,
    @ColumnInfo(name = "content") var content: String
)