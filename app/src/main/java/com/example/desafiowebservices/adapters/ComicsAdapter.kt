package com.example.desafiowebservices.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiowebservices.R
import kotlinx.android.synthetic.main.item_comics.view.*

class ComicsAdapter(private val listaComics: ComicsCompleto,
                    private val listener: OnItemClickListener):
                    RecyclerView.Adapter<ComicsAdapter.ComicsViewHolder> {

   inner class ComicsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        //Dados do comics
       val capcaComics: ImageView = itemView.ivHQ
       val id: TextView = itemView.tvIdHQ

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
        TODO("Not yet implemented")
    }


    override fun getItemCount() = listaComics.size


    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

}