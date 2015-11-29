package com.example.ui.meituan;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import com.example.meituan.R;

public class StartImageActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.meituan_home_image);
		
		final Intent it = new Intent(this, UserLoginActivity.class); //你要转向的Activity   
		Timer timer = new Timer(); //时间延时器
		TimerTask task = new TimerTask() {  
		    @Override  
		    public void run() {   
		    startActivity(it); //执行  
		    finish();
		     } 
		 };
		timer.schedule(task, 1000 * 2); //2秒后
			
	}
}
