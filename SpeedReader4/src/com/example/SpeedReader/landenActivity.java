package com.example.SpeedReader;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;
public class landenActivity extends Activity {
  ListView list;
  String[] landen = {
    "Nederland",
      "Noorwegen",
      "Polen",
      
  } ;
  Integer[] imageId = {
      R.drawable.nederland2,
      R.drawable.noor,
      R.drawable.pool,
  
  };
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    CustomList adapter = new
        CustomList(landenActivity.this, landen, imageId);
    list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    Toast.makeText(landenActivity.this, "You Clicked at " +landen[+ position], Toast.LENGTH_SHORT).show();
                    
                    Intent i = new Intent(getApplicationContext(), Landactiviteit.class);
                    i.putExtra("Landen", landen[+ position]);
                    startActivity (i);
                }
            });
  }
}
