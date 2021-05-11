package hcmute.edu.vn.id18110304.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import hcmute.edu.vn.id18110304.Interfaces.IGenericActivity;
import hcmute.edu.vn.id18110304.R;

public class MainActivity extends AppCompatActivity implements IGenericActivity {

   DrawerLayout drawerLayout = null;
   ImageView imageViewMenu = null;
   NavigationView navigationView = null;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      initialViews();
      setViewListeners();
   }

   @Override
   public void initialViews() {
      drawerLayout = findViewById(R.id.drawer_layout);
      imageViewMenu = findViewById(R.id.image_view_menu);
      navigationView = findViewById(R.id.navigation_view);
      navigationView.setItemIconTintList(null);
   }

   @Override
   public void setViewListeners() {
      imageViewMenu.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            drawerLayout.openDrawer(GravityCompat.START);
         }
      });
   }
}