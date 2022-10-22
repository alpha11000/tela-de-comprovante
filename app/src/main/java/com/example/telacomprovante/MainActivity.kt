package com.example.telacomprovante

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import com.example.telacomprovante.utils.ClipboardUtil
import com.example.telacomprovante.utils.DateUtil
import com.example.telacomprovante.databinding.ActivityMainBinding
import com.example.telacomprovante.utils.FileUtil
import com.example.telacomprovante.utils.JsonUtil
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val boleto = JsonUtil.convertJsonAssetToObject(this, "boleto_response.json", JsonObject::class.java).boleto

        binding.valueTv.text = getString(R.string.value_text, boleto.valorPagar)
        binding.emissionDateTv.text = DateUtil.convertTimeToDateString(boleto.dataHoraGeradoTimestamp, "dd/MM/yyyy, HH:mm")
        binding.expirationDateTv.text = DateUtil.convertTimeToDateString(boleto.dataVencimentoTimestamp)

        val base64 = JsonUtil.convertJsonAssetToObject(this, "boleto_base64.json", JsonObject::class.java).file

        val pdfFileUri = FileUtil.base64ToPDF(this, base64, "boleto.pdf")

        binding.openButton.setOnClickListener {
            FileUtil.openFile(this, pdfFileUri, base64.mime)
        }

        binding.shareButton.setOnClickListener {
            FileUtil.shareFile(this, pdfFileUri, base64.mime)
        }

        binding.copyButton.setOnClickListener{
            ClipboardUtil.copyToClipboard(this, "text", boleto.linhaDigitavel)
            Toast.makeText(this, getString(R.string.successfully_copied), Toast.LENGTH_SHORT).show()
        }
    }
}