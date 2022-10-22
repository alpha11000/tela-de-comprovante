package com.example.telacomprovante

data class JsonObject(
    val boleto : Boleto,
    val file : Base64File
)