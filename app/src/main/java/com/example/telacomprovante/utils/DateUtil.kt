package com.example.telacomprovante.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtil {
    fun convertTimeToDateString(timeStamp : Long, format : String = "dd/MM/yyyy") : String?{
        try{
            val sdf = SimpleDateFormat(format)
            val date = Date(timeStamp * 1000)

            return sdf.format(date)
        }catch (e : Exception){
            return null
        }
    }
}