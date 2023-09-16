package com.example.camilaxavier_rrm86792

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.camilaxavier_rrm86792.databinding.FilmeSerieItemListBinding

import java.util.Locale

class FilmeSerieAdapter : RecyclerView.Adapter<FilmeSerieAdapter.FilmeSerieHolder>() {

    private val filmeSerie: MutableList<FilmeSerieModel> = mutableListOf()

    class FilmeSerieHolder(val itemHolder: FilmeSerieItemListBinding) :
        RecyclerView.ViewHolder(itemHolder.root) {
        fun bind(item: FilmeSerieModel) {
            itemHolder.txtNome.text = item.nome
            itemHolder.txtGenero.text = item.genero
            itemHolder.imageView.setImageResource(
                if (item.recomendaria) {
                    R.drawable.recomendaria_item
                } else {
                    R.drawable.baseline_thumb_down_24
                }
            )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmeSerieHolder {
        return FilmeSerieHolder(
            FilmeSerieItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        )
    }

    override fun getItemCount(): Int =
        filmeSerie.count()

    override fun onBindViewHolder(holder: FilmeSerieHolder, position: Int) {
        holder.bind(filmeSerie[position])
        holder.itemHolder.closeButton.setOnClickListener {
            removeListItem(filmeSerie[position])
        }
    }

    fun setList(newItems: List<FilmeSerieModel>) {
        filmeSerie.clear()
        filmeSerie.addAll(newItems)
        notifyDataSetChanged()
    }

    fun removeListItem(removed: FilmeSerieModel) {
        val removedIndex = filmeSerie.indexOf(removed)
        filmeSerie.remove(removed)
        notifyItemRemoved(removedIndex)
        notifyItemRangeChanged(removedIndex, filmeSerie.size);
    }


}