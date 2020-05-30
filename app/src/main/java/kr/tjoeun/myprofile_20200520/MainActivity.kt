package kr.tjoeun.myprofile_20200520

import android.app.Activity
import android.content.Intent
import android.net.Uri
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

            var nickTxt = nickNameTxt.text.toString()

            if (nickTxt == "본인 닉네임 표시")
            {
                nickTxt = ""
            }
            myIntent.putExtra("nowNickName", nickTxt)
            startActivityForResult(myIntent, REQ_FOR_NICKNAME)
        }

        telBtn.setOnClickListener {

            val phoneNum = telEdt.text.toString().replace("-","")

            val myUri = Uri.parse("tel:${phoneNum}")
            val myIntent = Intent(Intent.ACTION_DIAL , myUri)
            startActivity(myIntent)

        }

        smsBtn.setOnClickListener {

            val myUri = Uri.parse("sms:${telEdt.text.toString()}")
            val myIntent = Intent(Intent.ACTION_SENDTO , myUri)
            myIntent.putExtra("sms_body" , smsEdt.text.toString() )

            startActivity(myIntent)
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
