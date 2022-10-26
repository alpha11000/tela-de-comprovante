package com.example.telacomprovante.utils

import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

object DateUtil {
    fun convertTimeToDateString(timeStamp : Long, format : String = "dd/MM/yyyy") : String?{
        try{
            val sdf = SimpleDateFormat(format)
            val date = Date(timeStamp * 1000)
            sdf.timeZone = TimeZone.getTimeZone("Brazil/Brasilia")

            return sdf.format(date)
        }catch (e : Exception){
            return null
        }
    }

    fun getFormattedNumber(number : Double) : String{
        val numberFormat = NumberFormat.getNumberInstance(Locale.ITALY)
        return numberFormat.format(number)
    }
}