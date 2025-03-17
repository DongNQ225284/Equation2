package com.example.quadraticequation

import android.os.Bundle
import android.telephony.SmsMessage.SubmitPdu
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var edtA: EditText
    lateinit var edtB: EditText
    lateinit var edtC: EditText
    lateinit var btnSubmit: Button
    lateinit var tvResult: TextView
    lateinit var tvX1: TextView
    lateinit var tvX2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        edtA = findViewById(R.id.edtA)
        edtB = findViewById(R.id.edtB)
        edtC = findViewById(R.id.edtC)
        btnSubmit = findViewById(R.id.btnSubmit)
        tvResult = findViewById(R.id.tvResult)
        tvX1 = findViewById(R.id.tvX1)
        tvX2 = findViewById(R.id.tvX2)

        btnSubmit.setOnClickListener {
            solve()
        }
    }

    private fun solve() {
        val a = edtA.text.toString().toDoubleOrNull()
        val b = edtB.text.toString().toDoubleOrNull()
        val c = edtC.text.toString().toDoubleOrNull()

        if (a == null || b == null || c == null) {
            tvResult.text = "Error!"
            tvX1.text = ""
            tvX2.text = ""
            return
        }

        if (a == 0.0) {
            tvResult.text = "Error!"
            tvX1.text = ""
            tvX2.text = ""
            return
        }

        val delta = b * b - 4 * a * c

        if (delta < 0) {
            tvResult.text = "Phương trình vô nghiệm!"
            tvX1.text = ""
            tvX2.text = ""
        } else if (delta == 0.0) {
            val x = -b / (2 * a)
            tvResult.text = "Phương trình có nghiệm kép:"
            tvX1.text = "x1 = x2 = $x"
            tvX2.text = ""
        } else {
            val x1 = (-b + Math.sqrt(delta)) / (2 * a)
            val x2 = (-b - Math.sqrt(delta)) / (2 * a)
            tvResult.text = "Phương trình có 2 nghiệm phân biệt:"
            tvX1.text = "x1 = $x1"
            tvX2.text = "x2 = $x2"
        }
    }
}