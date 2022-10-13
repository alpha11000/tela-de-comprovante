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

        val b = Boleto(0, 0, "", 1000.0)

        val gson : Gson = Gson()

        val test = gson.toJson(b)
        println(test)

        val boleto = gson.fromJson(test, Boleto::class.java)

        binding.valueTv.text = "R$ " + boleto.valorPagar

        binding.copyButton.setOnClickListener{
            Toast.makeText(this, test, Toast.LENGTH_SHORT).show()
            //Toast.makeText(this, getString(R.string.successfully_copied), Toast.LENGTH_SHORT).show()
        }
    }
}