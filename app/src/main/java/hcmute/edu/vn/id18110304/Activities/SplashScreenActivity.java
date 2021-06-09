package hcmute.edu.vn.id18110304.Activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * SplashScreenActivity
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class SplashScreenActivity extends AppCompatActivity {

   public static final String TAG = SplashScreenActivity.class.getSimpleName();

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

      Intent mainIntent = new Intent(SplashScreenActivity.this, MainActivity.class);
      startActivity(mainIntent);

      finish();
   }
}