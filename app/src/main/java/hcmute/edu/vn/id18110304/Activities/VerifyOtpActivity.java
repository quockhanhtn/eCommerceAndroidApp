package hcmute.edu.vn.id18110304.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import hcmute.edu.vn.id18110304.R;

public class VerifyOtpActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_verify_otp);
      getSupportActionBar().hide();
   }
}