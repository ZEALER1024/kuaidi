package com.example.kuaidi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

public class Select extends Activity implements HttpLinster {
	private HttpData httpData;
	private String url = "";
	private ArrayList<Remark> list = null;
	// private List<Map<String, Object>> list2=null;
	private TextAdapter adapter;
	Spinner sp;
	Button se;
	EditText Num;
	ListView tv;
	String text;
	String com;
	String[] OTC = { "顺丰", "圆通", "申通", "中通", "韵达", "天天快递", "中国邮政", "百事汇通" };
	String[] num = { "sf", "yt", "sto", "zto", "yd", "tt", "ems", "ht" };
	List<String> aa = Arrays.asList(num);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select);

		sp = (Spinner) findViewById(R.id.spinner);
		se = (Button) findViewById(R.id.button3);
		Num = (EditText) findViewById(R.id.editText1);

		/**
		 * 
		 */
		tv = (ListView) findViewById(R.id.listView1);
		list = new ArrayList<Remark>();
		
		adapter = new TextAdapter(list, this);
		this.adapter.notifyDataSetChanged();
		tv.setAdapter(adapter);
		/**
		 * 
		 */
		Adapter ada = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, OTC);
		sp.setAdapter((SpinnerAdapter) ada);
		sp.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				com = aa.get(arg2);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		});

	}

	public void sele(View v) {
		// text ="662870571462";
		text = Num.getText().toString();
		if (text.equals("")) {
			Toast.makeText(Select.this, "请输入单号", Toast.LENGTH_LONG).show();
		} else {

			url = "http://v.juhe.cn/exp/index?key=76ac4834a1dcb3e73c3b5f2f72841d53&com="
					+ com + "&no=" + text;
			httpData = (HttpData) new HttpData(url, this).execute();
			list.removeAll(list);
			this.adapter.notifyDataSetChanged();
		}

	}

	@Override
	public void getData(String result) {
		// TODO Auto-generated method stub
		
		// ArrayList<String> str = new ArrayList<String>();
		this.parsData(result);
	}

	private void parsData(String json) {
		try {
			JSONObject jb = new JSONObject(json);
			JSONObject jb1 = jb.getJSONObject("result");
			JSONArray jsonArray = jb1.getJSONArray("list");

			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jb2 = jsonArray.getJSONObject(i);
				Remark remark = new Remark(jb2.getString("datetime"),
						jb2.getString("remark"));

				list.add(remark);
			}

			adapter.notifyDataSetChanged();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
