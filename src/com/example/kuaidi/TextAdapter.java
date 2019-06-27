package com.example.kuaidi;

import java.util.List;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TextAdapter extends BaseAdapter {
	private List<Remark> list;
	private Context context;

	public TextAdapter(List<Remark> list, Context context) {
		super();
		this.list = list;
		this.context = context;
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
		// TODO Auto-generated method stub
		LinearLayout ll = null;
		if (convertView != null) {
			ll = (LinearLayout) convertView;
		} else {
			ll = (LinearLayout) LayoutInflater.from(context).inflate(
					R.layout.item, null);
		}
		TextView datetime = (TextView) ll.findViewById(R.id.datetime);
		TextView remark = (TextView) ll.findViewById(R.id.remark);
		remark.setText(list.get(position).getRemark());
		datetime.setText(list.get(position).getDatetime());

		return ll;
	}

}
