package hcmute.edu.vn.id18110304.Communications.IWebServices;

import hcmute.edu.vn.id18110304.Communications.Response.BrandResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * IBrandService
 *
 * @author Khanh Lam
 * @version 1.0
 */
public interface IBrandService {
   String API_RESOURCE = "brands";

   @GET(API_RESOURCE)
   Call<BrandResponse> getAll();
}