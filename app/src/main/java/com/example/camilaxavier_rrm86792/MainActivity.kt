package com.example.recyclerpaises

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.recyclerpaises.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), IAddPais {
    lateinit var bind: ActivityMainBinding
    val adapter = FilmeSerieAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.paisesRecycler.adapter = adapter
        bind.paisesRecycler.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        adapter.setList(mutableListOf(
            FilmeSerieModel("Brasil", "America do Sul"),
            FilmeSerieModel("Argentina", "America do Sul"),
            FilmeSerieModel("China", "Asia"),
            FilmeSerieModel("Egito", "Africa"),
            FilmeSerieModel("Portugal", "Europa")
        ))

        bind.addPaisBtn.setOnClickListener {
            AddDialogFragment.newInstance(this)
                .show(supportFragmentManager,"ADD_DIALOG")
        }

    }

    override fun addPais(pais: FilmeSerieModel) {
        adapter.addPais(pais)
    }
}