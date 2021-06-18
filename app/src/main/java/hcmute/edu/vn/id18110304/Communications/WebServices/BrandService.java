package hcmute.edu.vn.id18110304.Communications.WebServices;

import hcmute.edu.vn.id18110304.Communications.IWebServices.IBrandService;
import hcmute.edu.vn.id18110304.Communications.Response.BrandResponse;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * BrandService
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class BrandService extends GenericService<IBrandService, BrandResponse> {
   private static BrandService instance = null;

   private BrandService() {
      super(IBrandService.class);
   }

   public static BrandService getInstance() {
      if (instance == null) {
         instance = new BrandService();
      }
      return instance;
   }

   @Override
   public void getAll(Callback<BrandResponse> cb) {
      Call<BrandResponse> call = service.getAll();
      call.enqueue(cb);
   }
}
