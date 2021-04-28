package hcmute.edu.vn.id18110304.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.snackbar.Snackbar;

import hcmute.edu.vn.id18110304.Helpers.AppHelper;
import hcmute.edu.vn.id18110304.R;

public class SignUpActivity extends AppCompatActivity {
   private static final int SELECT_PICTURE = 100;
   private static final String TAG = "SignUpActivity";

   ImageView ivProfile = null;
   TextView tvReturnLogin = null;

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
                     String path = AppHelper.getPathFromURI(getContentResolver(), selectedImageUri);
                     Log.i(TAG, "Image Path : " + path);
                     // Set the image in ImageView
                     ivProfile.post(new Runnable() {
                        @Override
                        public void run() {
                           ivProfile.setImageURI(selectedImageUri);
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
                     AppHelper.showSettingsAlert(this, SignUpActivity.this);
                  }
               }
            }
      }
      super.onRequestPermissionsResult(requestCode, permissions, grantResults);
   }


   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_sign_up);

      handlePermission();
      findViews();
      setViewsListener();
   }

   void findViews() {
      ivProfile = findViewById(R.id.imageview_profile);
      tvReturnLogin = findViewById(R.id.textview_return_login);
   }

   void setViewsListener() {
      tvReturnLogin.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            finish();
         }
      });

      ivProfile.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);
         }
      });
   }
}