package hcmute.edu.vn.id18110304.Daos;

import java.util.List;

import hcmute.edu.vn.id18110304.Domains.CountryDomain;
import hcmute.edu.vn.id18110304.Interfaces.IGenericDao;

public class CountryDao implements IGenericDao {

   String API_RESOURCE = "/countries";

   private static CountryDao instance = null;

   private CountryDao() {
   }

   public static CountryDao getInstance() {
      if (instance == null) {
         instance = new CountryDao();
      }
      return instance;
   }

   @Override
   public List<CountryDomain> getAll() {
      return null;
   }

   @Override
   public List getById(Object id) {
      return null;
   }

   @Override
   public boolean update(Object object) {
      return false;
   }

   @Override
   public boolean delete(Object id) {
      return false;
   }
}
