package com.example.ui.meituan;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.meituan.R;

public class MyListAdapter extends BaseAdapter {
	private ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
	private LayoutInflater inflater;
	public MyListAdapter(Context context) {
		
		inflater = LayoutInflater.from(context);
	}
	public void setList(ArrayList<HashMap<String, Object>> list) {
		this.list = list;
		notifyDataSetChanged();//更新数据
	}
	@Override
	public int getCount() {
		
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.meituan_listview_mode, null);
			viewHolder = new ViewHolder();
		
			viewHolder.iconImage = (ImageView) convertView.findViewById(R.id.meituan_content_img);
			viewHolder.title = (TextView) convertView.findViewById(R.id.meituan_content_img_txt);
			viewHolder.price = (TextView) convertView.findViewById(R.id.meituen_price_one_txt);
			convertView.setTag(viewHolder);
		}else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		HashMap<String, Object> item = (HashMap<String, Object>) getItem(position);
		int icon = (Integer) item.get("img");
		String title = (String) item.get("title");
		String price = (String) item.get("price");
		
		viewHolder.iconImage.setImageResource(icon);
		viewHolder.title.setText(title);
		viewHolder.price.setText(setSpannableFontAndColor(price));
		
		return convertView;
	}
	
	public SpannableString setSpannableFontAndColor(CharSequence sequence){
		SpannableString string = new SpannableString(sequence);
		
		
		//设置字体颜色
		string.setSpan(new ForegroundColorSpan(Color.WHITE),0, 
				4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		string.setSpan(new BackgroundColorSpan(R.drawable.a1g), 0,
				4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		
		
		string.setSpan(new AbsoluteSizeSpan(23, true),5, string.length(),
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		//设置字体颜色
		string.setSpan(new ForegroundColorSpan(Color.argb(255, 47, 183, 171)),5, 
				string.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		
		return string;
	}
	
	
	
	class ViewHolder{
		ImageView iconImage;
		TextView title,price;
	}

}
