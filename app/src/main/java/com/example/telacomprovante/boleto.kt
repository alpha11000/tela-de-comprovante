package com.example.telacomprovante

data class boleto(
    val dataHoraGeradoTimestamp : Long,
    val dataVencimentoTimestamp : Long,
    val linhaDigitavel : String,
    val valorPagar : Double
)
