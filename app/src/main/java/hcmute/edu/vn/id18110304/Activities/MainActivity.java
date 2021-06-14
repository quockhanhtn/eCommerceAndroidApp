package hcmute.edu.vn.id18110304.Activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.Arrays;
import java.util.List;

import hcmute.edu.vn.id18110304.Communications.Response.ProductResponse;
import hcmute.edu.vn.id18110304.Communications.WebServices.ProductService;
import hcmute.edu.vn.id18110304.Fragments.CartFragment;
import hcmute.edu.vn.id18110304.Fragments.CategoryFragment;
import hcmute.edu.vn.id18110304.Fragments.HomeFragment;
import hcmute.edu.vn.id18110304.Fragments.ProfileFragment;
import hcmute.edu.vn.id18110304.Fragments.SavedFragment;
import hcmute.edu.vn.id18110304.Interfaces.IGenericActivity;
import hcmute.edu.vn.id18110304.R;
import hcmute.edu.vn.id18110304.databinding.ActivityMainBinding;
import np.com.susanthapa.curved_bottom_navigation.CbnMenuItem;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * MainActivity
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity implements IGenericActivity {

   public static final String TAG = MainActivity.class.getSimpleName();
   private ActivityMainBinding binding;

   final List<Fragment> listFragments = Arrays.asList(
         new SavedFragment(),
         new CategoryFragment(),
         new HomeFragment(),
         new CartFragment(),
         new ProfileFragment()
   );
   final List<String> listFragmentTitles = Arrays.asList(
         String.valueOf(R.string.txt_saved),
         String.valueOf(R.string.txt_categories),
         String.valueOf(R.string.txt_home),
         String.valueOf(R.string.txt_cart),
         String.valueOf(R.string.txt_profile)
   );
   Integer selectedFragmentIndex = 2;

   final FragmentManager fm = getSupportFragmentManager();

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      binding = ActivityMainBinding.inflate(getLayoutInflater());
      View view = binding.getRoot();
      setContentView(view);

      initialVariables();
      setViewListeners();
   }

   @Override
   public void initialVariables() {
      // region Bottom Nav
      CbnMenuItem[] navMenuItems = new CbnMenuItem[]{
            ///the icon, the AVD that will be shown in FAB, optional if you use Jetpack Navigation
            new CbnMenuItem(R.drawable.ic_saved, R.drawable.avd_saved, R.id.menu_saved),
            new CbnMenuItem(R.drawable.ic_category, R.drawable.avd_category, R.id.menu_category),
            new CbnMenuItem(R.drawable.ic_home, R.drawable.avd_home, R.id.menu_home),
            new CbnMenuItem(R.drawable.ic_cart, R.drawable.avd_cart, R.id.menu_cart),
            new CbnMenuItem(R.drawable.ic_profile, R.drawable.avd_profile, R.id.menu_profile)
      };
      binding.bottomNavigation.setMenuItems(navMenuItems, selectedFragmentIndex);

      for (int i = 0; i < listFragments.size(); i++) {
         Fragment f = listFragments.get(i);
         String title = listFragmentTitles.get(i);

         if (selectedFragmentIndex == i) {
            fm.beginTransaction().add(R.id.fragment_container, f, title).commit();
         } else {
            fm.beginTransaction().add(R.id.fragment_container, f, title).hide(f).commit();
         }
      }
      // endregion
   }

   @SuppressLint("NonConstantResourceId")
   @Override
   public void setViewListeners() {
      binding.bottomNavigation.setOnMenuItemClickListener((item, integer) -> {
         int previous = selectedFragmentIndex;
         selectedFragmentIndex = integer;

         fm.beginTransaction().hide(listFragments.get(previous))
               .show(listFragments.get(selectedFragmentIndex))
               .commit();

         return null;
      });
   }
}