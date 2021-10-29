package fr.zestia.ezzaimi.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.zestia.ezzaimi.activities.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var nbClick = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        clickButton = findViewById(R.id.btn_click_me)
//        computeButton = findViewById(R.id.btn_compute)
//        textView = findViewById(R.id.text_view)
        binding.btnCompute.setOnClickListener {
            val intent = Intent(baseContext, ComputeActivity::class.java)
            startActivity(intent)
        }
        binding.btnClickMe.setOnClickListener {
            nbClick++
//            val newText = "Cliquez moi $nbClick"
            val afficherText = "Vous avez cliquez $nbClick fois"
            if (nbClick != 0) {
                binding.textView.text = afficherText
            }
            // Toast.makeText(baseContext, "$afficherText", Toast.LENGTH_LONG).show()
            if (nbClick == 5) {
//                clickButton.isEnabled = false
                binding.btnClickMe.isEnabled = false
            }
        }
    }
}
