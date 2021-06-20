package hcmute.edu.vn.id18110304.Communications.WebServices;

import android.net.Uri;

import java.io.File;

import hcmute.edu.vn.id18110304.Communications.IWebServices.IUserService;
import hcmute.edu.vn.id18110304.Communications.Response.UserResponse;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * UserService
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class UserService extends GenericService<IUserService> {
   private static UserService instance = null;

   private UserService() {
      super(IUserService.class);
   }

   public static UserService getInstance() {
      if (instance == null) {
         instance = new UserService();
      }
      return instance;
   }

   public void getInfo(String token, Callback<UserResponse.GetInfoResponse> cb) {
      Call<UserResponse.GetInfoResponse> call = service.getInfo(token);
      call.enqueue(cb);
   }

   public void login(String loginJSON, Callback<UserResponse.LoginResponse> cb) {
      RequestBody requestBody = RequestBody.create( MediaType.parse("text/json"),loginJSON);
      Call<UserResponse.LoginResponse> call = service.login(requestBody);
      call.enqueue(cb);
   }

   public void signup(String phone, String password, Uri userImageUri,
                      String firstName, String lastName, int gender, Callback<UserResponse> cb) {

      File file = new File(userImageUri.getPath());
      RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);

      Call<UserResponse> call = service.signup(
            RequestBody.create(MediaType.parse("text/plain"), phone),
            RequestBody.create(MediaType.parse("text/plain"), password),
            MultipartBody.Part.createFormData("image", file.getName(), requestFile),
            RequestBody.create(MediaType.parse("text/plain"), firstName),
            RequestBody.create(MediaType.parse("text/plain"), lastName),
            RequestBody.create(MediaType.parse("text/plain"), String.valueOf(gender))
      );
      call.enqueue(cb);
   }
}