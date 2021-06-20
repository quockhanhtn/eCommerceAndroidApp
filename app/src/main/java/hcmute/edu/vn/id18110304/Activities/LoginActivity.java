package hcmute.edu.vn.id18110304.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import hcmute.edu.vn.id18110304.Communications.Response.UserResponse;
import hcmute.edu.vn.id18110304.Communications.WebServices.UserService;
import hcmute.edu.vn.id18110304.Cons;
import hcmute.edu.vn.id18110304.Utils.DialogUtils;
import hcmute.edu.vn.id18110304.Utils.SharedPreferencesUtils;
import hcmute.edu.vn.id18110304.databinding.ActivityLogInBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * LoginActivity
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class LoginActivity extends AppCompatActivity {

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

   public void initialVariables() {
   }

   public void setViewListeners() {
      binding.btnLogin.setOnClickListener(v -> {
         String phoneNumber = binding.edittextPhoneNumber.getText().toString();
         String password = binding.edittextPassword.getText().toString();

         String loginJson = "{\"phone\": \"" + phoneNumber + "\", \"password\": \"" + password + "\"}";

//         UserService.getInstance().login(loginJson, new Callback<UserResponse.LoginResponse>() {
//            @Override
//            public void onResponse(Call<UserResponse.LoginResponse> call, Response<UserResponse.LoginResponse> response) {
//               if (response.isSuccessful()) {
//                  UserResponse.LoginResponse loginResponse = response.body();
//                  String errorMess = "";
//                  if (loginResponse.getSuccess()) {
//                     SharedPreferencesUtils.putValue(
//                           getApplicationContext(),
//                           Cons.KEY_SP_LOGIN,
//                           Cons.KEY_SP_LOGIN_TOKEN,
//                           loginResponse.getData().getToken());
//                     runOnUiThread(() -> finish());
//                     return;
//                  }
//               }
//               runOnUiThread(() -> loginFailed());
//            }
//
//            @Override
//            public void onFailure(Call<UserResponse.LoginResponse> call, Throwable t) {
//               runOnUiThread(() -> loginFailed());
//            }
//         });
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

   void loginFailed() {
      DialogUtils.showErrorDialog("Error", "", this);
   }
}