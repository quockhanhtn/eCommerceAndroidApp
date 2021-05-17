package hcmute.edu.vn.id18110304.Activities;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.IOException;

import hcmute.edu.vn.id18110304.Communications.Requests.CountryRequest;
import hcmute.edu.vn.id18110304.Interfaces.IGenericActivity;
import hcmute.edu.vn.id18110304.R;
import hcmute.edu.vn.id18110304.Utils.OkHttpUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements IGenericActivity {

   public static final String TAG = MainActivity.class.getSimpleName();

   NavController navController = null;
   BottomNavigationView bottomNavigationView = null;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      initialViews();
      setViewListeners();

      OkHttpUtils.sendRequest(
            "https://open-ecommerce-api.herokuapp.com/api/countries",
            new Callback() {
               @Override
               public void onFailure(Call call, IOException e) {
                  Log.e(TAG, "Network Error");
               }

               @Override
               public void onResponse(Call call, Response response) throws IOException {
                  String json = response.body().string();
                  CountryRequest responseDomain = null;
                  try {
                     responseDomain = new ObjectMapper().readValue(json, CountryRequest.class);
                  } catch (Exception e) {
                     Log.d(TAG, e.getMessage());
                  }
               }
            }
      );
   }

   @Override
   public void initialViews() {
      bottomNavigationView = findViewById(R.id.bottom_navigation);
      navController = Navigation.findNavController(this, R.id.fragment_nav_host);

      NavigationUI.setupWithNavController(bottomNavigationView, navController);
   }

   @Override
   public void setViewListeners() {

   }
}