package hcmute.edu.vn.id18110304.Daos;

import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

import hcmute.edu.vn.id18110304.Communications.Requests.CountryRequest;
import hcmute.edu.vn.id18110304.Domains.CountryDomain;
import hcmute.edu.vn.id18110304.Utils.OkHttpUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class CountryDao {
   public static final String TAG = CountryDao.class.getSimpleName();

   String API_RESOURCE = "/countries";

   private static CountryDao instance = null;

   private CountryDao() {
   }

   public static CountryDao getInstance() {
      if (instance == null) {
         instance = new CountryDao();
      }
      return instance;
   }

   public List<CountryDomain> getAll() {
      OkHttpUtils.sendRequest(
            "https://open-ecommerce-api.herokuapp.com/api/countries",
            new Callback() {
               @Override
               public void onFailure(Call call, IOException e) {
                  Log.e(TAG, "Network Error");
               }

               @Override
               public void onResponse(Call call, Response response) throws IOException {
                  String json = response.body().string();
                  CountryRequest responseDomain = null;
                  try {
                     responseDomain = new ObjectMapper().readValue(json, CountryRequest.class);
                  } catch (Exception e) {
                     Log.d(TAG, e.getMessage());
                  }
               }
            }
      );
      return null;
   }

}
