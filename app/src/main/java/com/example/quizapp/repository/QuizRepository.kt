package com.example.quizapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.quizapp.model.QuestionsList
import com.example.quizapp.retrofit.QuestionAPI
import com.example.quizapp.retrofit.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class QuizRepository {
    var questionAPI: QuestionAPI
    init {
        questionAPI = RetrofitInstance().getRetrofitInstance()
            .create(QuestionAPI::class.java)
    }
    fun getQuestionsFromAPI(): LiveData<QuestionsList>{
        var data = MutableLiveData<QuestionsList>()
        var questionsList: QuestionsList
        GlobalScope.launch  (Dispatchers.IO){
        val response = questionAPI.getQuestions()
            if (response != null){
                questionsList = response.body()!!
                data.postValue(questionsList)
                Log.i("TAGY","" +data.value)
            }
        }
        return data
    }
}