package com.example.memo.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MemoDao {
    @Query("select * from memo order by date desc")
    fun getAll(): LiveData<List<Memo>>

    @Query("select * from memo where `no` = :no")
    suspend fun getMemo(no: Int): Memo

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(memo: Memo) //suspend: 코루틴을 사용할 수 있도록 suspend를 붙여 백그라운드에서 실행되도록 한다.

    @Update
    suspend fun update(memo: Memo)

    @Query("delete from memo where `no` = :no")
    suspend fun delete(no : Int)
}