package hcmute.edu.vn.id18110304.Daos;

import java.util.Arrays;
import java.util.List;

import hcmute.edu.vn.id18110304.Domains.CountryDomain;
import hcmute.edu.vn.id18110304.R;

public class CountryDao {
   private static CountryDao instance = null;

   private CountryDao() {
   }

   public static CountryDao getInstance() {
      if (instance == null) {
         instance = new CountryDao();
      }
      return instance;
   }

   public static List<CountryDomain> getAll() {
      List<CountryDomain> result = Arrays.asList(
            new CountryDomain("name", "code", "2digit", "3digit", R.drawable.flag_ad),
            new CountryDomain("name", "code", "2digit", "3digit", R.drawable.flag_ad)
      );
      return result;
   }
}
