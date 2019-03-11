package aula2.dominio.com.br.rgba_calculator50

import android.graphics.Bitmap
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_main.*
import java.security.KeyStore

class MainActivity : AppCompatActivity() {
    lateinit var bitmap:Bitmap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        image_view.isDrawingCacheEnabled = true
        image_view.buildDrawingCache(autoScale:true)

        image_view.setOnTouchListener{v, event ->
            if (event.action == MotionEvent.ACTION_DOWN || event.action == MotionEvent.ACTION_MOVE){
                bitmap = image_view.drawingCache
                val pixel = bitmap.getPixel(event.x.toInt(),event.y.toInt())

                val r = Color.red(pixel)
                val g = Color.green(pixel)
                val b = Color.blue(pixel)

                val hex = "#"+ Integer.toHexString(pixel)
                color_view.setBackgroundColor(Color.rgb(r,g,b))
                //set Hext and RGB values to text view
                result_tv.text = "RGB: $r, $g, $b \nHex: $hex"
            }
                true
        }

    }
}
