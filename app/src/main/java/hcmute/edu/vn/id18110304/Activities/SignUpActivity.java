package hcmute.edu.vn.id18110304.Activities;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import hcmute.edu.vn.id18110304.Communications.Response.UserResponse;
import hcmute.edu.vn.id18110304.Communications.WebServices.UserService;
import hcmute.edu.vn.id18110304.Cons;
import hcmute.edu.vn.id18110304.Utils.AppUtils;
import hcmute.edu.vn.id18110304.Utils.DialogUtils;
import hcmute.edu.vn.id18110304.databinding.ActivitySignUpBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * SignUpActivity
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class SignUpActivity extends AppCompatActivity {

   public static final String TAG = SignUpActivity.class.getSimpleName();
   private static final int VERIFY_PHONE = 100;
   private static final int SELECT_PICTURE = 101;

   private ActivitySignUpBinding binding;
   private Uri imageUri = null;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      binding = ActivitySignUpBinding.inflate(getLayoutInflater());
      View view = binding.getRoot();
      setContentView(view);

      Intent intent = new Intent(SignUpActivity.this, SendOtpActivity.class);
      startActivityForResult(intent, VERIFY_PHONE);

      AppUtils.handlePermission(this, SELECT_PICTURE);

      initialVariables();
      setViewListeners();
   }

   public void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
      super.onActivityResult(requestCode, resultCode, data);
      new Thread(() -> {
         if (resultCode == RESULT_OK) {
            if (requestCode == VERIFY_PHONE) {
               String phoneNumber = data.getStringExtra(Cons.KEY_VERIFY_PHONE_NUMBER);
               if (phoneNumber == null || phoneNumber.isEmpty()) {
                  DialogUtils.showErrorDialog("Error", "Unverified phone number ", this, v -> finish());
               }
               binding.etPhoneNumber.setText(phoneNumber);
               binding.etPhoneNumber.setEnabled(false);
            } else if (requestCode == SELECT_PICTURE) {
               // Get the url from data
               final Uri selectedImageUri = data.getData();
               if (null != selectedImageUri) {
                  imageUri = selectedImageUri;
                  // Get the path from the Uri
                  String path = AppUtils.getPathFromURI(getContentResolver(), selectedImageUri);
                  Log.i(TAG, "Image Path : " + path);
                  // Set the image in ImageView
                  binding.ivProfile.post(new Runnable() {
                     @Override
                     public void run() {
                        binding.ivProfile.setImageURI(selectedImageUri);
                     }
                  });
               }
            }
         } else {
//               Snackbar.make(SignUpActivity.this.findViewById(R.id.activity_sign_up),
//                       "No Image selected", Snackbar.LENGTH_LONG).show();
         }
      }).start();
   }

   @Override
   public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
      switch (requestCode) {
         case SELECT_PICTURE:
            for (int i = 0; i < permissions.length; i++) {
               String permission = permissions[i];
               if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                  boolean showRationale = ActivityCompat.shouldShowRequestPermissionRationale(this, permission);
                  if (!showRationale) {
                     AppUtils.showSettingsAlert(this, SignUpActivity.this);
                  }
               }
            }
      }
      super.onRequestPermissionsResult(requestCode, permissions, grantResults);
   }

   public void initialVariables() {
   }

   public void setViewListeners() {
      binding.tvReturnLoginIn.setOnClickListener(v -> finish());

      binding.ivProfile.setOnClickListener(v -> {
         Intent intent = new Intent();
         intent.setType("image/*");
         intent.setAction(Intent.ACTION_GET_CONTENT);
         startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);
      });

      binding.btnSignUp.setOnClickListener(v -> {
         DialogUtils.showSuccessDialog("", "", this);
         finish();
         return;

//         String pass = binding.etPassword.getText().toString();
//         String rePass = binding.etRePassword.getText().toString();
//
//         if (!pass.equals(rePass)) {
//            DialogUtils.showErrorDialog("Error", "Pasword not match", this);
//            return;
//         }
//
//         UserService.getInstance().signup(
//               binding.etPhoneNumber.getText().toString(),
//               binding.etPassword.getText().toString(),
//               imageUri,
//               "",
//               "",
//               0,
//               new Callback<UserResponse>() {
//                  @Override
//                  public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
//
//                  }
//
//                  @Override
//                  public void onFailure(Call<UserResponse> call, Throwable t) {
//
//                  }
//               }
//         );
      });
   }
}