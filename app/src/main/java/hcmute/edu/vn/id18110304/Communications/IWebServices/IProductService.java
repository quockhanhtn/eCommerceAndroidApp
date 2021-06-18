package hcmute.edu.vn.id18110304.Communications.IWebServices;

import hcmute.edu.vn.id18110304.Communications.Response.ProductResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * IProductService
 *
 * @author Khanh Lam
 * @version 1.0
 */
public interface IProductService {
   String API_RESOURCE = "products";

   @GET(API_RESOURCE)
   Call<ProductResponse> getAll();
}
