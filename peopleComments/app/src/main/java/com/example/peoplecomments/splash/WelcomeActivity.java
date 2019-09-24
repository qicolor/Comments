package com.example.peoplecomments.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.peoplecomments.MainActivity;
import com.example.peoplecomments.R;
import com.example.peoplecomments.Utils.ShareUtils;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 启动页
 */
public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
       /* new Handler(new Handler.Callback() {
            //处理接收到消息的方法
            @Override
            public boolean handleMessage(Message msg) {
                //跳转页面
                startActivity(new Intent(getApplication(),MainActivity.class));
                finish();
                return false;
            }
            //发送延迟信息
        }).sendEmptyMessageDelayed(0, 5000);*/

        Timer mTimer=new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                //跳转页面
                //判断是否第一次进入app 是否尽在引导页
                Boolean isFirst = ShareUtils.getWelcomeShare(getApplicationContext());
                if(isFirst){
                    startActivity(new Intent(getBaseContext(),MainActivity.class));
                }else{
                    startActivity(new Intent(getBaseContext(),WelcomeGuildeActivity.class));
                    //保存进入过引导页的信息
                    ShareUtils.putWelcomeShare(getApplicationContext(), true);
                }
                finish();
            }
        }, 3000);
    }




}
