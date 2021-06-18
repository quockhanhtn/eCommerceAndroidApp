package hcmute.edu.vn.id18110304.Activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

import hcmute.edu.vn.id18110304.Communications.Domains.ProductDomain;
import hcmute.edu.vn.id18110304.Fragments.CartFragment;
import hcmute.edu.vn.id18110304.Fragments.CategoryFragment;
import hcmute.edu.vn.id18110304.Fragments.HomeFragment;
import hcmute.edu.vn.id18110304.Fragments.ProfileFragment;
import hcmute.edu.vn.id18110304.Fragments.SavedFragment;
import hcmute.edu.vn.id18110304.Interfaces.IGenericActivity;
import hcmute.edu.vn.id18110304.Interfaces.INavigationListener;
import hcmute.edu.vn.id18110304.R;
import hcmute.edu.vn.id18110304.databinding.ActivityMainBinding;
import nl.joery.animatedbottombar.AnimatedBottomBar;

/**
 * MainActivity
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity
      implements IGenericActivity, INavigationListener, HomeFragment.IAddCartListener {

   public static final String TAG = MainActivity.class.getSimpleName();
   final List<Fragment> listFragments = Arrays.asList(
         new SavedFragment(this),
         new CategoryFragment(this),
         new HomeFragment(this),
         new CartFragment(this),
         new ProfileFragment(this)
   );
   final List<String> listFragmentTitles = Arrays.asList(
         String.valueOf(R.string.txt_saved),
         String.valueOf(R.string.txt_categories),
         String.valueOf(R.string.txt_home),
         String.valueOf(R.string.txt_cart),
         String.valueOf(R.string.txt_profile)
   );
   final FragmentManager fm = getSupportFragmentManager();
   Integer selectedFragmentIndex = 2;
   private ActivityMainBinding binding;

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
      // region Init fragment
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

   @Override
   public void setViewListeners() {
      binding.bottomNavigation.setOnTabSelectListener(new AnimatedBottomBar.OnTabSelectListener() {
         @Override
         public void onTabSelected(int i, AnimatedBottomBar.@Nullable Tab tab, int i1, AnimatedBottomBar.@NotNull Tab tab1) {
            int previous = selectedFragmentIndex;
            selectedFragmentIndex = i1;

            if (listFragments.get(selectedFragmentIndex) instanceof CartFragment) {
               ((CartFragment) listFragments.get(selectedFragmentIndex)).updateView();
            }

            fm.beginTransaction().hide(listFragments.get(previous))
                  .show(listFragments.get(selectedFragmentIndex))
                  .commit();
         }

         @Override
         public void onTabReselected(int i, AnimatedBottomBar.@NotNull Tab tab) {

         }
      });
   }

   @Override
   public void addToCart(ProductDomain product, String productType, int quantity) {
      int noCartItem = ((CartFragment) listFragments.get(3)).addToCart(product, productType, quantity);
      if (noCartItem == 0) {
         binding.bottomNavigation.clearBadgeAtTabIndex(3);
      } else {
         binding.bottomNavigation.setBadgeAtTabIndex(3,
               new AnimatedBottomBar.Badge(String.valueOf(noCartItem), null, null, null)
         );
      }
   }

   @Override
   public void setBadge(int tabIndex, int number) {
      if (number > 0) {
         binding.bottomNavigation.setBadgeAtTabIndex(tabIndex,
               new AnimatedBottomBar.Badge(String.valueOf(number), null, null, null)
         );
      } else {
         binding.bottomNavigation.clearBadgeAtTabIndex(tabIndex);
      }
   }

   @Override
   public void switchTo(int tabIndex) {
      binding.bottomNavigation.selectTabAt(tabIndex, true);
   }
}