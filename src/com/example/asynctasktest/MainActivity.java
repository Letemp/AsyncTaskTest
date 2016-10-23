package com.example.asynctasktest;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {
	//声明
	private Button myBtn=null;
	private TextView myText=null;
	private ProgressBar myBar=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//注册
		myBtn=(Button)findViewById(R.id.myBtn);
		myText=(TextView)findViewById(R.id.myText);
		myBar=(ProgressBar)findViewById(R.id.myBar);
		//监听
		myBtn.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				DownTask downTask=new DownTask(myText,myBar);
				downTask.execute(100);//每隔0.1秒更新一次
			}
		});
	}
}

	