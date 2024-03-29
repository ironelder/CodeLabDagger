package com.ironelder.codelabdagger.registration


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ironelder.codelabdagger.MyApplication
import com.ironelder.codelabdagger.R
import com.ironelder.codelabdagger.main.MainActivity
import com.ironelder.codelabdagger.registration.enterdetails.EnterDetailsFragment
import com.ironelder.codelabdagger.registration.termsandconditions.TermsAndConditionsFragment
import javax.inject.Inject

class RegistrationActivity : AppCompatActivity() {

    @Inject
    lateinit var registrationViewModel: RegistrationViewModel

    lateinit var registrationComponent: RegistrationComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        registrationComponent =
            (application as MyApplication).appComponent.registrationComponent().create()
        registrationComponent.inject(
            this
        )

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_holder, EnterDetailsFragment())
            .commit()
    }

    /**
     * Callback from EnterDetailsFragment when username and password has been entered
     */
    fun onDetailsEntered() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_holder, TermsAndConditionsFragment())
            .addToBackStack(TermsAndConditionsFragment::class.java.simpleName)
            .commit()
    }

    /**
     * Callback from T&CsFragment when TCs have been accepted
     */
    fun onTermsAndConditionsAccepted() {
        registrationViewModel.registerUser()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }
}
