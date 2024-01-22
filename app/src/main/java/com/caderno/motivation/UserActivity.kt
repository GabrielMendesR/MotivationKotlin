package com.caderno.motivation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.caderno.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        supportActionBar?.hide()

        binding = ActivityUserBinding.inflate(layoutInflater)

    }

    override fun onClick(view: View) {
        if(view.id == R.id.button_salvar_nome) {
            println("ClickouSalvar")
        }
    }
}