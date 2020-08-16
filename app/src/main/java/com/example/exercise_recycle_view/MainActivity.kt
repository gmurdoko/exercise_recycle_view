package com.example.exercise_recycle_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exercise_recycle_view.view_model.LanguageViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),RecyclerViewClickListener {
    val languageViewModel by viewModels<LanguageViewModel>()
    //1st
    lateinit var languageRecycleAdapter: LanguageRecycleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        language_recycle_view.layoutManager = LinearLayoutManager(this)
        languageRecycleAdapter = LanguageRecycleAdapter(languageViewModel.languageLiveData.value!!)
        languageRecycleAdapter.listener = this
        language_recycle_view.adapter = languageRecycleAdapter
        languageViewModel.languageLiveData.observe(this, Observer {
            languageRecycleAdapter.notifyDataSetChanged()
        })
    }

    fun addLanguage(view: View) {
        val languageName = language_input.text.toString()
        languageViewModel.addLanguage(languageName)
//        language_recycle_view.adapter?.notifyDataSetChanged()
    }

    override fun onItemClicked(view: View, language: String) {
        Toast.makeText(this,"$language CLICKED", Toast.LENGTH_SHORT).show()
    }

    override fun onItemClicked(view: View, index: Int) {
        languageViewModel.removeLanguage(index)
        Toast.makeText(this, "$index DELETE SUCCESFUL", Toast.LENGTH_SHORT).show()
    }
}