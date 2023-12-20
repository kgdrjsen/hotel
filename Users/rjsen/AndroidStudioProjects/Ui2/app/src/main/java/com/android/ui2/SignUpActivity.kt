package com.android.ui2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val et_name = findViewById<EditText>(R.id.et_upname)
        val et_id = findViewById<EditText>(R.id.et_upid)
        val et_pass = findViewById<EditText>(R.id.et_uppass)
        val btn_ssign = findViewById<Button>(R.id.btn_ssin)



        btn_ssign.setOnClickListener {

            if (et_name.text.toString().trim().isEmpty() || et_id.text.toString().trim().isEmpty() || et_pass.text.toString().trim().isEmpty()){
//            if (et_name.text.toString().equals("") || et_id.text.toString().equals("") || et_pass.text.toString().equals("")
//            ) {
                Toast.makeText(applicationContext, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(applicationContext, "가입합니다.", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, SignInActivity::class.java).apply {
                    putExtra("et_id", et_id.text.toString())
                    putExtra("et_pass", et_pass.text.toString())
                }


//                val intent = Intent(this, SignInActivity::class.java)
//                intent.putExtra("et_id", et_id.text.toString())
//                intent.putExtra("et_pass", et_pass.text.toString())

                setResult(RESULT_OK, intent)
                if (!isFinishing) finish()

            }

        }
        val btn_back = findViewById<Button>(R.id.btn_back)
        btn_back.setOnClickListener {
            val intent2 = Intent(this, SignInActivity::class.java)
            startActivity(intent2)
        }
    }


}



