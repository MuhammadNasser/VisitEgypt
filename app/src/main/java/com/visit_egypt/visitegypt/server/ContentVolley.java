package com.visit_egypt.visitegypt.server;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Muhammad on 11/30/2016
 */
public abstract class ContentVolley extends BaseVolley {

    private final String url = Constants.getApiUrl();


    public enum ActionType implements BaseVolley.ActionType {
    }

    public ContentVolley(String TAG, Context context) {
        super(TAG, VolleySingleton.getInstance(context));
    }

    @Override
    protected void onPreExecute(BaseVolley.ActionType actionType) {
        ActionType action = (ActionType) actionType;
        onPreExecute(action);
    }

    protected abstract void onPreExecute(ActionType actionType);

    @Override
    protected void getResponseParameters(String response) throws JSONException {

        JSONObject jsonObject = new JSONObject(response);
        JSONArray dataArray;
        JSONObject dataObject;

        String message = jsonObject.optString("message", null);
        boolean success = jsonObject.optBoolean("success", true);

        ActionType action = (ActionType) actionType;

        if (success) {
            switch (action) {
            }
        } else {
            onPostExecuteError(false, jsonObject.toString(), action);
        }
    }


    @Override
    protected void onPostExecuteError(boolean success, String message, BaseVolley.ActionType actionType) {

        ActionType action = (ActionType) actionType;

        try {
            JSONObject jsonObject = new JSONObject(message);
            message = jsonObject.optString("message", message);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        switch (action) {
        }
    }

    protected void onPostExecute(ActionType actionType, boolean success, String message) {
    }

}
