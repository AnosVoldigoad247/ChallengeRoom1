package com.example.challengeroom1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.challengeroom1.Room.DbSmkSa
import com.example.challengeroom1.Room.TbSiswa
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditActivity : AppCompatActivity() {
    val db by lazy { DbSmkSa(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        saveData()
    }

    private fun saveData(){
        btnSimpan.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.Siswao().addSiswa(
                    TbSiswa(edit_nis.text.toString().toInt(),edit_nama.text.toString(),edit_kelas.text.toString(),edit_alamat.text.toString())
                )
                finish()
            }
        }
    }
}