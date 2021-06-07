package hcmute.edu.vn.id18110304.Utils;

import android.content.Context;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

/**
 * @author Khanh Lam
 * @since 6/7/2021
 */
public class LayoutManagerUtils {
   public static LinearLayoutManager getHorizontal(Context c, int rows) {
      if (rows == 1) {
         return new LinearLayoutManager(c, LinearLayoutManager.HORIZONTAL, false);
      }

      return new GridLayoutManager(c, rows, LinearLayoutManager.HORIZONTAL, false);
   }
}
