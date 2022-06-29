package com.ks.studioarena.delivery

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class SplashFragment : Fragment() {

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_splash, container, false)

        auth = FirebaseAuth.getInstance()

        val btn_login = root.findViewById<Button>(R.id.button_login)
        val etv_id = root.findViewById<EditText>(R.id.editTextId)
        val etv_pw = root.findViewById<EditText>(R.id.editTextPw)

        val email : String = etv_id.toString().trim()
        val password : String = etv_pw.toString().trim()

        btn_login.setOnClickListener {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(context, "로그인 성공", Toast.LENGTH_SHORT).show()
                        val mActivity = activity as MainActivity
                        mActivity.receiveDate(3)
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(context, "로그인 실패", Toast.LENGTH_SHORT).show()
                    }
                }
        }

        val btn_signUp = root.findViewById<Button>(R.id.button_signUp)
        btn_signUp.setOnClickListener {
            val mActivity = activity as MainActivity
            mActivity.receiveDate(2)
        }


        return root
    }

}