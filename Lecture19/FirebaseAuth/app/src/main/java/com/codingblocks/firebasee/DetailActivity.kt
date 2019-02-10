package com.codingblocks.firebasee

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setUserData()

        btnLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            finish()
        }

        btnEmail.setOnClickListener {
            FirebaseAuth.getInstance().currentUser?.sendEmailVerification()
                ?.addOnFailureListener {
                    it.printStackTrace()
                    Toast.makeText(this, "Failed to send email!", Toast.LENGTH_SHORT).show()
                }
                ?.addOnSuccessListener {
                    Toast.makeText(this, "Please check your email!", Toast.LENGTH_SHORT).show()
                }
        }

        btnUpdateProfile.setOnClickListener {
            val name = etName.text.toString()
            val profilePic = etPic.text.toString()

            val userProfileChangeRequest: UserProfileChangeRequest = UserProfileChangeRequest.Builder()
                .setDisplayName(name)
                .setPhotoUri(Uri.parse(profilePic))
                .build()

            FirebaseAuth.getInstance().currentUser?.updateProfile(userProfileChangeRequest)
                ?.addOnSuccessListener {
                    setUserData()
                }
        }

    }

    private fun setUserData() {
        val currentUser: FirebaseUser? = FirebaseAuth.getInstance().currentUser

        currentUser?.let {
            //run if the currentUser is not null
            tvUserEmail.text = it.email
            tvUserUid.text = it.uid
            tvUserExtra.text = it.providers!![0]
            tvName.text = it.displayName

            Picasso.get().load(it.photoUrl).into(ivProfile)

        } ?: kotlin.run {
            //run if the currentUser is null
        }
    }
}
