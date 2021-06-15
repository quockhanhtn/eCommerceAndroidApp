package hcmute.edu.vn.id18110304.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import hcmute.edu.vn.id18110304.Interfaces.IGenericActivity;
import hcmute.edu.vn.id18110304.Utils.DialogUtils;
import hcmute.edu.vn.id18110304.databinding.ActivityLogInBinding;

/**
 * LoginActivity
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class LoginActivity extends AppCompatActivity implements IGenericActivity {

   ActivityLogInBinding binding;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

      binding = ActivityLogInBinding.inflate(getLayoutInflater());
      View view = binding.getRoot();
      setContentView(view);

      initialVariables();
      setViewListeners();
   }

   @Override
   public void initialVariables() {
   }

   @Override
   public void setViewListeners() {
      binding.btnLogin.setOnClickListener(v -> {
         String phoneNumber = binding.edittextPhoneNumber.getText().toString();
         String password = binding.edittextPassword.getText().toString();
      });

      binding.btnLoginWithFb.setOnClickListener(v -> DialogUtils.showErrorDialog(
            "Under construction",
            "This feature is under construction",
            LoginActivity.this, null)
      );

      binding.btnLoginWithGg.setOnClickListener(v -> DialogUtils.showErrorDialog(
            "Under construction",
            "This feature is under construction",
            LoginActivity.this, null)
      );

      binding.tvSignUp.setOnClickListener(v -> {
         Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
         startActivity(intent);
         finish();
      });
   }
}