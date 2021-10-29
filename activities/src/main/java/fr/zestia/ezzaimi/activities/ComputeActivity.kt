package fr.zestia.ezzaimi.activities

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ComputeActivity : AppCompatActivity(), TextWatcher {
    private lateinit var nombre1: EditText
    private lateinit var nombre2: EditText
    private lateinit var calculbutton: Button
    private lateinit var resultats: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.compute_activity)
        nombre1 = findViewById(R.id.field_1)
        nombre2 = findViewById(R.id.field_2)
        calculbutton = findViewById(R.id.btn_calculer)
        resultats = findViewById(R.id.resultat)
        nombre1.addTextChangedListener(this)
        nombre2.addTextChangedListener(this)

        calculbutton.setOnClickListener {
            val somme = nombre1.text.toString().toDouble() + nombre2.text.toString().toDouble()
            resultats.text = somme.toString()
        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    override fun afterTextChanged(s: Editable?) {
        calculbutton.isEnabled = nombre1.text.isNotBlank() && nombre2.text.isNotBlank()
    }
}
