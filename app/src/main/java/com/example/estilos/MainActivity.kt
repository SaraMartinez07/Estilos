package com.example.estilos

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var txt: EditText
    lateinit var checkNegritas: CheckBox
    lateinit var checkCursiva: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt = findViewById(R.id.edNombre)
        checkNegritas = findViewById(R.id.chkNegrita)
        checkCursiva = findViewById(R.id.chkCursiva)


        checkNegritas.setOnCheckedChangeListener { _, _ -> cambiarEstilos() }
        checkCursiva.setOnCheckedChangeListener { _, _ -> cambiarEstilos() }

    }
    private fun cambiarEstilos() {
        var stiles = Typeface.NORMAL
        if (checkNegritas.isChecked && checkCursiva.isChecked) {
            stiles = Typeface.BOLD_ITALIC
        } else if (checkNegritas.isChecked) {
            stiles = Typeface.BOLD
        } else if (checkCursiva.isChecked) {
            stiles = Typeface.ITALIC
        }
        txt.setTypeface(null, stiles)
    }

    fun ClickCheck(v: View) {
        Log.e("CheckBox", "Se presionó")
        cambiarEstilos()
    }
}