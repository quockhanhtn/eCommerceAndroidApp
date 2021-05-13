package hcmute.edu.vn.id18110304.Communications.Requests;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import hcmute.edu.vn.id18110304.Domains.CountryDomain;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CountryRequest {


   public void okhttpExample() {
      OkHttpClient client = new OkHttpClient();
      HttpUrl.Builder urlBuilder = HttpUrl.parse("https://jsonplaceholder.typicode.com/posts").newBuilder();
      String url = urlBuilder.build().toString();
      Request request = new Request.Builder()
            .url(url)
            .build();


      client.newCall(request).enqueue(new Callback() {
         @Override
         public void onFailure(Call call, IOException e) {
            e.printStackTrace();
         }

         @Override
         public void onResponse(Call call, final Response response) throws IOException {

            if (!response.isSuccessful()) {
               throw new IOException("Unexpected code " + response);
            } else {
               final byte[] responseBytes = response.body().bytes();
               ObjectMapper objectMapper = new ObjectMapper();
               final CountryDomain[] posts = objectMapper.readValue(responseBytes, CountryDomain[].class);
            }
         }
      });
   }
}

//public class CountryRequest extends RestClientRequest<ResponseDomain> {
//
//   public static final String TAG = CountryRequest.class.getSimpleName();
//
//   public CountryRequest(String query) {
//      super();
//      setRequestMethod(RequestMethod.GET);
//      setUrl(RestConstants.GOOGLE_BLOGS);
//
//      setParser(new BlogsGoogleParser());
//
//      addQueryParam("q", query);
//      addQueryParam("v", "1.0");
//      addQueryParam("include_entities", "" + true);
//   }
//
//   @Override
//   protected void doAfterSuccessfulRequestInBackgroundThread(ResponseModel data) {
//      try {
//
//         Log.d(TAG, "sleeping to be able to see Bound callbacks in action");
//         Thread.sleep(3000);
//      } catch (InterruptedException e) {
//      }
//      super.doAfterSuccessfulRequestInBackgroundThread(data);
//   }
//
//   @Override
//   protected void customizeClient(OkHttpClient client) {
//      super.customizeClient(client);
//      client.setRetryOnConnectionFailure(false);
//   }
//}
