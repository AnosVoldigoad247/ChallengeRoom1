package com.example.challengeroom1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.challengeroom1.Room.DbSmkSa
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    val db by lazy { DbSmkSa(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        halEdit()
    }

    override fun onStart() {
        super.onStart()
        CoroutineScope(Dispatchers.IO).launch {
            val siswa = db.Siswao().tampil()
                Log.d("MainActivity","dbResponse: $siswa")
        }
    }

    private fun halEdit() {
        btnCreate.setOnClickListener {
            startActivity(Intent(this,EditActivity::class.java))
        }
    }

}