package hcmute.edu.vn.id18110304.Interfaces;

import java.util.List;

public interface IGenericDao<DomainType, IdType> {
   public List<DomainType> getAll();

   public List<DomainType> getById(IdType id);

   public boolean update(DomainType object);

   public boolean delete(IdType id);
}
