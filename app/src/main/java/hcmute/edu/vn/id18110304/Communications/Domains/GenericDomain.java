package hcmute.edu.vn.id18110304.Communications.Domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * GenericDomain
 *
 * @author Khanh Lam
 * @version 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class GenericDomain<IdType> {
   @JsonProperty("_id")
   IdType id;

   @JsonProperty("createdAt")
   String createdAt;

   @JsonProperty("updatedAt")
   String updatedAt;

   public IdType getId() {
      return id;
   }

   public void setId(IdType id) {
      this.id = id;
   }

   public String getCreatedAt() {
      return createdAt;
   }

   public void setCreatedAt(String createdAt) {
      this.createdAt = createdAt;
   }

   public String getUpdatedAt() {
      return updatedAt;
   }

   public void setUpdatedAt(String updatedAt) {
      this.updatedAt = updatedAt;
   }
}
