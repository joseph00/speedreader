package com.example.SpeedReader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Landactiviteit extends Activity {
	
	 public void onCreate(Bundle savedInstanceState){
		 super.onCreate(savedInstanceState);
		 
		 
		 Intent intent = getIntent();
		 
		 String id = intent.getStringExtra("Landen");
		

	
		 Intent nextIntent;
		if ( id.equals("Nederland") ) {
			nextIntent = new Intent(getApplication(),NLspeed.class);
			startActivity(nextIntent);
		} else if ( id.equals("Noorwegen")) { nextIntent = new Intent (getApplication(),NWspeed.class);
		startActivity(nextIntent);
	    } else if ( id.equals("Polen")) { nextIntent = new Intent (getApplication(),Pspeed.class);
		
		startActivity(nextIntent);
		
   
           
        } 
       
    }
}
