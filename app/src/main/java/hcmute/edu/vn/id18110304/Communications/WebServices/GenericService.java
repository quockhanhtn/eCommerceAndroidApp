package hcmute.edu.vn.id18110304.Communications.WebServices;

import hcmute.edu.vn.id18110304.Cons;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * GenericService
 *
 * @author Khanh Lam
 * @version 1.0
 */
public abstract class GenericService<IWebServiceType> {
   Retrofit retrofit = null;
   IWebServiceType service;

   public GenericService(Class<IWebServiceType> iWebServiceTypeClass) {
      retrofit = new Retrofit.Builder()
            .baseUrl(Cons.WEBSERVICE_BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .build();

      service = retrofit.create(iWebServiceTypeClass);
   }
}
