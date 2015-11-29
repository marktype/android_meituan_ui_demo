package com.example.ui.meituan;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meituan.R;

public class DBActivity extends Activity {

	private Button mAddBtn, mQueryBtn;
	private TextView mNameTxt, mPasswordTxt;
	private MyDataBase mMyBase;
	ArrayList<String> data;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.db_activity);
		mMyBase = new MyDataBase(this);

		mNameTxt = (TextView) findViewById(R.id.db_name_txt);
		mPasswordTxt = (TextView) findViewById(R.id.db_password_txt);

		mAddBtn = (Button) findViewById(R.id.db_add_btn);
		mQueryBtn = (Button) findViewById(R.id.db_query_btn);
		
		
		
		mAddBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String name = (String) mNameTxt.getText().toString();
				String password = (String) mPasswordTxt.getText().toString();
				
				String str = name+"\t"+password;
				data = mMyBase.queryByString();
				if (data.contains(str)) {
					Toast.makeText(DBActivity.this, "此用户已存在", Toast.LENGTH_SHORT)
					.show();
				}else {
					if (name.equals("")||password.equals("")) {
						Toast.makeText(DBActivity.this, "密码或账户不能为空", Toast.LENGTH_SHORT)
						.show();
					}else {
						
						mMyBase.add(name, password);
						Toast.makeText(DBActivity.this, "注册成功", Toast.LENGTH_SHORT)
						.show();
					}
					
				}
				
				
				

			}
		});

		mQueryBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}

	
}
