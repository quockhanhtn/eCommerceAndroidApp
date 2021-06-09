package hcmute.edu.vn.id18110304.Utils;

import android.content.Context;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

/**
 * @author Khanh Lam
 * @since 6/7/2021
 */
public class LayoutManagerUtils {
   /**
    * Get horizontal linear layout manager
    *
    * @param context Current context, will be used to access resources.
    * @param rows    The number of rows
    * @return {@link LinearLayoutManager} or {@link GridLayoutManager}
    */
   public static LinearLayoutManager getHorizontal(Context context, int rows) {
      if (rows == 1) {
         return new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
      }

      return new GridLayoutManager(context, rows, LinearLayoutManager.HORIZONTAL, false);
   }

   /**
    * Get vertical linear layout manager
    *
    * @param context Current context, will be used to access resources.
    * @param cols    The number of columns
    * @return {@link LinearLayoutManager} or {@link GridLayoutManager}
    */
   public static LinearLayoutManager getVertical(Context context, int cols) {
      if (cols == 1) {
         return new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
      }

      return new GridLayoutManager(context, cols, LinearLayoutManager.VERTICAL, false);
   }
}
