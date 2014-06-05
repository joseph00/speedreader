package com.example.SpeedReader;




 
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;

import android.util.Log;
import android.widget.TextView;
 
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

 
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
 
public class NLspeed extends Activity {
    public TextView resultText;
    public String url = "http://www.joepidk.nl/speed.json";
 
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nlspeed);
        resultText = (TextView) findViewById (R.id.result);
 
        new ReadSpeedsJSONFeedTask().execute(url);
    }
 
   

	public String readJSONFeed(String URL) {
        StringBuilder stringBuilder = new StringBuilder();
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(URL);
        try {
            HttpResponse response = httpClient.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) {
                HttpEntity entity = response.getEntity();
                InputStream inputStream = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                inputStream.close();
            } else {
                Log.d("JSON", "Failed to download file");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
 
    private class ReadSpeedsJSONFeedTask extends AsyncTask<String, Void, String> {
        protected String doInBackground(String... urls) {
            return readJSONFeed(urls[0]);
        }
 
        protected void onPostExecute(String result) {
            try
            {
                JSONObject jsonObject = new JSONObject(result);
                JSONArray items = new JSONArray(jsonObject.getString("speeds"));
 
                String res = "";
                for (int i = 0; i < items.length(); i++) {
                    JSONObject item =
                            items.getJSONObject(i);
 
                    res += "The speed limit in " + item.getString("land") + " is " + item.getString("speed") + "\n";
                }
 
                resultText.setText(res);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


