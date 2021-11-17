package com.wanted.wantedproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import kotlinx.coroutines.*
import timber.log.Timber
import uk.co.jakebreen.sendgridandroid.SendGrid
import uk.co.jakebreen.sendgridandroid.SendGridMail
import kotlin.coroutines.coroutineContext


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     /*  CoroutineScope(Dispatchers.IO).launch {
           sendEmail()
       }*/

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