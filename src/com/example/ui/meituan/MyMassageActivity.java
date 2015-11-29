package com.example.ui.meituan;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.example.meituan.R;

public class MyMassageActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.meituen_my_view);
	}
}
