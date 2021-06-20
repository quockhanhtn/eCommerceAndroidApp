package hcmute.edu.vn.id18110304.Communications.IWebServices;

import hcmute.edu.vn.id18110304.Communications.Response.UserResponse;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * IUserService
 *
 * @author Khanh Lam
 * @version 1.0
 */
public interface IUserService {
   String API_RESOURCE = "user";

   @GET(API_RESOURCE + "/info")
   Call<UserResponse.GetInfoResponse> getInfo(@Header("Authorization") String accessToken);

   @Headers("Content-type: application/json")
   @POST(API_RESOURCE + "/login")
   Call<UserResponse.LoginResponse> login(@Body RequestBody loginInfoJson);

   @Multipart
   @POST(API_RESOURCE + "/signup")
   Call<UserResponse> signup(@Part("phone") RequestBody phone,
                             @Part("password") RequestBody password,
                             @Part MultipartBody.Part userImage,
                             @Part("firstName") RequestBody firstName,
                             @Part("lastName") RequestBody lastName,
                             @Part("gender") RequestBody gender);

   @PUT(API_RESOURCE + "/update")
   Call<Object> updateInfo();
}
