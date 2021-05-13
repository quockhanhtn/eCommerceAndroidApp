package hcmute.edu.vn.id18110304.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.android.material.navigation.NavigationView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import hcmute.edu.vn.id18110304.Communications.Requests.CountryRequest;
import hcmute.edu.vn.id18110304.Interfaces.IGenericActivity;
import hcmute.edu.vn.id18110304.R;
import hcmute.edu.vn.id18110304.Utils.NavigationViewUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements IGenericActivity {
   
   DrawerLayout drawerLayout = null;
   ImageView imageViewMenu = null;
   NavigationView navigationView = null;
   NavController navController = null;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      initialViews();
      setViewListeners();

      OkHttpClient client = new OkHttpClient();
      Request request = new Request.Builder()
            .url("https://open-ecommerce-api.herokuapp.com/api/countries")
            .build();

      client.newCall(request).enqueue(new Callback() {
         @Override
         public void onFailure(Call call, IOException e) {
            Log.e("Error", "Network Error");
         }

         @Override
         public void onResponse(Call call, Response response) throws IOException {
            String json = response.body().string();
            CountryRequest responseDomain = null;
            try {
               responseDomain = new ObjectMapper().readValue(json, CountryRequest.class);
            } catch (Exception e) {
               Log.d("", e.getMessage());
            }
         }
      });
   }

   @Override
   public void initialViews() {
      drawerLayout = findViewById(R.id.drawer_layout);
      imageViewMenu = findViewById(R.id.image_view_menu);
      navigationView = findViewById(R.id.navigation_view);
      navigationView.setItemIconTintList(null);
      navigationView.getMenu().findItem(R.id.menu_main).getIcon().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);

      Map<Integer, String> navMenuColorMap = new HashMap() {{
         put(R.id.menu_main, "#536def");
         put(R.id.menu_notification, "#6c757d");
         put(R.id.menu_carts, "#28a745");
         put(R.id.menu_bills, "#dc3545");
         put(R.id.menu_message, "#ffc107");
         put(R.id.menu_profile, "#17a2b8");
         put(R.id.menu_setting, "#536def");
         put(R.id.menu_support, "#6c757d");
         put(R.id.menu_about, "#28a745");
         put(R.id.menu_logout, "#dc3545");
      }};
      NavigationViewUtils.setIconColor(navigationView, navMenuColorMap);

      navController = Navigation.findNavController(this, R.id.fragment_nav_host);
      NavigationUI.setupWithNavController(navigationView, navController);
   }

   @Override
   public void setViewListeners() {
      imageViewMenu.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            drawerLayout.openDrawer(GravityCompat.START);
         }
      });

      navigationView.getMenu().findItem(R.id.menu_logout).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
         @Override
         public boolean onMenuItemClick(MenuItem item) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            return false;
         }
      });
   }
}