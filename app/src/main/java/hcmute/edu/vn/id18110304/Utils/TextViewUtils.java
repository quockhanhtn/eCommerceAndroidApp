package hcmute.edu.vn.id18110304.Utils;

import android.os.Build;
import android.text.Html;
import android.widget.TextView;

/**
 * TextViewUtils
 *
 * @author  Khanh Lam
 * @version 1.0
 */
public class TextViewUtils {
   public static void setHtml(TextView tv, String htmlContent){
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
         tv.setText(Html.fromHtml(htmlContent, Html.FROM_HTML_MODE_COMPACT));
      } else {
         tv.setText(Html.fromHtml(htmlContent));
      }
   }
}
