package hcmute.edu.vn.id18110304.Communications.WebServices;

import hcmute.edu.vn.id18110304.Communications.IWebServices.IUserService;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * UserService
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class UserService extends GenericService<IUserService, Object> {
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

   @Override
   public void getAll(Callback<Object> cb) {

   }

   public void login(Callback<Object> cb) {
      Call<Object> call = service.login("");
      call.enqueue(cb);
   }
}