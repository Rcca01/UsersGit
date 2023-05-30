package com.example.projectteste.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Adapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.projectteste.adapter.UserAdapter
import com.example.projectteste.databinding.ActivityMainBinding
import com.example.projectteste.viewmodel.UserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity: AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val userViewModel : UserViewModel by viewModel()
    private val adapterList: UserAdapter = UserAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setListenerListUsers()
        setListFault()
        binding.recycleView.adapter = adapterList
        binding.btnShowList.setOnClickListener {
            binding.loadingList.visibility = View.VISIBLE
            userViewModel.getAllUsers()
        }
    }

    private fun setListenerListUsers(){
        userViewModel.listUsers().observe(this, Observer {
            adapterList.setUsers(it)
            binding.loadingList.visibility = View.GONE
        })
    }

    private fun setListFault(){
        userViewModel.statusError().observe(this, Observer { message ->
            binding.loadingList.visibility = View.GONE
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        })
    }
}