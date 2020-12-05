package com.example.desafiowebservices.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiowebservices.R
import com.example.desafiowebservices.models.Results
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_comics.view.*

class ResultDadosAdapter(private val listaComics: List<Results>,
                         private val listener: OnItemClickListener):
                         RecyclerView.Adapter<ResultDadosAdapter.ComicsViewHolder>() {

   inner class ComicsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        //Dados do comics
       val ivHQ: ImageView = itemView.ivHQ
       val tvIdHQ: TextView = itemView.tvIdHQ

       init {
           itemView.setOnClickListener(this)
       }

       override fun onClick(v: View?) {
           //verificar se posição é válida
           if(adapterPosition != RecyclerView.NO_POSITION){
               listener.onItemClick(adapterPosition)
           }
       }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsViewHolder {
        //inflando comics
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_comics, parent, false)
        return ComicsViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: ComicsViewHolder, position: Int) {
        //passar os dados do item selecionado
        val hq = listaComics.get(position)
        val img = hq.thumbnail.path + "." + hq.thumbnail.extension

        holder.tvIdHQ.text = "#" + hq.id.toString()
        Picasso.get().load(img).into(holder.ivHQ)
    }


    override fun getItemCount() = listaComics.size


    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

}