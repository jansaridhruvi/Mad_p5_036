package com.example.mad_p5_036

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn:Button=findViewById(R.id.btn_url);
        var btn_c:Button=findViewById(R.id.btn_camera);
        var e_url:EditText=findViewById(R.id.e_url);
        var e_phone:EditText=findViewById(R.id.e_phone);
        var btn_call:Button=findViewById(R.id.btn_call);
        var btn_call_log:Button=findViewById(R.id.btn_call_log);
        var btn_gallery:Button=findViewById(R.id.btn_gallery);
        var btn_alarm:Button=findViewById(R.id.btn_alarm);
        btn.setOnClickListener(){
            open_browser(e_url.text.toString());
        }
        btn_c.setOnClickListener(){
            open_camera();
        }
        btn_alarm.setOnClickListener(){
            open_alarm();
        }
        btn_call.setOnClickListener(){
            open_call(e_phone.text.toString())
        }
        btn_call_log.setOnClickListener(){
            open_call_log();
        }
        btn_gallery.setOnClickListener(){
            open_gallery();
        }
    }
    fun open_browser(url:String){
        Intent(Intent.ACTION_VIEW, Uri.parse(url)).also { startActivity(it) }
    }
    fun open_call(num:String){
        val takePictureIntent = Intent(Intent.ACTION_DIAL);
        takePictureIntent.setData(Uri.parse("tel: ${num}"))
        startActivity(takePictureIntent);
    }
    fun open_call_log(){
        var intent=Intent(Intent.ACTION_VIEW,Uri.parse("content://call_log/calls"));
        startActivity(intent);
    }
    fun open_gallery(){
        Intent(Intent.ACTION_PICK).setType("image/*").also { startActivity(it) };
    }
    fun open_camera(){
        var intent=Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
    }
    fun open_alarm(){
        val ALARM = Intent(AlarmClock.ACTION_SET_ALARM);
        startActivity(ALARM)
    }
}