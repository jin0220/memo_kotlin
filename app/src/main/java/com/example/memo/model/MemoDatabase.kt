package com.example.memo.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/* entities = 사용할 엔티티 선언, version = 엔티티 구조 변경 시 구분해주는 역할
   exportSchema = 스키마 내보내기 설정 -> 정식 배포 버전에서는 false 를 사용하여 배포하지 않는 것이 좋다. */
@Database(entities = [Memo::class], version = 1, exportSchema = false)
abstract class MemoDatabase: RoomDatabase() {
    abstract fun memoDao(): MemoDao

    companion object{
        private var instance: MemoDatabase? = null

        fun getDatabase(context: Context): MemoDatabase? {
            if(instance == null){
                synchronized(MemoDatabase::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MemoDatabase::class.java,
                        "memo_db"
                    ).build()
                }
            }
            return instance
        }
    }
}