package com.ironelder.codelabdagger.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ironelder.codelabdagger.MyApplication
import com.ironelder.codelabdagger.R
import com.ironelder.codelabdagger.login.LoginActivity
import com.ironelder.codelabdagger.registration.RegistrationActivity
import com.ironelder.codelabdagger.settings.SettingsActivity
import com.ironelder.codelabdagger.user.UserManager
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var userManager:UserManager

    /**
     * If the User is not registered, RegistrationActivity will be launched,
     * If the User is not logged in, LoginActivity will be launched,
     * else carry on with MainActivity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)

        if (!userManager.isUserLoggedIn()) {
            if (!userManager.isUserRegistered()) {
                startActivity(Intent(this, RegistrationActivity::class.java))
                finish()
            } else {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        } else {
            setContentView(R.layout.activity_main)
            setupViews()
        }
    }

    /**
     * Updating unread notifications onResume because they can get updated on SettingsActivity
     */
    override fun onResume() {
        super.onResume()
        findViewById<TextView>(R.id.notifications).text = mainViewModel.notificationsText
    }

    private fun setupViews() {
        findViewById<TextView>(R.id.hello).text = mainViewModel.welcomeText
        findViewById<Button>(R.id.logout).setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
    }
}
