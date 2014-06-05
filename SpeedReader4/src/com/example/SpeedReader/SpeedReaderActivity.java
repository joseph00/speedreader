package com.example.SpeedReader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SpeedReaderActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button bSwitch = (Button) findViewById(R.id.button1);
        
        bSwitch.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent pancakes = new Intent (v.getContext(), landenActivity.class);
				v.getContext().startActivity(pancakes);
				
			}
		});
    }
}