package com.example.SpeedReader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Polen extends Activity {

	 public void onCreate(Bundle savedInstanceState){
		 super.onCreate(savedInstanceState);
	 setContentView(R.layout.polen);
	 
	 Button bSwitch = (Button) findViewById(R.id.button2);
     
     bSwitch.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent pspeed = new Intent (v.getContext(), Pspeed.class);
				v.getContext().startActivity(pspeed);
				
			}
		});
	 }}
