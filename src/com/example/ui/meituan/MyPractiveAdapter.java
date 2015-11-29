package com.example.ui.meituan;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.meituan.R;

public class MyPractiveAdapter extends Activity {
	private ImageButton mSearchButton;
	private ListView mPtListView;
	private Spinner mSpinnerlist;
	private long mExitTime;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);//将题目隐藏
		
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
		setContentView(R.layout.adapter_practive);
		mPtListView = (ListView) findViewById(R.id.practive_item_list);
		setData(list);
		PractiveAdapter adapter = new PractiveAdapter(this);
		adapter.setList(list);
		mPtListView.setAdapter(adapter);
		//=================================
		/*
		 * 设置下拉列表
		 * */
		setSpannerOne();
		setSpannerTwo();
		setSpannerThree();
		setspannerfour();
		//====================================
		
		mSearchButton = (ImageButton) findViewById(R.id.search_Txt);
	
		mSearchButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				startActivity(new Intent(MyPractiveAdapter.this, PractiveTwoAdapter.class));
			}
		});
		
		
		
	}
	
	
	
	//设置下拉列表1
	public void setSpannerOne(){
		String[] spanner1 = {"美食","1","2","3","4"};
		mSpinnerlist = (Spinner) findViewById(R.id.spinner_1_item);
		ArrayAdapter adapter2 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, spanner1);
		mSpinnerlist.setAdapter(adapter2);
		mSpinnerlist.setSelection(0, false);//默认选中第几个，从0开始，后面true或false无用
		mSpinnerlist.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(MyPractiveAdapter.this, "arg2-------"+arg2, Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	//设置下拉列表2
	public void setSpannerTwo(){
		String[] spanner2 = {"全城","1","2","3","4"};
		mSpinnerlist = (Spinner) findViewById(R.id.spinner_2_item);
		ArrayAdapter adapter3 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, spanner2);
		mSpinnerlist.setAdapter(adapter3);
	}
	//设置下拉列表3
	public void setSpannerThree(){
		String[] spannner3 = {"智能排序","1","2","3","4"};
		mSpinnerlist = (Spinner) findViewById(R.id.spinner_3_item);
		ArrayAdapter adapter4 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, spannner3);
		mSpinnerlist.setAdapter(adapter4);
	}
	//设置下拉列表4
	public void setspannerfour(){
		String[] spanner4 = {"筛选","1","2","3","4"};
		mSpinnerlist = (Spinner) findViewById(R.id.spinner_4_item);
		ArrayAdapter adapter5 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, spanner4);
		mSpinnerlist.setAdapter(adapter5);
	}
	/*
	 * 数据源设置
	 * */
	public void setData(ArrayList<HashMap<String, Object>> list){
		HashMap<String, Object> item = new HashMap<String, Object>();
		item.put("iconImage1", R.drawable.meituan_image1);
		item.put("iconImage2", R.drawable.ic_label_nobooking);
		item.put("title", "天府美食坊");
		item.put("descripe", "代金卷全场可用");
		item.put("price", "9.9元");
		item.put("deletprice", "20元");
		item.put("grade", "4.1分（1200）");
		item.put("iconprice", R.drawable.listitem_divide);
		list.add(item);
		
		item = new HashMap<String, Object>();
		item.put("iconImage1", R.drawable.meituan_image3);
		item.put("iconImage2", R.drawable.ic_label_nobooking);
		item.put("title", "339旋转餐厅");
		item.put("descripe", "100元代金券1张，全场通用，可叠加使用");
		item.put("price", "19.9元");
		item.put("deletprice", "30元");
		item.put("iconprice", R.drawable.listitem_divide);
		item.put("grade", "4.2分（2200）");
		list.add(item);
		
		item = new HashMap<String, Object>();
		item.put("iconImage1", R.drawable.meituan_image8);
		item.put("iconImage2", R.drawable.ic_label_nobooking);
		item.put("title", "码头故事（二号桥店）");
		item.put("descripe", "铁板饭2选1，有赠品，提供免费WiFi");
		item.put("price", "29.9元");
		item.put("deletprice", "");
		item.put("iconprice", R.drawable.pe);
		item.put("grade", "4.3分（3200）");
		list.add(item);
		
		item = new HashMap<String, Object>();
		item.put("iconImage1", R.drawable.meituan_image1);
		item.put("iconImage2", R.drawable.ic_label_nobooking);
		item.put("title", "爱客得（航空港店）");
		item.put("descripe", "饮品8选1，提供免费WiFi，美味不停歇");
		item.put("price", "39.9元");
		item.put("deletprice", "50元");
		item.put("iconprice",R.drawable.listitem_divide);
		item.put("grade", "4.4分（4200）");
		list.add(item);
		
		item = new HashMap<String, Object>();
		item.put("iconImage1", R.drawable.meituan_image3);
		item.put("iconImage2", R.drawable.ic_label_nobooking);
		item.put("title", "一洋刺身（建设路店）");
		item.put("descripe", "美味蒸蛋1份，提供免费WiFi，美味不停歇");
		item.put("price", "49.9元");
		item.put("deletprice", "60元");
		item.put("iconprice", R.drawable.listitem_divide);
		item.put("grade", "4.5分（5200）");
		list.add(item);
		
		item = new HashMap<String, Object>();
		item.put("iconImage1", R.drawable.meituan_image8);
		item.put("iconImage2", R.drawable.ic_label_nobooking);
		item.put("title", "澳洲肥牛捞捞锅（盐市口店）");
		item.put("descripe", "单人自助，提供免费WiFi");
		item.put("price", "59.9元");
		item.put("deletprice", "70元");
		item.put("iconprice", R.drawable.listitem_divide);
		item.put("grade", "4.6分（6200）");
		list.add(item);
		
		item = new HashMap<String, Object>();
		item.put("iconImage1", R.drawable.meituan_image1);
		item.put("iconImage2", R.drawable.ic_label_nobooking);
		item.put("title", "吉布鲁牛排●海鲜自助");
		item.put("descripe", "精品黄焖兔，建议2-3人使用，提供免费WiFi");
		item.put("price", "69.9元");
		item.put("deletprice", "89元");
		item.put("iconprice", R.drawable.listitem_divide);
		item.put("grade", "4.7分（7200）");
		list.add(item);
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
                if ((System.currentTimeMillis() - mExitTime) > 2000) {
                        Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                        mExitTime = System.currentTimeMillis();

                } else {
                        finish();
                }
                return true;
        }
        return super.onKeyDown(keyCode, event);
}
	
}
