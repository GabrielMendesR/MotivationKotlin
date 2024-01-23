package com.caderno.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.caderno.motivation.infra.MotivationConstants
import com.caderno.motivation.R
import com.caderno.motivation.data.Mock
import com.caderno.motivation.infra.SecurityPreferences
import com.caderno.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var categoryId = MotivationConstants.FILTER.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()  // Esconder Barra de Navegação
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        settingUserName()
        imageFilter(R.id.image_all)
        generatingNextPhrase()

        binding.buttonNewMessage.setOnClickListener(this)
        binding.imageAll.setOnClickListener(this)
        binding.imageEmoji.setOnClickListener(this)
        binding.imageSunny.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_new_message) {
            generatingNextPhrase()
        } else if (view.id in listOf(R.id.image_all, R.id.image_emoji, R.id.image_sunny)) {
            imageFilter(view.id)
        }
    }

    private fun imageFilter(id: Int) {

        binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.images_purple))
        binding.imageEmoji.setColorFilter(ContextCompat.getColor(this, R.color.images_purple))
        binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.images_purple))

        when (id) {
            R.id.image_all -> {
                binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.ALL
            }
            R.id.image_emoji -> {
                binding.imageEmoji.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.EMOJI
            }
            R.id.image_sunny -> {
                binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.SUNNY
            }
        }
    }

    private fun settingUserName() {
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        binding.textHelloName.text = "Olá, $name"
    }

    private fun generatingNextPhrase() {
        binding.textMessage.text = Mock().getPhrase(categoryId)
    }
}