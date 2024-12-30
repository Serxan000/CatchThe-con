package com.example.catchthemehdi

import android.media.Image
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.catchthemehdi.databinding.ActivityMainBinding
import java.util.Random

class MainActivity : AppCompatActivity() {
    var xal=0
    val imageArray = ArrayList<ImageView>()
    var runnable=Runnable{}
    var handler = Handler(Looper.getMainLooper())
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        imageArray.add(binding.imageView1)
        imageArray.add(binding.imageView2)
        imageArray.add(binding.imageView3)
        imageArray.add(binding.imageView4)
        imageArray.add(binding.imageView5)
        imageArray.add(binding.imageView6)
        imageArray.add(binding.imageView7)
        imageArray.add(binding.imageView8)
        imageArray.add(binding.imageView9)
        imageArray.add(binding.imageView10)
        imageArray.add(binding.imageView11)
        imageArray.add(binding.imageView12)
        imageArray.add(binding.imageView13)
        imageArray.add(binding.imageView14)
        imageArray.add(binding.imageView15)
        imageArray.add(binding.imageView16)
        imageArray.add(binding.imageView17)
        imageArray.add(binding.imageView18)
        imageArray.add(binding.imageView19)
        imageArray.add(binding.imageView20)
        hideImage()


        object :CountDownTimer(15000,1000){
            override fun onTick(time: Long) {
                    binding.TimeText.text="Time:${time/1000}"
            }

            override fun onFinish() {
                binding.TimeText.text="Game Ended"
                handler.removeCallbacks(runnable)
                for(image in imageArray){
                    image.visibility=View.INVISIBLE
                }
                val alert = AlertDialog.Builder(this@MainActivity)
                alert.setTitle("Kül Başıva ")
                alert.setMessage("Oynuyursan təzdən")
                alert.setPositiveButton("Yes"){dialogInterface,i->
                    val intentFromMain = intent
                    finish()
                    startActivity(intentFromMain)


                }
                alert.setNegativeButton("No"){dialogInterface,i->
                    Toast.makeText(this@MainActivity,"Game Over",Toast.LENGTH_LONG).show()
                }
                alert.show()


            }

        }.start()


    }

    fun hideImage(){

        runnable=object:Runnable{
            override fun run() {
                for(image in imageArray){
                    image.visibility=View.INVISIBLE
                }
                val random = Random()
                val randomIndex = random.nextInt(20)
                imageArray[randomIndex].visibility=View.VISIBLE
                handler.postDelayed(this,300)
            }

        }
        handler.post(runnable)



    }
    fun score(view: View){
         xal+=1
        binding.scoreText.text = "Score:${xal}"

    }
}