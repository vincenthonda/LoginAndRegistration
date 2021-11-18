package com.example.loginandregistration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loginandregistration.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding:ActivityLoginBinding

    //any time you need what would have been a static variable in Java, use companion object in Kotlin. You access with ClassName.Variable_Name like Math.pi
    companion object{
        //keys for the key-value pairs for the intent extras
        val EXTRA_USERNAME = "username"
        val EXTRA_PASSWORD = "password"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textCreateaccount.setOnClickListener{
            //launch the registration activity
            // pass the values of username and password along to the the new activity
            //1. extract any information you might need from edit texts.
            val username = binding.textUsernameLogin.text.toString()
            val password = binding.textPasswordLogin.text.toString()

           //2. Create the intent and package the extras
           // The context is the activity you are in(here we can use this)
            val registrationIntent = Intent(this,RegistrationActivity::class.java).apply {
                putExtra(EXTRA_USERNAME,username)
                putExtra(EXTRA_PASSWORD,password)
            }
            //3. Launch the activity
            startActivity(registrationIntent)
        }


    }
}