package hcmute.edu.vn.id18110304.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Collection;
import java.util.Set;

/**
 * SharedPreferencesUtils
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class SharedPreferencesUtils {

   /**
    * Retrieve a String value from the preferences.
    *
    * @param context      Current context, will be used to access resources.
    * @param name         Desired preferences file.
    * @param key          The name of the preference to retrieve.
    * @param defaultValue Value to return if this preference does not exist.
    * @return Returns the preference value if it exists, or defValue.
    */
   public static String getString(Context context, String name, String key, String defaultValue) {
      String result = defaultValue;

      SharedPreferences sharedPref = context.getSharedPreferences(name, Context.MODE_PRIVATE);
      if (sharedPref != null) {
         result = sharedPref.getString(key, defaultValue);
      }

      return result;
   }

   /**
    * Retrieve a String Set value from the preferences.
    *
    * @param context      Current context, will be used to access resources.
    * @param name         Desired preferences file.
    * @param key          The name of the preference to retrieve.
    * @param defaultValue Value to return if this preference does not exist.
    * @return Returns the preference value if it exists, or defValue.
    */
   public static Set<String> getStringSet(Context context, String name, String key, Set<String> defaultValue) {
      Set<String> result = defaultValue;

      SharedPreferences sharedPref = context.getSharedPreferences(name, Context.MODE_PRIVATE);
      if (sharedPref != null) {
         result = sharedPref.getStringSet(key, defaultValue);
      }

      return result;
   }

   /**
    * Put value to SharedPreferences
    *
    * @param context        Current context, will be used to access resources.
    * @param sharedPrefName Desired preferences file.
    * @param key            The name of the preference to modify.
    * @param value          The new value for the preference.
    */
   public static void putValue(Context context, String sharedPrefName, String key, Object value) {
      SharedPreferences sharedPref = context.getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE);
      SharedPreferences.Editor editor = sharedPref.edit();

      if (value instanceof String) {
         editor.putString(key, (String) value);
      } else if (value instanceof Collection<?>) {
         editor.putStringSet(key, (Set<String>) value);
      } else if (value instanceof Integer) {
         editor.putInt(key, (Integer) value);
      } else if (value instanceof Long) {
         editor.putLong(key, (Long) value);
      } else if (value instanceof Float) {
         editor.putFloat(key, (Float) value);
      } else if (value instanceof Boolean) {
         editor.putBoolean(key, (Boolean) value);
      } else {
         editor.putString(key, value.toString());
      }

      editor.apply();
   }

}

