package com.example.telacomprovante.utils

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v4.content.FileProvider
import android.util.Base64
import android.widget.Toast
import com.example.telacomprovante.Base64File
import java.io.File
import java.io.FileOutputStream
import java.io.IOException


object FileUtil{
    fun readFromAsset(context : Context, path : String) : String ? {
        val content : String

        try {
            content = context.assets.open(path).bufferedReader().use { it.readText() }
        }catch (e : IOException){
            e.printStackTrace()
            return null
        }
        return content
    }
    
    fun base64ToPDF(context: Context, base64File : Base64File, outFileName : String) : Uri {
        val file = File(context.externalCacheDir?.absolutePath, outFileName)

        if(!file.exists()){
            file.createNewFile()
        }

        val decoded = Base64.decode(base64File.data, Base64.DEFAULT)
        val os = FileOutputStream(file)
        os.write(decoded)
        os.flush()
        os.close()

        return FileProvider.getUriForFile(context, context.applicationContext.packageName + ".file-provider", file)
    }

    fun openFile(context : Context, uri : Uri, type : String){
        val target = Intent(Intent.ACTION_VIEW)

        target.setDataAndType(uri, type)
        target.flags = Intent.FLAG_ACTIVITY_NO_HISTORY or Intent.FLAG_GRANT_READ_URI_PERMISSION

        val intent = Intent.createChooser(target, "Open File")
        try {
            context.startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(context, "Não foram encontrados aplicativos compatíveis", Toast.LENGTH_SHORT).show()
        }
    }

    fun shareFile(context : Context, uri : Uri, type : String){
        val target = Intent(Intent.ACTION_SEND)

        target.type = type
        target.putExtra(Intent.EXTRA_STREAM, uri)
        target.flags = Intent.FLAG_ACTIVITY_NO_HISTORY or Intent.FLAG_GRANT_READ_URI_PERMISSION

        val intent = Intent.createChooser(target, "Share File")
        try{
            context.startActivity(intent)
        }catch (e: ActivityNotFoundException){
            Toast.makeText(context, "Não foram encontrados aplicativos compatíveis", Toast.LENGTH_SHORT).show()
        }
    }
}