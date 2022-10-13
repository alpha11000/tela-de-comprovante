package com.example.telacomprovante

data class Boleto(
    val dataHoraGeradoTimestamp : Long,
    val dataVencimentoTimestamp : Long,
    val linhaDigitavel : String,
    val valorPagar : Double
)
