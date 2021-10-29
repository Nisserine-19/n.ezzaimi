package fr.zestia.ezzaimi.tp2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var imageView: ImageView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.image_view)
        button = findViewById(R.id.my_button)
        button.setOnClickListener(this)
        loadimage("https://cdn.pixabay.com/photo/2021/08/25/20/42/field-6574455__480.jpg")
    }

    private fun loadimage(url: String) {
        Picasso.get()
            .load(url)
            .resize(900, 700)
            .centerCrop()
            .into(imageView)
    }

    override fun onClick(view: View?) {
        val links = listOf(
            "https://media.istockphoto.com/photos/picturesque-morning-in-plitvice-national-park-colorful-spring-scene-picture-id1093110112?k=20&m=1093110112&s=612x612&w=0&h=3OhKOpvzOSJgwThQmGhshfOnZTvMExZX2R91jNNStBY=",
            "https://www.istockphoto.com/resources/images/PhotoFTLP/FR/NatureLandscapes-508488398.jpg",
            "https://s1.1zoom.me/b4253/620/Texture_Roses_Many_Red_541091_3840x2160.jpg"
        )
        // val linl = "https://media.istockphoto.com/photos/picturesque-morning-in-plitvice-national-park-colorful-spring-scene-picture-id1093110112?k=20&m=1093110112&s=612x612&w=0&h=3OhKOpvzOSJgwThQmGhshfOnZTvMExZX2R91jNNStBY="
        // loadimage(linl)
        loadimage(links.random())
        Toast.makeText(this, "You click me", Toast.LENGTH_LONG).show()
    }
}
