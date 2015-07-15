package com.example.spark_313.helloworld;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.spark_313.helloworld.model.Carpool;

import org.json.JSONObject;

/**
 * Created by Cristina Brinza on 07.07.2015.
 */
public class FirstIntentService extends IntentService {

    public FirstIntentService() {
        this("FirstIntentService");
    }

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public FirstIntentService(String name) {
        super(name);
    }

    String responseString;

    @Override
    protected void onHandleIntent(Intent workIntent) {
        // Gets data from the incoming Intent
        String url = workIntent.getDataString();
//        String url = "http://www.google.com";

        // Do work here, based on the contents of dataString
        // Instantiate request queue
        RequestQueue queue = Volley.newRequestQueue(this);

        // Request a string response from the provided URL
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        responseString = response;
//
//                        Intent localIntent =
//                                new Intent(Constants.BROADCAST_SUCCESS)
//                                        // Puts the status into the Intent
//                                        .putExtra(Constants.EXTENDED_DATA_STATUS, responseString);
//                        // Broadcasts the Intent to receivers in this app.
//                        LocalBroadcastManager.getInstance(FirstIntentService.this).sendBroadcast(localIntent);
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        responseString = error.getMessage();
//                    }
//                }
//        );
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        Intent localIntent = new Intent(Constants.BROADCAST_SUCCESS)
//                                .putExtra(Constants.EXTENDED_DATA_STATUS, response);
//                        // Broadcasts the Intent to receivers in this app.
//                        LocalBroadcastManager.getInstance(FirstIntentService.this).sendBroadcast(localIntent);
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Intent localIntent = new Intent(Constants.BROADCAST_SUCCESS)
//                                .putExtra(Constants.EXTENDED_DATA_STATUS, "Couldn't complete request");
//                        LocalBroadcastManager.getInstance(FirstIntentService.this).sendBroadcast(localIntent);
//                    }
//                }
//        ) {
//            @Override
//            protected Map<String, String> getParams() throws com.android.volley.AuthFailureError {
//                Map<String, String> params = new HashMap<>();
//                params.put("username", "andreea");
//                params.put("carnumber", "c");
//                params.put("brand", "volkswagen");
//                params.put("colour", "black");
//                params.put("seats", "5");
//                params.put("year", "2014");
//
//                return params;
//            }
//
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("Content-Type", "application/x-www-form-urlencoded");
//                return params;
//            }
//
//        };



        // Add the request to the RequestQueue.
//        queue.add(stringRequest);

    }
}
