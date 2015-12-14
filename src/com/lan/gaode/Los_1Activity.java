package com.lan.gaode;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.location.LocationProviderProxy;

import android.app.Activity;
import android.location.Location;
import android.net.Proxy;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
/**
 * 实现网络定位步骤
 * 0-导入jar文件和so文件
 * 1-
 * 
 * @author Administrator
 *
 */
public class Los_1Activity extends Activity implements AMapLocationListener {
	private TextView tv1;//绑定UI,
	
	LocationManagerProxy Proxy = null;//管理器
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_los_1);
		
		tv1 =(TextView)findViewById(R.id.textView1);
		Proxy =LocationManagerProxy.getInstance(this);//得到定位管理器的
		
		
		
		/*
		 *requestLocationUpdates： 4个参数
		 * 1-是定位的Provider方式，定位方式
		 * 2-是5秒钟后重新定位，定位的最短周期
		 * 3-是10米。定位最短的距离，超过10米重新定位。
		 * 4-是定位监听者
		 * 最耗电：屏幕、WIFI、网络、蓝牙、定位、音频
		 */
		Proxy.requestLocationUpdates(LocationProviderProxy.AMapNetwork, 5000, 10, this);//设置产生定位请求
	}

	@Override
	public void onLocationChanged(Location location) {
		
		
		
		
		
	}

	

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}
	
	
/**
 * 混合定位的回调函数，该回调海曙中得到地理信息
 */
	@Override
	public void onLocationChanged(AMapLocation location) {

		//帮助我们得到地理信息
		if (location != null) {
			Double geoLat = location.getLatitude();//得到纬度
			Double geoLon = location.getLongitude();//得到经度
			
			String  cityCode = "";
			String desc = "";
			Bundle localBundle = location.getExtras();
			if (localBundle != null) {
				cityCode = localBundle.getString("cityCode");//得到城市的编码
				desc =localBundle.getString("desc");//得到地理位置的具体描述
			}
			
			String content ="定位成功：经度："+geoLon+";纬度："+geoLat+";\n"+"精度："+location.getAccuracy()+"米;\n"
					+"定位方式："+location.getProvider()+"\n"
					+"定位时间："+location.getTime()+"\n"
					+"城市编码："+cityCode+"\n"
					+"位置描述："+desc+"\n"
					+"所在省："+location.getProvider()+"\n"
					+"所在市："+location.getCity()+"\n"
					+"所在区/县："+location.getDistrict()+"\n"
					+"区编码："+location.getAdCode();
			
			tv1.setText(content);
			
		}
		
		
		
	}
	@Override
	protected void onPause() {
		if (Proxy !=null) {
			Proxy.removeUpdates(this);
			
		}
		
		super.onPause();
	}
	
	@Override
	protected void onDestroy() {
		
		if (Proxy != null) {
			
			Proxy.removeUpdates(this);
			Proxy.destory();
		}
		
		super.onDestroy();
	}

	
	

}
