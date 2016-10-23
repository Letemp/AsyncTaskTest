package com.example.asynctasktest;

import android.graphics.Color;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

//异步任务处理类
public  class DownTask extends AsyncTask<Integer,Integer,String> {
	//声明
	private TextView tv;
	private ProgressBar pb;
	public DownTask(TextView tv,ProgressBar pb){
		this.tv=tv;//初始化控件
		this.pb=pb;
	}
	//提供一个无参的构造方法
	public DownTask(){
	}
	protected String doInBackground(Integer... param){
		for(int i=0;i<=100;i++){
			publishProgress(i);
			try{
				Thread.sleep(param[0]);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return "下载完毕";
	}
	protected void onPreExecute(){
		super.onPreExecute();
	}
	//执行结束后，相关界面控件属性的设置
	protected void onPostExecute(String result){
		tv.setText(result);
		tv.setTextColor(Color.RED);
		tv.setTextSize(20);
		pb.setVisibility(View.INVISIBLE);
		super.onPostExecute(result);
	}
	//更改界面控件的属性
	protected void onProgressUpdate(Integer...param){
		tv.setText("当前完成任务的"+param[0]+"%");
		pb.setProgress(param[0]);
		tv.setVisibility(View.VISIBLE);
		pb.setVisibility(View.VISIBLE);
		super.onProgressUpdate(param);
	}
	}
