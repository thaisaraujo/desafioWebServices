package com.example.desafiowebservices.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desafiowebservices.R
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        toolbarCadastro.setNavigationOnClickListener {
            startActivity(Intent(this@CadastroActivity, LoginActivity::class.java))
            finish()
        }

        btnSalve.setOnClickListener {
            startActivity(Intent(this@CadastroActivity, MainActivity::class.java))
            finish()
        }


    }
}