package com.example.desafiowebservices.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.desafiowebservices.R
import com.example.desafiowebservices.adapters.ResultDadosAdapter
import com.example.desafiowebservices.models.Results
import com.example.desafiowebservices.service.service
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ResultDadosAdapter.OnItemClickListener {

    lateinit var adapter: ResultDadosAdapter
    var listaHQ = arrayListOf<Results>()

    private val viewModel by viewModels<MainViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(service) as T
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHQ.layoutManager = GridLayoutManager(this,3)
        rvHQ.setHasFixedSize(true)

        viewModel.listaComics.observe(this){
            listaHQ.addAll(it.data.results)
            adapter = ResultDadosAdapter(listaHQ, this)
            rvHQ.adapter = adapter
        }
        viewModel.getListRepoComics()
    }

    override fun onItemClick(position: Int) {
        viewModel.listaComics.observe(this){
            val hq = listaHQ.get(position)
            val bundle = Bundle()
            adapter.notifyItemChanged(position)

            bundle.putSerializable("hq", hq)
            startActivity(Intent(this@MainActivity, ComicSelectionActivity::class.java))
        }
    }
}