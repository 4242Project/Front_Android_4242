package com.wanted.wantedproject.viewmodels

import androidx.lifecycle.ViewModel
import timber.log.Timber
import uk.co.jakebreen.sendgridandroid.SendGrid
import uk.co.jakebreen.sendgridandroid.SendGridMail

class RegisterViewModel : ViewModel() {

    fun sendEmail() {
        val sendgrid = SendGrid.create("APIKEY")
        val email = SendGridMail()

        email.addRecipient("email", "name")
        email.setFrom("email", "name")
        email.setSubject("text")
        email.setContent("context")

        val response = sendgrid.send(email)

        if (response.call().isSuccessful)
            Timber.d("success")
        else
            Timber.d(response.call().errorMessage)

    }
}