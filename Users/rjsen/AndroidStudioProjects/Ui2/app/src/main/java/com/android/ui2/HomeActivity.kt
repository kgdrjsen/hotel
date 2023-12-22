package com.android.ui2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.core.content.res.ResourcesCompat
import kotlin.random.Random

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val randomImg = findViewById<ImageView>(R.id.iv_home)
        val id = when((1..4).random()) {
            1 -> R.drawable.dae_vak1
            2 -> R.drawable.dae_vak2
            3 -> R.drawable.dae_vak3
            else -> R.drawable.dae_vak4
        }
        randomImg.setImageDrawable(ResourcesCompat.getDrawable(resources,id,null))
//        set다음에 비트맵, 웹에서 다운 등등 여러가지가 있다.

//        위처럼 더 쉬운 코드로
//        when(Random.nextInt(1,5)) {
//            1 -> randomImg.setImageResource(R.drawable.dae_vak1)
//            2 -> randomImg.setImageResource(R.drawable.dae_vak2)
//            3 -> randomImg.setImageResource(R.drawable.dae_vak3)
//            4 -> randomImg.setImageResource(R.drawable.dae_vak4)
//        }

        val idData = intent.getStringExtra("et_id")
        val etData = findViewById<EditText>(R.id.et_ids)
        etData.setText(idData)
//        위처럼 쓰면 "아이디 : " 이 칸을 따로 만들어야 한다...아래 처럼 쓰면 아이디: 까지 따라온다.
//        val etData = findViewById<TextView>(R.id.et_ids)
//        if (intent.hasExtra("et_id")) {
//            etData.text = "아이디 : " + intent.getStringExtra("et_id")
//        }

        val btFinish = findViewById<ConstraintLayout>(R.id.btn_close)
        btFinish.setOnClickListener {
            finish()
        }

        val apFinsih = findViewById<ConstraintLayout>(R.id.btn_app_close)
        apFinsih.setOnClickListener {
            Toast.makeText(this,getString(R.string.toast_msg_exit), Toast.LENGTH_SHORT).show()
            ActivityCompat.finishAffinity(this)
        }
    }

}