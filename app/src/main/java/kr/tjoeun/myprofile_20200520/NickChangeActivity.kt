package kr.tjoeun.myprofile_20200520

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_nick_change.*

class NickChangeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nick_change)

        val nickGetName = intent.getStringExtra("nowNickName")

        nickTxt.setText(nickGetName)

        nickChgBtn.setOnClickListener {

            val nickName = nickTxt.text.toString()

            val myIntent = Intent()
            myIntent.putExtra("nick" , nickName)

            setResult(Activity.RESULT_OK , myIntent)
            finish()

        }
    }
}
