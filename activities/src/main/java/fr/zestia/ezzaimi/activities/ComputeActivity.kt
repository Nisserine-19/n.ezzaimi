package fr.zestia.ezzaimi.activities

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import fr.zestia.ezzaimi.activities.databinding.ComputeActivityBinding

class ComputeActivity : AppCompatActivity(), TextWatcher {
    private lateinit var binding: ComputeActivityBinding

    //    private lateinit var nombre1: EditText
//    private lateinit var nombre2: EditText
//    private lateinit var calculbutton: Button
//    private lateinit var resultats: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ComputeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            btnCalculer.setOnClickListener {
                val somme = field1.text.toString().toDouble() + field2.text.toString().toDouble()
                resultat.text = somme.toString()
            }
            field1.addTextChangedListener(this@ComputeActivity)
            field2.addTextChangedListener(this@ComputeActivity)
            // binding.resultat.addTextChangedListener(this@ComputeActivity)
        }
//        nombre1 = findViewById(R.id.field_1)
//        nombre2 = findViewById(R.id.field_2)
//        calculbutton = findViewById(R.id.btn_calculer)
//        resultats = findViewById(R.id.resultat)
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    override fun afterTextChanged(s: Editable?) {
        with(binding) {
            btnCalculer.isEnabled = field1.text.isNotBlank() && field2.text.isNotBlank()
        }
    }
}
