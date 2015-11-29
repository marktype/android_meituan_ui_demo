package com.example.ui.meituan;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meituan.R;

public class MainMassageActivity extends Activity {
	private Spinner mSpinner;
	private GridView mGridView;
	private ListView mListView,mTwoListView,mThreeListView;
	private long mExitTime;
	private ViewPager mViewPager;
	private ArrayList<View> data = new ArrayList<View>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.meituan_main_layout);
		setSpinner();//设置下拉列表
		
		mGridView = (GridView) findViewById(R.id.meituan_gridview);
		String[] from = {"image","title"};
		int[] to = {R.id.tab_image,R.id.tab_menu_txt};
		SimpleAdapter simpleAdapter = new SimpleAdapter(this, setGridViewData(),
				R.layout.tab_own_item_layout, from, to);
		mGridView.setAdapter(simpleAdapter);
		
		mListView = (ListView) findViewById(R.id.meituan_listview);
		MyListAdapter myListAdapter = new MyListAdapter(this);
		myListAdapter.setList(setListViewData());
		mListView.setAdapter(myListAdapter);
		
		mTwoListView = (ListView) findViewById(R.id.meituan_Two_listview);
		MyListAdapter myTwoListAdapter = new MyListAdapter(this);
		myTwoListAdapter.setList(setListViewData());
		mTwoListView.setAdapter(myTwoListAdapter);
		
		mThreeListView = (ListView) findViewById(R.id.meituan_three_listview);
		MyListAdapter myThreeListAdapter = new MyListAdapter(this);
		myThreeListAdapter.setList(setListViewData());
		mThreeListView.setAdapter(myThreeListAdapter);
		
		mViewPager = (ViewPager) findViewById(R.id.meituan_viewpager_view);
		setdata(data);
		MyViewPagerAdapter viewPagerAdapter = new MyViewPagerAdapter();
		mViewPager.setAdapter(viewPagerAdapter);
		viewPagerAdapter.setDataList(data);
		
	}
	
	/*
	 * 设置Spinner
	 * */
	public void setSpinner(){
		String[] city = {"成都","北京","上海","广东","天津"};
		mSpinner = (Spinner) findViewById(R.id.meituan_spinner);
//		mSpinner.setSelection(1, true);
		mSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				TextView v1 = (TextView) arg1;
				v1.setTextColor(Color.WHITE);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, 
				android.R.layout.simple_list_item_1,city);
		mSpinner.setAdapter(arrayAdapter);
	}
	
	
	
	
	/*
	 * 自定义GridView数据
	 * */
	public ArrayList<HashMap<String, Object>> setGridViewData(){
		ArrayList<HashMap<String, Object>> data = new ArrayList<HashMap<String,Object>>();
		HashMap<String, Object> item = new HashMap<String, Object>();
		item.put("image", R.drawable.ic_category_0);
		item.put("title", "美食");
		data.add(item);
		item = new HashMap<String, Object>();
		item.put("image", R.drawable.ic_category_1);
		item.put("title", "电影");
		data.add(item);
		item = new HashMap<String, Object>();
		item.put("image", R.drawable.ic_category_2);
		item.put("title", "酒店");
		data.add(item);
		item = new HashMap<String, Object>();
		item.put("image", R.drawable.ic_category_3);
		item.put("title", "KTV");
		data.add(item);
		item.put("image", R.drawable.ic_category_5);
		item.put("title", "代金券");
		data.add(item);
		item = new HashMap<String, Object>();
		item.put("image", R.drawable.ic_category_6);
		item.put("title", "景点门票");
		data.add(item);
		item = new HashMap<String, Object>();
		item.put("image", R.drawable.ic_user_main_favorite);
		item.put("title", "今日更新");
		data.add(item);
		item = new HashMap<String, Object>();
		item.put("image", R.drawable.ic_category_15);
		item.put("title", "更多");
		data.add(item);
		
		return data;
	}
	
	/*
	 * 自定义listView数据
	 * */
	public ArrayList<HashMap<String, Object>> setListViewData(){
		ArrayList<HashMap<String, Object>> data = new ArrayList<HashMap<String,Object>>();
		HashMap<String, Object> item = new HashMap<String, Object>();
		item.put("img", R.drawable.listimage1);
		item.put("title", "澳洲肥牛");
		item.put("price", "23.0 40.0");
		data.add(item);
		item = new HashMap<String, Object>();
		item.put("img", R.drawable.brand_3);
		item.put("title", "釜山料理");
		item.put("price", "24.0 50.0");
		data.add(item);
		item = new HashMap<String, Object>();
		item.put("img", R.drawable.meituan_image2);
		item.put("title", "新石器烤肉");
		item.put("price", "34.0 52.0");
		data.add(item);
		return data;
	}
	/*
	 * 自定义ViewPager
	 * */
	
	public class MyViewPagerAdapter extends PagerAdapter{

		private ArrayList<View> data = new ArrayList<View>();
		
		
		public void setDataList(ArrayList<View> data){
			this.data = data;
			notifyDataSetChanged();
		}
		@Override
		public int getCount() {
			return data.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}
		
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			View v = data.get(position);
			container.addView(v);
			return v;
		}
		
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			
			View v = data.get(position);
			
			container.removeView(v);
		
		}
	}
	/*
	 * 设置滑动页面
	 * */
	public void setdata(ArrayList<View> data){
		
		View v = LayoutInflater.from(this).inflate(R.layout.meituan_viewpager_one, null);
		data.add(v);
		v = LayoutInflater.from(this).inflate(R.layout.meituan_viewpager_two, null);
		data.add(v);
		v = LayoutInflater.from(this).inflate(R.layout.meituan_viewpager_three, null);
		data.add(v);
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
