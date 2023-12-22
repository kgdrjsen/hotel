package com.android.ui2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.constraintlayout.widget.ConstraintLayout

class SignInActivity : AppCompatActivity() {

//    private val btid : TextView by lazy { findViewById(R.id.et_id) }
//    private val btps : TextView by lazy { findViewById(R.id.et_password) }

    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val etId = findViewById<EditText>(R.id.et_id)
        val etPass = findViewById<EditText>(R.id.et_password)
        val btn_sign = findViewById<ConstraintLayout>(R.id.btn_sign)

        activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val id = it.data?.getStringExtra("et_id") ?: ""
                val pw = it.data?.getStringExtra("et_pass") ?: ""
                etId.setText(id)
                etPass.setText(pw)
            }
        }

//  위에 private 두개와 함께 썼던 문장 , 그리고 받아올때 그냥 text보다 setText()를 쓰면 더 간단해 보임.
//        activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
//            if (it.resultCode == RESULT_OK) {
//                val id = it.data?.getStringExtra("et_id") ?: ""
//                btid.text = id
//                val pw = it.data?.getStringExtra("et_pass") ?: ""
//                btps.text = pw
//            }
//
//        }


        btn_sign.setOnClickListener {
            if (etId.text.toString().trim().isEmpty() || etPass.text.toString().trim().isEmpty()) {
//
//            이전에 썼던 equals 대신 trim과 isEmpty로 여백이 있는지 그리고 칸이 비었는지 확인
//            if (etId.text.toString().equals("") || etPass.text.toString().equals("")) {
                Toast.makeText(this, getString(R.string.toast_msg_noinput), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                Toast.makeText(this,getString(R.string.toast_msg_login), Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("et_id", etId.text.toString())
                startActivity(intent)
            }

        }

        val btn_join = findViewById<ConstraintLayout>(R.id.btn_join)
        btn_join.setOnClickListener {
//          필수과제 / 밑은 선택과제
//          val intent = Intent(this,SignUpActivity::clss.java)
//          startActivity(intent)

            val intent = Intent(this,SignUpActivity::class.java)
            activityResultLauncher.launch(intent)

        }


    }

}