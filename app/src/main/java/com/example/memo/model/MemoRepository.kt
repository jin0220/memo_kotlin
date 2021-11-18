package com.example.memo.model

import android.app.Application
import androidx.lifecycle.LiveData

/*
* Repository 는 필수는 아니지만 코드 분리와 구조에 도움을 줍니다.
* 이러한 분리는 DAO 와 Network 에 접근을 도와줍니다.
*/
class MemoRepository (application: Application){
    private val memoDatabase = MemoDatabase.getDatabase(application)
    private val memoDao: MemoDao = memoDatabase!!.memoDao()

    // ViewModel에서 db에 접근을 요청할 때 수행하는 함수들
    val allMemo: LiveData<List<Memo>> = memoDao.getAll()

    suspend fun getMemo(no: Int): Memo {
        return memoDao.getMemo(no)
    }

    suspend fun insert(memo: Memo){
        memoDao.insert(memo)
    }

    suspend fun update(memo: Memo){
        memoDao.update(memo)
    }

    suspend fun delete(no: Int){
        memoDao.delete(no)
    }
}