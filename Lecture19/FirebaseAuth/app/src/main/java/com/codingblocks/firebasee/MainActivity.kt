package com.codingblocks.firebasee

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseAuth.getInstance().addAuthStateListener {

            it.currentUser?.let {
                val intent = Intent(baseContext, DetailActivity::class.java)
                startActivity(intent)
                finish()
            }

        }

        btnLogin.setOnClickListener {

            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)

        }

        btnSignUp.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
        }

        btnGoogle.setOnClickListener {

            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.oauth_id))
                .requestEmail()
                .build()

            val googleSignInClient = GoogleSignIn.getClient(this, gso)

            val signInIntent = googleSignInClient.signInIntent
            startActivityForResult(signInIntent, 12345)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 12345) {

            val accountTask = GoogleSignIn.getSignedInAccountFromIntent(data)

            val account = accountTask.result

            val credentials = GoogleAuthProvider.getCredential(account?.idToken, null)

            FirebaseAuth.getInstance().signInWithCredential(credentials)
        }

    }


}
