package hcmute.edu.vn.id18110304.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import hcmute.edu.vn.id18110304.Interfaces.IGenericActivity;
import hcmute.edu.vn.id18110304.R;

public class LoginActivity extends AppCompatActivity implements IGenericActivity {

   Button btnSignUp = null;
   Button btnLogin = null;
   TextView tvForgotPassword = null;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_log_in);

      initialViews();
      setViewListeners();
   }

   @Override
   public void initialViews() {
      btnSignUp = findViewById(R.id.button_sign_up);
      btnLogin = findViewById(R.id.button_log_in);
      tvForgotPassword = findViewById(R.id.textview_forgot_password);
   }

   @Override
   public void setViewListeners() {
      btnSignUp.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Intent signUpIntent = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(signUpIntent);
         }
      });

      btnLogin.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            finish();
         }
      });

      tvForgotPassword.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Intent forgotIntent = new Intent(LoginActivity.this, SendOtpActivity.class);
            startActivity(forgotIntent);
         }
      });
   }
}