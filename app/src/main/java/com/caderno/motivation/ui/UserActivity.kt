package com.caderno.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.caderno.motivation.infra.MotivationConstants
import com.caderno.motivation.R
import com.caderno.motivation.infra.SecurityPreferences
import com.caderno.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()  // Esconder Barra de Navegação
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSaveName.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_save_name) {
            saveName()
        }
    }

    private fun saveName() {
        val name = binding.editName.text.toString()
        if (name != "") {
            SecurityPreferences(this).storeString(MotivationConstants.KEY.USER_NAME, name)
            finish()
        } else {
            Toast.makeText(this, "Informe Um Nome Válido", Toast.LENGTH_SHORT).show()
        }
    }
}
