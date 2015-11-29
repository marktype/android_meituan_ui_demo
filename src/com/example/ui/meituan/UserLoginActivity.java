package com.example.ui.meituan;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.meituan.R;

public class UserLoginActivity extends Activity {
	private EditText mUserName, mPassword;
	private Button mLoginBtn;
	private CheckBox mCheckBox;
	private MyDataBase myData;
	private ArrayList<String> data;
	private String name;
	private String password;
	private SharedPreferences mSharePreferences;
	private static final String USER_NAME = "name";
	private static final String USER_PASSWORD = "password";
	private static final String NAME = "com.example.meituan.userInfo";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.meituan_login_layout);

		mUserName = (EditText) findViewById(R.id.meituan_user_name_edt_txt);
		mPassword = (EditText) findViewById(R.id.meituan_password_edt_txt);

		mPassword.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				password = (String) mPassword.getText().toString();

			}
		});
		mUserName.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				name = (String) mUserName.getText().toString();

			}
		});
		setUserNamePassword();// 获取数据

		myData = new MyDataBase(this);

		mLoginBtn = (Button) findViewById(R.id.meituan_enter_btn);

		mCheckBox = (CheckBox) findViewById(R.id.meituan_get_password_box);

		mLoginBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				String strUser = name + "\t" + password;
				data = myData.queryByString();
				if (data.contains(strUser)) {
					startActivity(new Intent(UserLoginActivity.this,
							ViewPagerAdapter.class));
					finish();
				} else {
					new AlertDialog.Builder(UserLoginActivity.this)
							.setTitle("提示信息")
							.setMessage("输入错误，请填写正确的用户和密码！")
							.setNeutralButton("确定",
									new DialogInterface.OnClickListener() {

										@Override
										public void onClick(
												DialogInterface dialog,
												int which) {

										}
									}).create().show();
				}

			}
		});
	}

	/*
	 * 选中后，即添加数据到sharepreference
	 */
	public void onCheckBox(View v) {
		CheckBox cBox = (CheckBox) v;
		if (cBox.isChecked()) {
			SharedPreferences.Editor editor = mSharePreferences.edit();
			editor.putString(USER_NAME, name);
			editor.putString(USER_PASSWORD, password);
			editor.commit();
		}

	}

	/*
	 * 从sharepreference获取数据
	 */
	public void setUserNamePassword() {
		mSharePreferences = getSharedPreferences(UserLoginActivity.NAME,
				MODE_PRIVATE);

		String msgName = mSharePreferences.getString(USER_NAME, "");
		String password = mSharePreferences.getString(USER_PASSWORD, "");
		if (msgName != null && password != null) {
			mUserName.setText(msgName);
			mPassword.setText(password);
		}

	}

	/*
	 * 点击返回弹出对话框
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_BACK) {
			dialog();
		}

		return true;

	}

	public void dialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("提示");
		builder.setMessage("确认要退出？");
		builder.setNegativeButton("否", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});

		builder.setPositiveButton("是", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				finish();
			}
		});
		builder.create().show();
	}

	public void onRegisterActivity(View v) {
		startActivity(new Intent(this, DBActivity.class));
	}
}
