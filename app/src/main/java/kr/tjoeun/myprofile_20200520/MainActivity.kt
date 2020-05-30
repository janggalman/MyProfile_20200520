package kr.tjoeun.myprofile_20200520

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQ_FOR_NICKNAME = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nickBtn.setOnClickListener {
            val myIntent = Intent(this , NickChangeActivity::class.java)

            startActivityForResult(myIntent ,REQ_FOR_NICKNAME )

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQ_FOR_NICKNAME)
        {
            if (resultCode == Activity.RESULT_OK)
            {
                val newNickName = data?.getStringExtra("nick")

                nickNameTxt.text = newNickName

            }

        }
    }
}
