package hcmute.edu.vn.id18110304.Utils;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.Menu;

import com.google.android.material.navigation.NavigationView;

import java.util.List;
import java.util.Map;

/**
 * NavigationViewUtils
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class NavigationViewUtils {

   public static void setIconColor(NavigationView navigationView, List<Integer> listMenuId, List<String> listColor) {
      Menu menu = navigationView.getMenu();

      for (int i = 0; i < listMenuId.size(); i++) {
         int menuId = listMenuId.get(i);
         int color = Color.parseColor(listColor.get(i));

         menu.findItem(menuId).getIcon().setColorFilter(color, PorterDuff.Mode.SRC_IN);
      }
   }

   public static void setIconColor(NavigationView navigationView, Map<Integer, String> mapMenuId_HexColor) {
      Menu menu = navigationView.getMenu();

      for (Map.Entry<Integer, String> entry : mapMenuId_HexColor.entrySet()) {
         int menuId = entry.getKey();
         int color = Color.parseColor(entry.getValue());

         menu.findItem(menuId).getIcon().setColorFilter(color, PorterDuff.Mode.SRC_IN);
      }
   }
}
