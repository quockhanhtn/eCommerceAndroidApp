package hcmute.edu.vn.id18110304.Utils;

import android.view.View;

import com.google.android.material.snackbar.Snackbar;

/**
 * @author Khanh Lam
 * @version 1.0
 */
public class SnackbarUtils {

   public static void showLong(View view, CharSequence text) {
      showLong(view, text, null, null);
   }

   public static void showLong(View view, CharSequence text, CharSequence actionText, View.OnClickListener actionListener) {
      Snackbar snackbar = Snackbar.make(view, text, Snackbar.LENGTH_LONG);

      if (actionText != null && actionText.length() > 0) {
         snackbar.setAction(actionText, actionListener);
      }

      snackbar.show();
   }
}
