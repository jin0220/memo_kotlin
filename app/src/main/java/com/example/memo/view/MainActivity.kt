package com.example.memo.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.memo.databinding.ActivityMainBinding
import com.example.memo.viewModel.MemoViewModel

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
//    lateinit var binding: ActivityMainBinding
    lateinit var memoViewModel: MemoViewModel
    lateinit var adapter: MainRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
//        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        memoViewModel = ViewModelProvider(this).get(MemoViewModel::class.java)

        // 리사이클러뷰 설정
        adapter = MainRecyclerAdapter()
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = GridLayoutManager(this,3)


        memoViewModel.allMemo.observe(this, Observer {
            adapter.setMemo(it)
        })

        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(this, WriteActivity::class.java)
            intent.putExtra("mode", "write")
            startActivity(intent)
        }
    }

}