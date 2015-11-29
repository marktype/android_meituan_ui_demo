package com.example.ui.meituan;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import com.example.meituan.R;

public class ViewPagerAdapter extends Activity {
	private ViewPager mViewPager;
	private ArrayList<View> data = new ArrayList<View>();
	private ImageView mImageOne,mImageTwo,mImageThree;
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.adapter_viewpager);
		mImageOne = (ImageView) findViewById(R.id.image_choice1);
		mImageTwo = (ImageView) findViewById(R.id.image_choice2);
		mImageThree = (ImageView) findViewById(R.id.image_choice3);
		mViewPager = (ViewPager) findViewById(R.id.viewpager_view);
		setdata(data);
		MyViewPagerAdapter viewPagerAdapter = new MyViewPagerAdapter();
		mViewPager.setAdapter(viewPagerAdapter);
		viewPagerAdapter.setDataList(data);
		
		/*
		 * 页面转换监听，实现下方滚动点的转换
		 * 
		 * */
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(final int arg0) {
				
				
				switch (arg0) {
				case 0:
					mImageOne.setImageResource(R.drawable.dot_choice);
					mImageTwo.setImageResource(R.drawable.dot_no_choice);
					break;
				case 1:
					mImageTwo.setImageResource(R.drawable.dot_choice);
					mImageOne.setImageResource(R.drawable.dot_no_choice);
					mImageThree.setImageResource(R.drawable.dot_no_choice);
					break;
				case 2:
					mImageThree.setImageResource(R.drawable.dot_choice);
					mImageTwo.setImageResource(R.drawable.dot_no_choice);
					startActivity(new Intent(ViewPagerAdapter.this, TabActivityTest.class));
					finish();
					break;
				default:
					break;
				}
			}
			
			@Override
			public void onPageScrolled(final int arg0, final float arg1, final int arg2) {
				
			}
			
			@Override
			public void onPageScrollStateChanged(final int arg0) {
				
			}
		});
	}
	
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
	
	public void setdata(ArrayList<View> data){
		
		View v = LayoutInflater.from(this).inflate(R.layout.adapter_viewpager_item1, null);
		data.add(v);
		v = LayoutInflater.from(this).inflate(R.layout.adapter_viewpager_item2, null);
		data.add(v);
		v = LayoutInflater.from(this).inflate(R.layout.adapter_viewpager_item3, null);
		data.add(v);
	}
}
