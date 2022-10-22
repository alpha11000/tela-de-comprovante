package com.example.telacomprovante.utils

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.CLIPBOARD_SERVICE

object ClipboardUtil {
    fun copyToClipboard(context : Context, label : String, content : String){
        val clipboardManager = context.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText(label, content)
        clipboardManager.setPrimaryClip(clipData)
    }
}