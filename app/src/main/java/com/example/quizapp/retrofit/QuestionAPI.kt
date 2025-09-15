package com.example.quizapp.retrofit

import com.example.quizapp.model.QuestionsList
import retrofit2.Response
import retrofit2.http.GET

interface QuestionAPI {
    @GET("questionsapi.php")
    suspend fun getQuestions():Response<QuestionsList>
}