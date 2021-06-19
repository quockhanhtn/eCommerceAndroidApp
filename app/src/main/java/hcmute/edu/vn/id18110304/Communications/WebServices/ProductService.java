package hcmute.edu.vn.id18110304.Communications.WebServices;

import hcmute.edu.vn.id18110304.Communications.IWebServices.IProductService;
import hcmute.edu.vn.id18110304.Communications.Response.ProductResponse;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * ProductService
 *
 * @author Khanh Lam
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

   public void get(String searchText, int page, int limit, Callback<ProductResponse> cb) {
      Call<ProductResponse> call = service.get(searchText, page, limit);
      call.enqueue(cb);
   }

   @Override
   public void getAll(Callback<ProductResponse> cb) {
      Call<ProductResponse> call = service.get(null, 1, 10);
      call.enqueue(cb);
   }
}
