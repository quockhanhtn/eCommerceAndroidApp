package hcmute.edu.vn.id18110304.Activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      Intent mainIntent = new Intent(SplashScreenActivity.this, MainActivity.class);
      startActivity(mainIntent);
      finish();
   }
}