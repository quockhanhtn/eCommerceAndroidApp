package hcmute.edu.vn.id18110304.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import hcmute.edu.vn.id18110304.R;

public class SendOtpActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_send_otp);
      getSupportActionBar().hide();
   }
}