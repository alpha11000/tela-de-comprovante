package com.example.telacomprovante

import android.content.Context
import java.io.IOException

object FileUtil{
    fun readFromAsset(context: Context, name : String) : String ? {
        val content : String

        try {
            content = context.assets.open(name).bufferedReader().use { it.readText() }
        }catch (e : IOException){
            e.printStackTrace()
            return null
        }

        return content
    }
}