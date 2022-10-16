package com.example.telacomprovante

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.telacomprovante.databinding.ActivityMainBinding
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gson = Gson()

        val jsonContent = FileUtil.readFromAsset(this, "boleto_response.json")

        val boleto = gson.fromJson(jsonContent, boleto::class.java)

        binding.valueTv.text = getString(R.string.value_text, boleto.valorPagar)

        binding.copyButton.setOnClickListener{
            //Toast.makeText(this, jsonContent, Toast.LENGTH_SHORT).show()
            Toast.makeText(this, getString(R.string.successfully_copied), Toast.LENGTH_SHORT).show()
        }
    }
}