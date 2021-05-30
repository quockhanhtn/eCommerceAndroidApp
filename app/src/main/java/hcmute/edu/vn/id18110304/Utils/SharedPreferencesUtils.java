package hcmute.edu.vn.id18110304.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Collection;
import java.util.Set;

/**
 * SharedPreferencesUtils
 *
 * @author  Khanh Lam
 * @version 1.0
 */
public class SharedPreferencesUtils {

   public static String getString(Context context, String name, String key, String defaultValue) {
      String result = defaultValue;

      SharedPreferences sharedPref = context.getSharedPreferences(name, Context.MODE_PRIVATE);
      if (sharedPref != null) {
         result = sharedPref.getString(key, defaultValue);
      }

      StringUtils.toBigDecimal("ss");

      return result;
   }

   public static Set<String> getStringSet(Context context, String name, String key, Set<String> defaultValue) {
      Set<String> result = defaultValue;

      SharedPreferences sharedPref = context.getSharedPreferences(name, Context.MODE_PRIVATE);
      if (sharedPref != null) {
         result = sharedPref.getStringSet(key, defaultValue);
      }

      return result;
   }

   public static void putValue(Context context, String sharedPrefName, String key, Object value) {
      SharedPreferences sharedPref = context.getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE);
      SharedPreferences.Editor editor = sharedPref.edit();

      if (value instanceof String) {
         editor.putString(key, (String) value);
      } else if (value instanceof Collection<?>) {
         editor.putStringSet(key, (Set<String>) value);
      } else if (value instanceof Integer) {
         editor.putInt(key, (Integer) value);
      }

      editor.apply();
   }

}

