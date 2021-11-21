package com.wanted.wantedproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.wanted.wantedproject.databinding.ActivityMainBinding
import com.wanted.wantedproject.ui.home.ClassFragment
import com.wanted.wantedproject.ui.home.MyStampFragment
import uk.co.jakebreen.sendgridandroid.SendGrid
import uk.co.jakebreen.sendgridandroid.SendGridMail


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
     /*  CoroutineScope(Dispatchers.IO).launch {
           sendEmail()
       }*/

        setOnClick()
    }

    private fun setOnClick() {
        binding.classNavBtn.setOnClickListener {
            setNavHomeFragment(ClassFragment())
        }
        binding.classNavBtn.performClick()

        binding.myStampNavBtn.setOnClickListener {
            setNavHomeFragment(MyStampFragment())
        }
    }

    private fun setNavHomeFragment(fragment : Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, fragment)
            .commit()
    }

   private fun sendEmail() {
       val sendgrid = SendGrid.create("APIKEY")
       val email = SendGridMail()

       email.addRecipient("email", "name")
       email.setFrom("email", "name")
       email.setSubject("text")
       email.setContent("context")

       val response = sendgrid.send(email)

       if(response.call().isSuccessful)
           Log.d("send message", "success")
       else
           Log.d("send error", response.call().errorMessage)

       }

}