package hcmute.edu.vn.id18110304.Utils;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.core.widget.NestedScrollView;

/**
 * TextViewUtils
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class TextViewUtils {
   public static void setHtml(TextView tv, String htmlContent) {
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
         tv.setText(Html.fromHtml(htmlContent, Html.FROM_HTML_MODE_COMPACT));
      } else {
         tv.setText(Html.fromHtml(htmlContent));
      }
   }

   @SuppressLint("ClickableViewAccessibility")
   public static void enableScrollableInScrollView(TextView tv, FrameLayout scrollView) {
      tv.setMovementMethod(new ScrollingMovementMethod());

      scrollView.setOnTouchListener((v, event) -> {
         tv.getParent().requestDisallowInterceptTouchEvent(false);
         return false;
      });

      tv.setOnTouchListener((v, event) -> {
         tv.getParent().requestDisallowInterceptTouchEvent(true);
         return false;
      });
   }
}
