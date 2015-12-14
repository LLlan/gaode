package com.lan.gaode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
/**
 * 该应用实现地图的定位，地图覆盖
 * 定位2种：GPS定位（精度高，定位慢）和 网络定位（精度低,定位快（2秒钟左右））
 * 
 * 如果要精度也要速度？
 * 先用网络实现定位，得到粗定位的地址；然后使用GPS定位得到准确地址。
 * 
 * 网络定位：LBS定位（三角定位）
 * 
 * 
 * 
 * 
 */
	private Button but1,but2,but3;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		but1 = (Button)findViewById(R.id.button1);
		but2 = (Button)findViewById(R.id.button2);
		but3 = (Button)findViewById(R.id.button3);
	
		but1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		

		but2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this,Los_1Activity.class));

				
			}
		});
		

		but3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
