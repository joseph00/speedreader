package com.example.SpeedReader;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class Pspeed extends Activity {
	
	TextView textLat;
	TextView textLong;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pspeed);
		
		textLat = (TextView)findViewById(R.id.textLat);
		textLong = (TextView)findViewById(R.id.textLong);
		
		LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		LocationListener ll = new mylocationListener();
		lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, ll);
	}
		class mylocationListener implements  LocationListener {

			public void onLocationChanged(Location location) {
				if(location != null)
					
				{
				double pLong = location.getLongitude();
				double pLat = location.getLatitude();
				
				textLat.setText(Double.toString(pLat));
				textLong.setText(Double.toString(pLong));
				
				}}
				
				

			public void onProviderDisabled(String provider) {
				// TODO Auto-generated method stub
				
			}

			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub
				
			}

			public void onStatusChanged(String provider, int status,
					Bundle extras) {
				// TODO Auto-generated method stub
				
			}
	}
}

