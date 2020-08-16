package com.example.exercise_recycle_view.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.FieldPosition

class LanguageViewModel : ViewModel(){
    val languageList: MutableList<String> = mutableListOf("Java","Golang","JavaScript","Python","PHP","Ruby","Kotlin","C++","C","C#","Swift","Dart","R")
    val languageLiveData: MutableLiveData<MutableList<String>> = MutableLiveData(languageList)

    fun addLanguage(name: String){
        languageList.add(name)
        languageLiveData.value = languageList
    }
    fun removeLanguage(position: Int){
        languageList.removeAt(position)
        languageLiveData.value = languageList
    }
}