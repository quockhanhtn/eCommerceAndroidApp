package hcmute.edu.vn.id18110304.Communications.WebServices;

import hcmute.edu.vn.id18110304.Communications.IWebServices.IProductService;
import hcmute.edu.vn.id18110304.Communications.Response.ProductResponse;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * ProductService
 *
 * @author  Khanh Lam
 * @version 1.0
 */
public class ProductService extends GenericService<IProductService, ProductResponse> {
   private static ProductService instance = null;

   private ProductService() {
      super(IProductService.class);
   }

   public static ProductService getInstance() {
      if (instance == null) {
         instance = new ProductService();
      }
      return instance;
   }

   @Override
   public void getAll(Callback<ProductResponse> cb) {
      Call<ProductResponse> call = service.getAll();
      call.enqueue(cb);
   }
}
