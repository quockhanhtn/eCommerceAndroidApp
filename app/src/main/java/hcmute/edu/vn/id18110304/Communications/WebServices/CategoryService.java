package hcmute.edu.vn.id18110304.Communications.WebServices;

import hcmute.edu.vn.id18110304.Communications.IWebServices.ICategoryService;
import hcmute.edu.vn.id18110304.Communications.Response.CategoryResponse;
import retrofit2.Call;
import retrofit2.Callback;


public class CategoryService extends GenericService<ICategoryService, CategoryResponse> {
   private static CategoryService instance = null;

   private CategoryService() {
      super(ICategoryService.class);
   }

   public static CategoryService getInstance() {
      if (instance == null) {
         instance = new CategoryService();
      }
      return instance;
   }

   @Override
   public void getAll(Callback<CategoryResponse> cb) {
      Call<CategoryResponse> call = service.getAll();
      call.enqueue(cb);
   }
}
