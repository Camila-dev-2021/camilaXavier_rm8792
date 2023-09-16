package com.example.camilaxavier_rrm86792

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.camilaxavier_rrm86792.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bind: ActivityMainBinding
    val adapter = FilmeSerieAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.filmeSerieRecycler.adapter = adapter
        bind.filmeSerieRecycler.layoutManager = LinearLayoutManager(this)

        adapter.setList(mutableListOf(
            FilmeSerieModel("The office", "Comédia", true),
            FilmeSerieModel("O alto da compadecida", "Comédia",  true),
            FilmeSerieModel("As patricinhas de Beverly Hills", "Comedia Romantica", true),
            FilmeSerieModel("Egito", "Suspense", false),
        ))

    }

}