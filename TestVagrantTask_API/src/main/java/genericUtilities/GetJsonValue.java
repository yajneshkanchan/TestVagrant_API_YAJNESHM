package genericUtilities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * this class is use to get the jsonObject and jsonObjectArray
 * 
 * @author Yajnesh
 *
 */
public class GetJsonValue {
	/**
	 * this method will return value in string which is associated with key
	 * 
	 * @param jsonobj
	 * @param key
	 * @return String value
	 */
	public static String getJsonObjectValue(JSONObject jsonobj, String key) {
		return (String) jsonobj.get(key);

	}
	/**
	 * this method will return array object which is associated with key
	 * 
	 * @param jsonobj
	 * @param key
	 * @return JSONArray
	 */
	public static JSONArray getJsonObjectArray(JSONObject jsonobj, String key) {
		return (JSONArray) jsonobj.get(key);

	}

}
