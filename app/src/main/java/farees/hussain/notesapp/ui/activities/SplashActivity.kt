package farees.hussain.notesapp.ui.activities

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import farees.hussain.notesapp.R
import farees.hussain.notesapp.databinding.ActivitySplashBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySplashBinding

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_splash)
        supportActionBar!!.hide()

        CoroutineScope(Dispatchers.Main).launch{
            delay(1500)
            var intent = Intent(this@SplashActivity,MainActivity::class.java)
            var animation = ActivityOptions.makeSceneTransitionAnimation(this@SplashActivity)
            startActivity(intent,animation.toBundle())
            finish()
        }

    }

}