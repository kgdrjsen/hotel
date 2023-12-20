package com.android.ui2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import kotlin.random.Random

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val randomImg = findViewById<ImageView>(R.id.iv_home)
        when(Random.nextInt(1,5)) {
            1 -> randomImg.setImageResource(R.drawable.dae_vak1)
            2 -> randomImg.setImageResource(R.drawable.dae_vak2)
            3 -> randomImg.setImageResource(R.drawable.dae_vak3)
            4 -> randomImg.setImageResource(R.drawable.dae_vak4)
        }

        val idData = intent.getStringExtra("et_id")
        val etData = findViewById<EditText>(R.id.et_ids)
        etData.setText(idData)

        val btFinish = findViewById<Button>(R.id.btn_finish)
        btFinish.setOnClickListener {
            finish()
        }

        val apFinsih = findViewById<Button>(R.id.btn_apfinish)
        apFinsih.setOnClickListener {
            Toast.makeText(applicationContext, "종료합니다.", Toast.LENGTH_SHORT).show()
            ActivityCompat.finishAffinity(this)
        }
    }

}