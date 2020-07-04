package com.sample.myapplication.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sample.myapplication.utility.AppConstant.APP_DATABASE

@Database(entities = [Article::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    companion object {
        private var mInstance: AppDataBase? = null

        fun getAppDatabase(context: Context): AppDataBase? {
            if (mInstance == null) {
                synchronized(AppDataBase::class) {
                    mInstance = Room
                        .databaseBuilder(
                            context.applicationContext,
                            AppDataBase::class.java,
                            APP_DATABASE
                        )
                        .build()
                }
            }
            return mInstance
        }

        fun deleteInstance() {
            mInstance = null
        }
    }
}