package com.reivai.userlist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.reivai.userlist.R
import com.reivai.userlist.databinding.ActivityDetailBinding
import com.reivai.userlist.model.User

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val user: User? = intent.getParcelableExtra("user")

        user?.let {
            val separate = it.name.split(" ")
            var firstName = separate.firstOrNull() ?: ""
            var lastName = separate.drop(1).joinToString(" ")

            if (firstName.contains(".")) {
                firstName = separate.drop(1).firstOrNull() ?: ""
                lastName = separate.drop(2).joinToString(" ")

                binding.firstName.text = ": " + firstName
                binding.lastName.text = ": " + lastName
                binding.address.text = ": ${it.address_no}, ${it.street}, ${it.city},\n  ${it.zip_code}, ${it.country}"
                Glide.with(binding.avatar.context)
                    .load(it.avatar)
                    .into(binding.avatar)
            } else {
                binding.firstName.text = ": " + firstName
                binding.lastName.text = ": " + lastName
                binding.address.text = ": ${it.address_no}, ${it.street}, ${it.city},\n  ${it.zip_code}, ${it.country}"
                Glide.with(binding.avatar.context)
                    .load(it.avatar)
                    .into(binding.avatar)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}