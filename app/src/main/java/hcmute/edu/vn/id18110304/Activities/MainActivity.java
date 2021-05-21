package hcmute.edu.vn.id18110304.Activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import hcmute.edu.vn.id18110304.Communications.Response.CategoryResponse;
import hcmute.edu.vn.id18110304.Communications.Response.CountryResponse;
import hcmute.edu.vn.id18110304.Communications.WebServices.CategoryService;
import hcmute.edu.vn.id18110304.Interfaces.IGenericActivity;
import hcmute.edu.vn.id18110304.R;
import hcmute.edu.vn.id18110304.databinding.ActivityMainBinding;
import np.com.susanthapa.curved_bottom_navigation.CbnMenuItem;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

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

      CategoryService.getInstance().getAll(new retrofit2.Callback<CategoryResponse>() {
         @Override
         public void onResponse(retrofit2.Call<CategoryResponse> call, retrofit2.Response<CategoryResponse> response) {
            if (response.isSuccessful()) {
               CategoryResponse responseDomain = response.body();
            }
         }

         @Override
         public void onFailure(retrofit2.Call<CategoryResponse> call, Throwable t) {
            Log.e(TAG, "Network Error");
         }
      });

//      OkHttpUtils.sendRequest(
//            "https://open-ecommerce-api.herokuapp.com/api/countries",
//            new Callback() {
//               @Override
//               public void onFailure(Call call, IOException e) {
//                  Log.e(TAG, "Network Error");
//               }
//
//               @Override
//               public void onResponse(Call call, Response response) throws IOException {
//                  String json = response.body().string();
//                  CountryResponse responseDomain = null;
//                  try {
//                     responseDomain = new ObjectMapper().readValue(json, CountryResponse.class);
//                  } catch (Exception e) {
//                     Log.d(TAG, e.getMessage());
//                  }
//               }
//            }
//      );
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
                  R.drawable.ic_settings,
                  R.drawable.avd_settings,
                  R.id.menu_bill
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