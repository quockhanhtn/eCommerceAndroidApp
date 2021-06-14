package hcmute.edu.vn.id18110304.Communications.IWebServices;

import hcmute.edu.vn.id18110304.Communications.Response.CategoryResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * ICategoryService
 *
 * @author  Khanh Lam
 * @version 1.0
 */
public interface ICategoryService {
   String API_RESOURCE = "categories";

   @GET(API_RESOURCE)
   Call<CategoryResponse> getAll();
}