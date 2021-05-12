package hcmute.edu.vn.id18110304.Utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

public class ConvertUtils {
   public static Bitmap base64ToBitmap(String base64Str) {
      byte[] imageBytes = Base64.decode(base64Str, Base64.DEFAULT);
      Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
      return decodedImage;
   }
}
