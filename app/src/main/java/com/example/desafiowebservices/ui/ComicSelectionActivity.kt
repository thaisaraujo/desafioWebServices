package com.example.desafiowebservices.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.desafiowebservices.R
import com.example.desafiowebservices.models.Results
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_comic_selection.*
import kotlinx.android.synthetic.main.item_comics.view.*

class ComicSelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comic_selection)

        ivVolta.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        val intent = getIntent()
        val comics = intent.getSerializableExtra("comics") as Results
        val img = comics.thumbnail.path + "." + comics.thumbnail.extension


        titleHQ.text = comics.title.toUpperCase()
        descHQ.text = comics.description
        dataHQ.text = comics.dates[0].date
        priceHQ.text = "$ " + comics.prices[0].price.toString()
        pageHQ.text = comics.pageCount.toString()


        Picasso.get().load(img).into(ivHQtoolbar)
        Picasso.get().load(img).into(ivHQ)

    }
}