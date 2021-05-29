package hcmute.edu.vn.id18110304.Activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import hcmute.edu.vn.id18110304.Communications.Response.CategoryResponse;
import hcmute.edu.vn.id18110304.Communications.WebServices.CategoryService;
import hcmute.edu.vn.id18110304.Interfaces.IGenericActivity;
import hcmute.edu.vn.id18110304.R;
import hcmute.edu.vn.id18110304.databinding.ActivityMainBinding;
import np.com.susanthapa.curved_bottom_navigation.CbnMenuItem;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements IGenericActivity {

   public static final String TAG = MainActivity.class.getSimpleName();

   private ActivityMainBinding binding;
   NavController navController = null;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      binding = ActivityMainBinding.inflate(getLayoutInflater());
      View view = binding.getRoot();
      setContentView(view);

      initialVariables();
      setViewListeners();

      CategoryService.getInstance().getAll(new Callback<CategoryResponse>() {
         @Override
         public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
            if (response.isSuccessful()) {
               CategoryResponse responseDomain = response.body();
            }
         }

         @Override
         public void onFailure(Call<CategoryResponse> call, Throwable t) {
            Log.e(TAG, "Network Error");
         }
      });
   }

   @Override
   public void initialVariables() {
      // region Bottom Nav
      navController = Navigation.findNavController(this, R.id.fragment_nav_host);

      CbnMenuItem[] navMenuItems = new CbnMenuItem[]{
            new CbnMenuItem(
                  R.drawable.ic_saved, // the icon
                  R.drawable.avd_saved, // the AVD that will be shown in FAB
                  R.id.menu_saved // optional if you use Jetpack Navigation
            ),
            new CbnMenuItem(
                  R.drawable.ic_category,
                  R.drawable.avd_category,
                  R.id.menu_category
            ),
            new CbnMenuItem(
                  R.drawable.ic_home,
                  R.drawable.avd_home,
                  R.id.menu_home
            ),
            new CbnMenuItem(
                  R.drawable.ic_cart,
                  R.drawable.avd_cart,
                  R.id.menu_cart
            ),
            new CbnMenuItem(
                  R.drawable.ic_profile,
                  R.drawable.avd_profile,
                  R.id.menu_profile
            )
      };

      binding.bottomNavigation.setMenuItems(navMenuItems, 2);
      binding.bottomNavigation.setupWithNavController(navController);
      // endregion
   }

   @Override
   public void setViewListeners() {

   }
}