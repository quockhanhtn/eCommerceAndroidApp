package hcmute.edu.vn.id18110304.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import hcmute.edu.vn.id18110304.Interfaces.IGenericActivity;
import hcmute.edu.vn.id18110304.Utils.AppUtils;
import hcmute.edu.vn.id18110304.databinding.ActivitySignUpBinding;

/**
 * SignUpActivity
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class SignUpActivity extends AppCompatActivity implements IGenericActivity {

   private static final int SELECT_PICTURE = 100;
   public static final String TAG = SignUpActivity.class.getSimpleName();

   private ActivitySignUpBinding binding;

   private void handlePermission() {
      if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
         return;
      }

      if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED) {
         //ask for permission
         ActivityCompat.requestPermissions(this,
               new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
               SELECT_PICTURE);
      }
   }

   public void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
      super.onActivityResult(requestCode, resultCode, data);
      new Thread(new Runnable() {
         @Override
         public void run() {
            if (resultCode == RESULT_OK) {
               if (requestCode == SELECT_PICTURE) {
                  // Get the url from data
                  final Uri selectedImageUri = data.getData();
                  if (null != selectedImageUri) {
                     // Get the path from the Uri
                     String path = AppUtils.getPathFromURI(getContentResolver(), selectedImageUri);
                     Log.i(TAG, "Image Path : " + path);
                     // Set the image in ImageView
                     binding.imageviewProfile.post(new Runnable() {
                        @Override
                        public void run() {
                           binding.imageviewProfile.setImageURI(selectedImageUri);
                        }
                     });
                  }
               }
            } else {
//               Snackbar.make(SignUpActivity.this.findViewById(R.id.activity_sign_up),
//                       "No Image selected", Snackbar.LENGTH_LONG).show();
            }
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


   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      binding = ActivitySignUpBinding.inflate(getLayoutInflater());
      View view = binding.getRoot();
      setContentView(view);

      handlePermission();
      initialVariables();
      setViewListeners();
   }

   @Override
   public void initialVariables() {
   }

   @Override
   public void setViewListeners() {
      binding.textviewReturnLogin.setOnClickListener(v -> finish());

      binding.imageviewProfile.setOnClickListener(v -> {
         Intent intent = new Intent();
         intent.setType("image/*");
         intent.setAction(Intent.ACTION_GET_CONTENT);
         startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);
      });
   }
}