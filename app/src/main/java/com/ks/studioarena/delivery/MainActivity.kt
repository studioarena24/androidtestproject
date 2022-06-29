package com.ks.studioarena.delivery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    var fragment_number = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        receiveDate(1)
    }

    fun receiveDate(i: Int) {
        if(fragment_number != i) {
            fragment_number = i
        }

        when(fragment_number) {
            1 ->
                supportFragmentManager.beginTransaction()
                    .replace(R.id.mainFrameLayout, SplashFragment())
                    .commit()
            2 ->
                supportFragmentManager.beginTransaction()
                    .replace(R.id.mainFrameLayout, SignUpFragment())
                    .commit()
            3 ->
                supportFragmentManager.beginTransaction()
                    .replace(R.id.mainFrameLayout, MainFragment())
                    .commit()
        }
    }
}