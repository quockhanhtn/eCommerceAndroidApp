package hcmute.edu.vn.id18110304.Utils;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.provider.Settings;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

/**
 * AppUtils
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class AppUtils {

   public static void handlePermission(Activity activity, int requestCode) {
      if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
         return;
      }

      if (ContextCompat.checkSelfPermission(
            activity.getApplicationContext(),
            Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
         //ask for permission
         ActivityCompat.requestPermissions(
               activity,
               new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
               requestCode
         );
      }
   }

   public static void openAppSettings(final Activity context) {
      if (context == null) {
         return;
      }
      final Intent i = new Intent();
      i.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
      i.addCategory(Intent.CATEGORY_DEFAULT);
      i.setData(Uri.parse("package:" + context.getPackageName()));
      i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
      i.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
      context.startActivity(i);
   }

   public static String getPathFromURI(ContentResolver contentResolver, Uri contentUri) {
      String res = null;
      String[] projection = {MediaStore.Images.Media.DATA};
      Cursor cursor = contentResolver.query(contentUri, projection, null, null, null);
      if (cursor.moveToFirst()) {
         int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
         res = cursor.getString(column_index);
      }
      cursor.close();
      return res;
   }

   public static void showSettingsAlert(Context context, Activity activity) {
      AlertDialog alertDialog = new AlertDialog.Builder(context).create();
      alertDialog.setTitle("Alert");
      alertDialog.setMessage("App needs to access the Camera.");
      alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "DON'T ALLOW",
            new DialogInterface.OnClickListener() {
               public void onClick(DialogInterface dialog, int which) {
                  dialog.dismiss();
                  //finish();
               }
            });
      alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "SETTINGS",
            new DialogInterface.OnClickListener() {
               public void onClick(DialogInterface dialog, int which) {
                  dialog.dismiss();
                  AppUtils.openAppSettings(activity);
               }
            });
      alertDialog.show();
   }
}
