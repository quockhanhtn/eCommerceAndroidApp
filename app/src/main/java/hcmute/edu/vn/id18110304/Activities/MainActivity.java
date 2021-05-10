package hcmute.edu.vn.id18110304.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import hcmute.edu.vn.id18110304.R;

public class MainActivity extends AppCompatActivity {

   Button btnSignUp = null;
   TextView tvForgotPassword = null;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      findViews();
      setViewsListener();
   }

   void findViews() {
      btnSignUp = findViewById(R.id.button_sign_up);
      tvForgotPassword = findViewById(R.id.textview_forgot_password);
   }


   private void setViewsListener() {
      btnSignUp.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Intent signUpIntent = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(signUpIntent);
         }
      });

      tvForgotPassword.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Intent forgotIntent = new Intent(MainActivity.this, SendOtpActivity.class);
            startActivity(forgotIntent);
         }
      });
   }
}