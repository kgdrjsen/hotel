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

class SignInActivity : AppCompatActivity() {

    private val btid : TextView by lazy { findViewById(R.id.et_id) }
    private val btps : TextView by lazy { findViewById(R.id.et_password) }

    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val etId = findViewById<EditText>(R.id.et_id)
        val etPass = findViewById<EditText>(R.id.et_password)
        val btn_sign = findViewById<Button>(R.id.btn_sign)

        activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val id = it.data?.getStringExtra("et_id") ?: ""
                btid.text = id
                val pw = it.data?.getStringExtra("et_pass") ?: ""
                btps.text = pw
            }

        }


        btn_sign.setOnClickListener {
            if (etId.text.toString().equals("") || etPass.text.toString().equals("")) {
                Toast.makeText(applicationContext, "아이디와 비밀번호를 제대로 입력하시오.", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(applicationContext, "로그인 합니다.", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("et_id", etId.text.toString())
                startActivity(intent)
            }

        }

        val btn_join = findViewById<Button>(R.id.btn_join)
        btn_join.setOnClickListener {
            val intent = Intent(this,SignUpActivity::class.java)
            activityResultLauncher.launch(intent)

        }


    }

}