package com.example.ui.meituan;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.meituan.R;

public class TwoListAdapter extends BaseAdapter {
	private ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
	private LayoutInflater inflater;
	public TwoListAdapter(Context context) {
		
		inflater = LayoutInflater.from(context);
	}
	public void setList(ArrayList<HashMap<String, Object>> list) {
		this.list = list;
		notifyDataSetChanged();//更新数据
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
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
			convertView = inflater.inflate(R.layout.meituan_other_item, null);
			viewHolder = new ViewHolder();
		
			viewHolder.iconImage = (ImageView) convertView.findViewById(R.id.meituan_other_img);
			viewHolder.bigTitle = (TextView) convertView.findViewById(R.id.meituan_big_txt);
			viewHolder.smallTitle = (TextView) convertView.findViewById(R.id.meituan_small_txt);
			convertView.setTag(viewHolder);
		}else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		HashMap<String, Object> item = (HashMap<String, Object>) getItem(position);
		int icon = (Integer) item.get("icon");
		String title = (String) item.get("bigTitle");
		String price = (String) item.get("smallTitle");
		
		viewHolder.iconImage.setImageResource(icon);
		viewHolder.bigTitle.setText(title);
		viewHolder.smallTitle.setText(price);
		
		return convertView;
		
		
		
		
		
		
		
		
		
	}

	class ViewHolder{
		ImageView iconImage;
		TextView bigTitle,smallTitle;
	}
}
