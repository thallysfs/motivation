package com.example.motivation

import android.content.Context
import android.content.SharedPreferences

class SecurityPreference(context: Context) {

    private val security: SharedPreferences =
        context.getSharedPreferences("Motivation", Context.MODE_PRIVATE)

    // editando o SharedPreferences que é uma espécie de cache do mobile
    fun storeString(key: String, str: String) {
        this.security.edit().putString(key, str).apply()
    }

    fun getString(key: String): String {
     /* ?: - esse operador é o elvis, semelhante ao || do javascript, se o valro da esquerda for nulo,
     * ele retorna o valro da direita.
     */
        return this.security.getString(key, "") ?: ""
    }
    
}