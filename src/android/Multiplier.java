
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class Multiplier extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("getValue")) {
            String passedValue = args.getString(0);
            this.getValue(passedValue, callbackContext);
            return true;
        }
        return false;
    }

    private void getValue(String passedValue, CallbackContext callbackContext) {
        if (passedValue != null && passedValue.length() > 0) {
             int num = Integer.parseInt(passedValue) * 10;
            callbackContext.success(num);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
