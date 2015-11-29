package com.example.ui.meituan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AutoCompleteTextView;
import android.widget.SimpleAdapter;

import com.example.meituan.R;

public class PractiveTwoAdapter extends Activity {
	private AutoCompleteTextView mCompleteTextView;
	ArrayList<HashMap<String, Object>> data = new ArrayList<HashMap<String,Object>>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);//将题目隐藏
		setContentView(R.layout.practice_search_button);
		
		setSearchResult(data);
		
		
		
		
		
		/*
		 * 搜索自动匹配
		 * */
		
//		String[] searchTxt = {"m美食","m美女","m美食一条街","m美团外卖","美好","mshfhsd"};
//		
//		ArrayAdapter<String> searchAdapter = new ArrayAdapter<String>(this, 
//				android.R.layout.simple_list_item_1, searchTxt);
		
		
		//自定义搜索布局时，此处继承simpleAdapter,资源内容不能为图片，只能为字符串型，否则报错
		mCompleteTextView = (AutoCompleteTextView) findViewById(R.id.search_edit);
		
				String[] from = {"result","finally"};
				int[] to = {R.id.search_result_txt,R.id.search_finally_txt};
				
				AutoCompleteAdapter searchAdapter = new AutoCompleteAdapter(PractiveTwoAdapter.this, data, 
						R.layout.autocomplete_search_item, from, to);
				mCompleteTextView.setAdapter(searchAdapter);
				mCompleteTextView.setThreshold(1);
	}
	public void setSearchResult(ArrayList<HashMap<String, Object>> data){
		HashMap<String, Object> item = new HashMap<String, Object>();
		item.put("result", "m美食");
		item.put("finally", "约有45个团购");
		data.add(item);
		
		item = new HashMap<String, Object>();
		item.put("result", "m美女");
		item.put("finally", "约有45个团购");
		data.add(item);
		
		item = new HashMap<String, Object>();
		item.put("result", "m美食一条街");
		item.put("finally", "约有45个团购");
		data.add(item);
	}
	public void meituanDelButton(View v){
		mCompleteTextView.setText("");
}
	public void imageBack(View v){
		finish();
	}
	public class AutoCompleteAdapter extends SimpleAdapter{

		public AutoCompleteAdapter(Context context,
				List<? extends Map<String, ?>> data, int resource,
				String[] from, int[] to) {
			super(context, data, resource, from, to);
			
			
			
		}
		
		
	}
}
