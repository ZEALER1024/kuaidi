package com.example.kuaidi;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.os.AsyncTask;

/**
 * Params ���ʵ�ַ 
 * rul Progress ��Ҫ�������� Viod 
 * Result �ʷ����������õ��� ��
 */
public class HttpData extends AsyncTask<String, Void, String> {

	private HttpClient client;
	private HttpGet request;
	private HttpResponse httpResponse;
	private HttpEntity httpEntity;
	private String uri;// ����·��
	private HttpLinster linster;

	public HttpData(String uri, HttpLinster linster) {
		super();
		this.uri = uri;
		this.linster = linster;
	}

	/**
	 * ��̨�ȽϺ�ʱ����
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
