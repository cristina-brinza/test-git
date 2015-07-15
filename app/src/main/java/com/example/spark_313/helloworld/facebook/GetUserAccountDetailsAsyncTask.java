package com.example.spark_313.helloworld.facebook;

import android.os.AsyncTask;
import android.os.Bundle;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

/**
 * Created by radu on 05.05.2015.
 */
public class GetUserAccountDetailsAsyncTask extends AsyncTask<AccessToken, Void, GraphResponse> {

    private OnResponseListener mListener;
    private String mToken;

    public interface OnResponseListener {
        void onFacebookResponse(String name, String email, String id, String token);
    }

    public GetUserAccountDetailsAsyncTask(OnResponseListener listener) {
        mListener = listener;
    }


    @Override
    protected GraphResponse doInBackground(AccessToken... params) {
        AccessToken token = params[0];
        mToken = token.getToken();
        GraphRequest request = GraphRequest.newMeRequest(token, null);
        Bundle parameters = new Bundle();
        parameters.putString(Config.Key.FIELDS, Config.Key.NAME + "," + Config.Key.EMAIL+","+Config.Key.ID);
        request.setParameters(parameters);
        return request.executeAndWait();
    }

    @Override
    protected void onPostExecute(GraphResponse graphResponse) {
        if (mListener != null) {
            String name = graphResponse.getJSONObject().optString(Config.Key.NAME);
            String email = graphResponse.getJSONObject().optString(Config.Key.EMAIL);
            String id = graphResponse.getJSONObject().optString(Config.Key.ID);
            mListener.onFacebookResponse(name, email, id, mToken);
        }
    }
}
