package com.example.motivation

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSave.setOnClickListener(this)

        supportActionBar?.hide()

    }

    override fun onClick(v: View?) {
        if (v != null) {
            if (v.id == R.id.button_save) {
                handleSave()
            }
        }
    }

    private fun handleSave() {

        // obtém nome
        val name = binding.editName.text.toString()

        // Verifica se usuário preencheu o nome
        if (name != "") {
            // salva nome no sharedPreferences
            SecurityPreference(this).storeString("USER_NAME", name)
            startActivity(Intent(this, MainActivity::class.java))

            // Impede que seja possível voltar a Activity
            finish()
        } else {
            Toast.makeText(this, R.string.validation_mandatory_name, Toast.LENGTH_SHORT).show()
        }
    }
}