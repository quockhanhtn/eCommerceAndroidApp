package hcmute.edu.vn.id18110304.Domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GenericDomain {
   @JsonProperty("_id")
   String id;

   @JsonProperty("createdAt")
   String createdAt;

   @JsonProperty("updatedAt")
   String updatedAt;

   public String getId() {
      return id;
   }

   public void setId(String id) {
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
