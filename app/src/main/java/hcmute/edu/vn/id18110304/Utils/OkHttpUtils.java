package hcmute.edu.vn.id18110304.Utils;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OkHttpUtils {
   public static final String TAG = OkHttpUtils.class.getSimpleName();

   public static void sendRequest(String requestUrl, Callback cb) {
      OkHttpClient client = new OkHttpClient();
      Request request = new Request.Builder()
            .url(requestUrl)
            .build();

      client.newCall(request).enqueue(cb);
   }
}
