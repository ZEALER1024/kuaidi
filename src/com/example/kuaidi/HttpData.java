package com.example.kuaidi;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.os.AsyncTask;

/**
 * Params 访问地址 
 * rul Progress 需要做进度条 Viod 
 * Result 问访问网络最后得到结 果
 */
public class HttpData extends AsyncTask<String, Void, String> {

	private HttpClient client;
	private HttpGet request;
	private HttpResponse httpResponse;
	private HttpEntity httpEntity;
	private String uri;// 访问路径
	private HttpLinster linster;

	public HttpData(String uri, HttpLinster linster) {
		super();
		this.uri = uri;
		this.linster = linster;
	}

	/**
	 * 后台比较耗时操作
	 */
	@Override
	protected String doInBackground(String... params) {

		String res = "";
		try {

			client = new DefaultHttpClient();

			request = new HttpGet(uri);

			httpResponse = client.execute(request);

			httpEntity = httpResponse.getEntity();

			res = EntityUtils.toString(httpEntity);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return res;
	}

	@Override
	protected void onPostExecute(String result) {
		linster.getData(result);
		super.onPostExecute(result);
	}

}
