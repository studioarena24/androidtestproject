package com.ks.studioarena.delivery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUpFragment : Fragment() {

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_sign_up, container, false)

        auth = FirebaseAuth.getInstance()

        val etv_email_signUp = root.findViewById<EditText>(R.id.etv_email)
        val etv_password_signUp = root.findViewById<EditText>(R.id.etv_password)

        val btn_signUp = root.findViewById<Button>(R.id.btn_signUpCheck)
        btn_signUp.setOnClickListener {
            if(etv_email_signUp.text.isEmpty()) {
                Toast.makeText(context, "이메일을 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(etv_password_signUp.text.isEmpty()) {
                Toast.makeText(context, "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val email : String = etv_email_signUp.text.toString().trim()
            val password : String = etv_password_signUp.text.toString().trim()

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Toast.makeText(context, "성공", Toast.LENGTH_LONG).show()
                        val mActivity = activity as MainActivity
                        mActivity.receiveDate(1)
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(context, "회원가입 실패", Toast.LENGTH_LONG).show()
                    }
                }
        }

        return root
    }
}