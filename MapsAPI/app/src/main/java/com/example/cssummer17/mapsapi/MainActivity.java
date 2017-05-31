package com.example.cssummer17.mapsapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


TextView mTxtDisplay;
ImageView mImageView;
mTxtDisplay = (TextView) findViewById(R.id.txtDisplay);
String url = "http://my-json-feed";


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}


        JsonObjectRequest jsObjRequest = new JsonObjectRequest
        (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

@Override
public void onResponse(JSONObject response) {
        mTxtDisplay.setText("Response: " + response.toString());
        }
        }, new Response.ErrorListener() {

@Override
public void onErrorResponse(VolleyError error) {
        // TODO Auto-generated method stub

        }
        });

// Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest);