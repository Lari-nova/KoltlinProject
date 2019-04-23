package com.example.koltlinproject.Retrofit

import com.example.koltlinproject.Model.Post
import io.reactivex.Observable
import retrofit2.http.GET

interface IMyApi {
    @get: GET("posts")
    val posts: Observable<List<Post>>
}