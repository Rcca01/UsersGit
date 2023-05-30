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
import com.example.projectteste.sealed.NetworkViewState
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
        binding.recycleView.adapter = adapterList
        binding.btnShowList.setOnClickListener {
            showLoading()
            userViewModel.getAllUsers()
        }
    }

    private fun setListenerListUsers(){
        userViewModel.listUsers().observe(this, Observer { networkViewState ->
            when(networkViewState){
                is NetworkViewState.Success -> {
                    adapterList.setUsers(networkViewState.data)
                    hideLoading()
                }
                is NetworkViewState.Error -> {
                    showErrorMessage(networkViewState.message)
                    hideLoading()
                }
                is NetworkViewState.Loading -> {
                    showLoading()
                }
            }
        })
    }

    private fun showErrorMessage(message:String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun showLoading(){
        binding.loadingList.visibility = View.VISIBLE
    }

    private fun hideLoading(){
        binding.loadingList.visibility = View.GONE
    }
}