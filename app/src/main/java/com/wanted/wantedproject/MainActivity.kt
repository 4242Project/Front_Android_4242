package com.wanted.wantedproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import com.wanted.wantedproject.databinding.ActivityMainBinding
import com.wanted.wantedproject.ui.home.MyStampFragment
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
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


        setNavHomeFragment()
        setUi()
    }

    private fun setNavHomeFragment() {

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.main_container) as NavHostFragment
        val navController = navHostFragment.navController

        navController.navigate(R.id.action_global_loginFragment)

         binding.mainToolbar.classNavBtn.setOnClickListener {
             binding.mainToolbar.homeSearchBtn.visibility = View.VISIBLE
             binding.mainToolbar.homeUserBtn.setImageResource(R.drawable.ic_user)
             navController.navigate(R.id.action_global_classFragment)
        }
        
        binding.mainToolbar.myStampNavBtn.setOnClickListener {
            binding.mainToolbar.homeSearchBtn.visibility = View.GONE
            binding.mainToolbar.homeUserBtn.setImageResource(R.drawable.ic_settings)
            navController.navigate(R.id.action_global_myStampFragment)
        }
        binding.mainToolbar.homeSearchBtn.setOnClickListener {
            navController.navigate(R.id.action_global_searchClassFragment)
        }
        binding.mainToolbar.homeUserBtn.setOnClickListener {
            navController.navigate(R.id.action_global_myPageFragment)
        }
    }

    private fun setUi() {
        val dataStore = SaiApplication.getInstance().getDataStore()
        val toolBar = binding.mainToolbar

        lifecycleScope.launch {
            dataStore.toolbarModeFlow.collect {
                toolBar.root.isVisible = it
            }
        }
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