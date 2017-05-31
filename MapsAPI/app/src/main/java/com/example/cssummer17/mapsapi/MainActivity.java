package com.example.cssummer17.mapsapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public void volleyStringRequst(String url){

        String REQUEST_TAG="com.androidtutorialpoint.volleyStringRequest";
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        StringRequest strReq=new StringRequest(url,new Response.Listener<String>(){
@Override
public void onResponse(String response){
        Log.d(TAG,response.toString());

        LayoutInflater li=LayoutInflater.from(MainActivity.this);
        showDialogView=li.inflate(R.layout.show_dialog,null);
        outputTextView=(TextView)showDialogView.findViewById(R.id.text_view_dialog);
        AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setView(showDialogView);
        alertDialogBuilder
        .setPositiveButton("OK",new DialogInterface.OnClickListener(){
public void onClick(DialogInterface dialog,int id){
        }
        })
        .setCancelable(false)
        .create();
        outputTextView.setText(response.toString());
        alertDialogBuilder.show();
        progressDialog.hide();
        }
        },new Response.ErrorListener(){

@Override
public void onErrorResponse(VolleyError error){
        VolleyLog.d(TAG,"Error: "+error.getMessage());
        progressDialog.hide();
        }
        });
        // Adding String request to request queue
        AppSingleton.getInstance(getApplicationContext()).addToRequestQueue(strReq,REQUEST_TAG);
        }

public void volleyJsonObjectRequest(String url){

        String  REQUEST_TAG = "com.androidtutorialpoint.volleyJsonObjectRequest";
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        JsonObjectRequest jsonObjectReq = new JsonObjectRequest(url, null,
        new Response.Listener<JSONObject>() {
@Override
public void onResponse(JSONObject response) {
        Log.d(TAG, response.toString());

        LayoutInflater li = LayoutInflater.from(MainActivity.this);
        showDialogView = li.inflate(R.layout.show_dialog, null);
        outputTextView = (TextView)showDialogView.findViewById(R.id.text_view_dialog);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setView(showDialogView);
        alertDialogBuilder
        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
public void onClick(DialogInterface dialog, int id) {
        }
        })
        .setCancelable(false)
        .create();
        outputTextView.setText(response.toString());
        alertDialogBuilder.show();
        progressDialog.hide();

        }
        }, new Response.ErrorListener() {
@Override
public void onErrorResponse(VolleyError error) {
        VolleyLog.d(TAG, "Error: " + error.getMessage());
        progressDialog.hide();
        }
        });

        // Adding JsonObject request to request queue
        AppSingleton.getInstance(getApplicationContext()).addToRequestQueue(jsonObjectReq,REQUEST_TAG);
        }

// CACHE HANDLING?????
public void volleyCacheRequest(String url){
        Cache cache = AppSingleton.getInstance(getApplicationContext()).getRequestQueue().getCache();
        Cache.Entry reqEntry = cache.get(url);
        if(reqEntry != null){
        try {
        String data = new String(reqEntry.data, "UTF-8");
        //Handle the Data here.
        } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
        }
        }
        else{

        //Request Not present in cache, launch a network request instead.
        }
        }

public void volleyInvalidateCache(String url){
        AppSingleton.getInstance(getApplicationContext()).getRequestQueue().getCache().invalidate(url, true);
        }

public void volleyDeleteCache(String url){
        AppSingleton.getInstance(getApplicationContext()).getRequestQueue().getCache().remove(url);
        }

public void volleyClearCache(){
        AppSingleton.getInstance(getApplicationContext()).getRequestQueue().getCache().clear();
        }
