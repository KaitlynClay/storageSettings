package com.example.storagesettings

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val PREF_NAME = "prefs"
    private val PREF_DARK_THEME = "dark_theme"
    private val PREF_LANGUAGE = "language"
    private val PREF_FONT_SIZE = "font_size"

    override fun onCreate(savedInstanceState: Bundle?) {

        val SP = getSharedPreferences(PREF_NAME, MODE_PRIVATE)

        val useDarkTheme = SP.getBoolean(PREF_DARK_THEME, false)
        val langSwitch1 = SP.getBoolean(PREF_LANGUAGE, false)
        val fontSize = SP.getInt(PREF_FONT_SIZE, 12) // Default font size is 12

        // Apply dark theme
        if (useDarkTheme) {
            setTheme(androidx.appcompat.R.style.Base_ThemeOverlay_AppCompat_Dark)
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val SP = getSharedPreferences(PREF_NAME, MODE_PRIVATE)
//
//        val langView = findViewById<TextView>(R.id.langView)
//        val fontView = findViewById<TextView>(R.id.fontSizeView)
//
//        val useDarkTheme = SP.getBoolean(PREF_DARK_THEME, false)
//        val langSwitch1 = SP.getBoolean(PREF_LANGUAGE, false)
//        val fontSize = SP.getInt(PREF_FONT_SIZE, 12) // Default font size is 12

        updateUI(useDarkTheme, langSwitch1, fontSize)

        val themeSwitch = findViewById<Switch>(R.id.themeSwitch)
        themeSwitch.isChecked = useDarkTheme
        themeSwitch.setOnCheckedChangeListener { _, isChecked ->
            toggleTheme(isChecked)
        }

        val langSwitch = findViewById<Switch>(R.id.langSwitch)
        langSwitch.isChecked = true
        langSwitch.setOnCheckedChangeListener { _, isChecked ->
            toggleLanguage(isChecked)
        }

        val fontSizeSwitch = findViewById<Switch>(R.id.fontSwitch)
        fontSizeSwitch.isChecked = true
        fontSizeSwitch.setOnCheckedChangeListener { _, isChecked ->
            toggleFontSize(isChecked)
        }
    }

    private fun updateUI(useDarkTheme: Boolean, langSwitch: Boolean, fontSize: Int) {
        val langView = findViewById<TextView>(R.id.langView)
        val fontView = findViewById<TextView>(R.id.fontSizeView)

        // Apply dark theme
        if (useDarkTheme) {
            setTheme(androidx.appcompat.R.style.Base_ThemeOverlay_AppCompat_Dark)
        }

        // Apply language
        if (langSwitch) {
            langView.setText("Hola, ¡estoy aquí para darte la bienvenida a esta aplicación!").toString()
        }

        // Apply font size
        fontView.textSize = fontSize.toFloat()
    }

    private fun toggleTheme(darkTheme: Boolean) {
        val editor = getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit()
        editor.putBoolean(PREF_DARK_THEME, darkTheme)
        editor.apply()
        updateThemeUI(darkTheme)
    }

    private fun updateThemeUI(darkTheme: Boolean) {
        if (darkTheme) {
            setTheme(androidx.appcompat.R.style.Base_ThemeOverlay_AppCompat_Dark)
        } else {
            setTheme(androidx.appcompat.R.style.Base_ThemeOverlay_AppCompat_Light)
        }
        recreate()
    }

    private fun toggleLanguage(language: Boolean) {
        val editor = getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit()
        editor.putBoolean(PREF_LANGUAGE, language)
        editor.apply()
        updateLanguageUI(language)
    }

    private fun updateLanguageUI(language: Boolean) {
        val langView = findViewById<TextView>(R.id.langView)
        if (language) {
            langView.setText("Hola, ¡estoy aquí para darte la bienvenida a esta aplicación!")
        } else {
            langView.setText("Hi, I'm here to welcome you to this app!")
        }

        val langSwitch = findViewById<Switch>(R.id.langSwitch)
        langSwitch.isChecked = language
    }

    private fun toggleFontSize(isChecked: Boolean) {
        val editor = getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit()
        editor.putInt(PREF_FONT_SIZE, if (isChecked) 24 else 12)
        editor.apply()
        updateFontSizeUI(isChecked)
    }

    private fun updateFontSizeUI(isChecked: Boolean) {
        val fontView = findViewById<TextView>(R.id.fontSizeView)
        fontView.textSize = if (isChecked) 24F else 12F
    }

}


//package com.example.storagesettings
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Switch
//import android.widget.TextView
//
//class MainActivity : AppCompatActivity() {
//
//    val PREF_NAME = "perfs"
//    val PREF_DARK_THEME = "dark_theme"
//    val PREF_LANGAUGE = "language"
//    val PREF_FONT_SIZE = "font_size"
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//
//        val SP = getSharedPreferences(PREF_NAME, MODE_PRIVATE)
//        val langView = findViewById<TextView>(R.id.langView)
//        val fontView = findViewById<TextView>(R.id.fontSizeView)
//
//        val useDarkTheme = SP.getBoolean(PREF_DARK_THEME, false)
//        if (useDarkTheme) {
//            setTheme(androidx.appcompat.R.style.Base_ThemeOverlay_AppCompat_Dark)
//        }
//
//        val langSwitch = SP.getBoolean(PREF_LANGAUGE, false)
//        if (langSwitch) {
//            langView.setText("Hola, ¡estoy aquí para darte la bienvenida a esta aplicación!").toString()
//        }
//
//        val fontSwitch = SP.getBoolean(PREF_FONT_SIZE, false)
//        if (fontSwitch) {
//            fontView.setTextSize(24F)
//        }
//
//
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val themeToggle = findViewById<Switch>(R.id.themeSwitch)
//        themeToggle.isChecked = useDarkTheme
//        themeToggle.setOnCheckedChangeListener { view, isChecked ->
//            toggleTheme(isChecked)
//        }
//
//        val langToggle = findViewById<Switch>(R.id.langSwitch)
//        langToggle.isChecked = langSwitch
//        langToggle.setOnCheckedChangeListener { view, isChecked ->
//            langToggle(isChecked)
//        }
//
//        val fontToggle = findViewById<Switch>(R.id.fontSwitch)
//        fontToggle.isChecked = fontSwitch
//        fontToggle.setOnCheckedChangeListener { view, isChecked ->
//            fontToggle(isChecked)
//        }
//
//
//    }
//
//    private fun fontToggle(font_size: Boolean) {
//        val editor = getSharedPreferences(PREF_FONT_SIZE, MODE_PRIVATE).edit()
//        editor.apply {
//            putBoolean(PREF_FONT_SIZE, font_size)
//            apply()
//        }
//        val intent = intent
//        finish()
//        startActivity(intent)
//    }
//
//    private fun langToggle(language: Boolean) {
//        val editor = getSharedPreferences(PREF_LANGAUGE, MODE_PRIVATE).edit()
//        editor.apply {
//            putBoolean(PREF_LANGAUGE, language)
//            apply()
//        }
//        val intent = intent
//        finish()
//        startActivity(intent)
//    }
//
//    private fun toggleTheme(darkTheme: Boolean) {
//        val editor = getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit()
//        editor.apply {
//            putBoolean(PREF_DARK_THEME, darkTheme)
//            apply()
//        }
//        val intent = intent
//        finish()
//        startActivity(intent)
//    }
//}
