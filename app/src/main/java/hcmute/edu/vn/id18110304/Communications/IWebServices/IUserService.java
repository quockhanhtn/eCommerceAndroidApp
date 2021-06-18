package hcmute.edu.vn.id18110304.Communications.IWebServices;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/**
 * IUserService
 *
 * @author Khanh Lam
 * @version 1.0
 */
public interface IUserService {
   String API_RESOURCE = "user";

   @POST(API_RESOURCE + "/signup")
   Call<Object> signup();

   @Headers("Content-type: application/json")
   @POST(API_RESOURCE + "/login")
   Call<Object> login(@Body String loginInfoJson);

   @GET(API_RESOURCE + "/info")
   Call<Object> getInfo();

   @PUT(API_RESOURCE + "/update")
   Call<Object> updateInfo();
}
