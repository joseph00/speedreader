package com.example.SpeedReader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Noorwegen extends Activity {

	 public void onCreate(Bundle savedInstanceState){
		 super.onCreate(savedInstanceState);
		 
		 
	 setContentView(R.layout.noorwegen);
	 
	 Button bSwitch = (Button) findViewById(R.id.button1);
     
     bSwitch.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent nwspeed = new Intent (v.getContext(), NWspeed.class);
				v.getContext().startActivity(nwspeed);
				
			}
		});
	 }}
