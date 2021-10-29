package fr.zestia.ezzaimi.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var clickButton: Button
    private lateinit var computeButton: Button
    private var nbClick = 0
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clickButton = findViewById(R.id.btn_click_me)
        computeButton = findViewById(R.id.btn_compute)
        textView = findViewById(R.id.text_view)
        computeButton.setOnClickListener {
            val intent = Intent(baseContext, ComputeActivity::class.java)
            startActivity(intent)
        }
        clickButton.setOnClickListener {
            nbClick++
//            val newText = "Cliquez moi $nbClick"
            val afficherText = "Vous avez cliquez $nbClick fois"
            if (nbClick != 0) {
                textView.text = afficherText
            }
            // Toast.makeText(baseContext, "$afficherText", Toast.LENGTH_LONG).show()
            if (nbClick == 5) {
                clickButton.isEnabled = false
            }
        }
    }
}
