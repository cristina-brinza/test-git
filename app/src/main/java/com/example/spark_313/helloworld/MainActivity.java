package com.example.spark_313.helloworld;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.spark_313.helloworld.facebook.FacebookManager;
import com.example.spark_313.helloworld.gcm.HelloWorldRegistrationIntentService;
import com.facebook.appevents.AppEventsLogger;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;

public class MainActivity extends Activity implements FacebookManager.OnFacebookLoginListener {

    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private static final String TAG = "MainActivity";

    TextView username;
    FirstBroadcastReceiver mBroadcastReceiver;

    private FacebookManager mFacebookManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // need this before anything else correlated to Facebook
        mFacebookManager = new FacebookManager(this);

        setContentView(R.layout.activity_main);

        username = (TextView) findViewById(R.id.request);

        IntentFilter mStatusIntentFilter = new IntentFilter();
        mStatusIntentFilter.addAction(Constants.BROADCAST_SUCCESS);
        mStatusIntentFilter.addAction(Constants.BROADCAST_ERROR);
        mBroadcastReceiver = new FirstBroadcastReceiver();

        LocalBroadcastManager.getInstance(this).registerReceiver(
                mBroadcastReceiver,
                mStatusIntentFilter);

        /*****/
//        String url = "http://simurg.site40.net/get_cars.php?username=" + username.getText().toString();
        String url = "http://simurg.site40.net/insert_into_cars.php";

        Intent mServiceIntent = new Intent(this, FirstIntentService.class);
        mServiceIntent.setData(Uri.parse(url));
        // now it goes to onHandleIntent
        startService(mServiceIntent);

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        // Buna :)
//        String url = "http://simurg.site40.net/get_cars.php?username=cristina";
//
//        // Request a string response from the provided URL.
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        // Display the first 500 characters of the response string.
//                        username.setText("Response is: " + response.substring(0, 500));
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        username.setText("That didn't work!");
//                    }
//                });
//        // Add the request to the RequestQueue.
//        queue.add(stringRequest);


        // obtain registration ID from GCM
        if (checkPlayServices()) {
            // Start IntentService to register this application with GCM.
            Intent intent = new Intent(this, HelloWorldRegistrationIntentService.class);
            startService(intent);
        }

        // facebook login
//        FacebookSdk.sdkInitialize(getApplicationContext());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = menuItem.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(menuItem);
    }

    public void nextButton(View view) {
        Intent signIn = new Intent(this, SignInActivity.class);
        startActivity(signIn);
    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.facebook_sign_in_button:
//                if (!IOUtils.isNetworkAvailable(this)) {
//                    Log.i("No_Network", "No Network available");
//                    return;
//                }
//                mFacebookManager.attemptLoginWithFacebook(this);
//                break;
//        }
//    }

    @Override
    public void onLoginWithFacebookSuccessful() {
        Log.i("FB login", "Login successful");
    }


    public class FirstBroadcastReceiver extends BroadcastReceiver {

        private FirstBroadcastReceiver() {
            // do nothing
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            String info = "";

            if (intent.getAction().equals(Constants.BROADCAST_SUCCESS)) {
                info = intent.getStringExtra(Constants.EXTENDED_DATA_STATUS);
            } else if (intent.getAction().equals(Constants.BROADCAST_ERROR)) {
                info = "ERROR";
            }

            EditText responseText = (EditText) findViewById(R.id.response);
            responseText.setText(info);
        }

    }

    /**
     * Check the device to make sure it has the Google Play Services APK. If
     * it doesn't, display a dialog that allows users to download the APK from
     * the Google Play Store or enable it in the device's system settings.
     */
    private boolean checkPlayServices() {
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                GooglePlayServicesUtil.getErrorDialog(resultCode, this,
                        PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                Log.i(TAG, "This device is not supported.");
                finish();
            }
            return false;
        }
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(this);
    }
}


