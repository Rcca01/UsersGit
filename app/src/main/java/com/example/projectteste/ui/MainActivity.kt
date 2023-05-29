package com.example.projectteste.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.projectteste.databinding.ActivityMainBinding
import com.example.projectteste.viewmodel.UserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity: AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val userViewModel : UserViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setListenerListUsers()
        binding.btnShowList.setOnClickListener {
            userViewModel.getAllUsers()
        }
    }

    private fun setListenerListUsers(){
        userViewModel.listUsers().observe(this, Observer {
            Toast.makeText(this, "Lista ok", Toast.LENGTH_LONG).show()
        })
    }
}