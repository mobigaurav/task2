package com.task2;
import android.os.Handler;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Timer;

/**
 * This class echoes a string called from JavaScript.
 */
public class Multiplier extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("getValue")) {
            String passedValue = args.getString(0);
            final Handler handler = new Handler();

            handler.postDelayed(new Runnable() {

                @Override

                public void run() {

                    this.getValue(passedValue, callbackContext);
                }

                private void getValue(String passedValue, CallbackContext callbackContext) {
                    if (passedValue != null && passedValue.length() > 0) {
                        int num = Integer.parseInt(passedValue) * 10;
                        callbackContext.success(num);
                    } else {
                        callbackContext.error("Expected one non-empty string argument.");
                    }
                }

            }, 3000);
            return true;

        }
        return false;
    }


}
