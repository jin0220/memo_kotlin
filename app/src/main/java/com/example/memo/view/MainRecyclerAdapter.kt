package com.example.memo.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.memo.databinding.RecyclerviewMainBinding
import com.example.memo.model.Memo
import java.text.SimpleDateFormat
import java.util.*

class MainRecyclerAdapter() : RecyclerView.Adapter<MainRecyclerAdapter.Holder>(){

    private var listDate:List<Memo> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = RecyclerviewMainBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        return holder.bind(listDate[position])
    }

    override fun getItemCount(): Int {
        return listDate.size
    }

    class Holder(val binding: RecyclerviewMainBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(memo: Memo){
            with(binding) {
                title.text = memo.title
                content.text = memo.content

                // 날짜 텍스트 표현 다르게 하기 위해
                var sdf: SimpleDateFormat? = null
                if(Date(memo.datetime).year < Date(System.currentTimeMillis()).year){
                    sdf = SimpleDateFormat("yyyy년 MM월 dd일")
                }
                else if((Date(memo.datetime).month <= Date(System.currentTimeMillis()).month)
                        && (Date(memo.datetime).date < Date(System.currentTimeMillis()).date)){
                    sdf = SimpleDateFormat("MM월 dd일")
                }
                else if(Date(memo.datetime).date == Date(System.currentTimeMillis()).date){
                    sdf = SimpleDateFormat("HH:mm")
                }
                date.text = sdf?.format(memo.datetime)

                contentBox.setOnClickListener {
                    val intent = Intent(contentBox.context, WriteActivity::class.java)
                    intent.putExtra("mode", "read")
                    intent.putExtra("no", memo.no)
                    ContextCompat.startActivity(contentBox.context, intent, null)
                }
            }
        }
    }

    fun setMemo(memo: List<Memo>){
        this.listDate = memo
        notifyDataSetChanged()
    }
}