package com.example.telacomprovante

data class Boleto (
    val dataHoraGeradoTimestamp : Long = 0,
    val dataVencimentoTimestamp : Long = 0,
    val linhaDigitavel : String,
    val valorPagar : Double
)