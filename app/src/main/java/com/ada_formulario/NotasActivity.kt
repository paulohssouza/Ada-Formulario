package com.ada_formulario

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ada_formulario.databinding.ActivityNotasBinding

class NotasActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityNotasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityNotasBinding.inflate(layoutInflater)
        val view = viewBinding.root
        setContentView(view)
        saveNotas()
        recoverNotas()
    }

    private fun recoverNotas() {
        val preferences: SharedPreferences = getSharedPreferences(NOTAS, MODE_PRIVATE)

        val nota = preferences.getString(TEXTO,"")
        viewBinding.editorTexto.setText(nota)
    }

    private fun saveNotas() {
        val preferences: SharedPreferences = getSharedPreferences(NOTAS, MODE_PRIVATE)
        viewBinding.buttonSave.setOnClickListener {
            preferences.edit().putString(TEXTO, viewBinding.editorTexto.text.toString()).apply()
        }
    }

    companion object {
        const val NOTAS = "bilu"
        const val TEXTO = "teteia"
    }
}