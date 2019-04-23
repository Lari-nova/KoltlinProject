package com.example.koltlinproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.koltlinproject.Adapter.PostAdapter
import com.example.koltlinproject.Model.Post
import com.example.koltlinproject.Retrofit.IMyApi
import com.example.koltlinproject.Retrofit.RetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    internal lateinit var jsonApi: IMyApi
    internal lateinit var compositeDisposable: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        compositeDisposable = CompositeDisposable()

        val retrofit = RetrofitClient.instance
        jsonApi = retrofit.create(IMyApi::class.java)

        recycler_posts.setHasFixedSize(true)
        recycler_posts.layoutManager = LinearLayoutManager(this)
        fetchData()

    }

    private fun fetchData() {
        try {

        } catch (e: Exception) {
            println(e.printStackTrace())
        }


        compositeDisposable.add(jsonApi.posts
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{posts -> displayData(posts)}
        )
    }

    private fun displayData(posts: List<Post>?) {
        val adapter = PostAdapter(this, posts!!)
        recycler_posts.adapter = adapter
    }
}
