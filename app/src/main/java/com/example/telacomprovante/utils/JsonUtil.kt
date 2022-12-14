package com.example.telacomprovante.utils

import android.content.Context
import com.example.telacomprovante.Boleto
import com.google.gson.Gson

object JsonUtil {
     private val gson = Gson()

    fun <T: Any> convertJsonAssetToObject(context : Context, fileName : String, type : Class<T>): T{
        val content = FileUtil.readFromAsset(context, fileName)
        return convertJsonToObject(content, type)
    }

    fun <T : Any> convertJsonToObject(content : String ?, type : Class<T>) : T{
        return gson.fromJson(content, type)
    }
}