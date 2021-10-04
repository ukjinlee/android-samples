package com.example.lottieanimation

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.airbnb.lottie.LottieAnimationView
import com.example.lottieanimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.animationView.setOnClickListener {
            val heart = it as LottieAnimationView
//            heart.playAnimation()
            Log.d(TAG, "onCreate: ${heart.progress}")

            val isLiked = heart.progress == 0.5f
            val animator = if (isLiked) ValueAnimator.ofFloat(.5f, 1f).setDuration(500)
                else ValueAnimator.ofFloat(0f, .5f).setDuration(1000)
            animator.addUpdateListener { animation ->
                heart.progress = animation.animatedValue as Float
            }
            animator.start()
        }
    }
}