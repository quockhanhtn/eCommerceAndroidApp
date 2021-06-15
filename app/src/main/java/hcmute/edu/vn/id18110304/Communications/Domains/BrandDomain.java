package hcmute.edu.vn.id18110304.Communications.Domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * BrandDomain
 *
 * @author  Khanh Lam
 * @version 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BrandDomain extends GenericDomain<String> implements Serializable {
   @JsonProperty("brandId")
   Integer brandId;

   @JsonProperty("name")
   String name;

   @JsonProperty("slug")
   String slug;

   @JsonProperty("description")
   String description;

   @JsonProperty("origin")
   String origin;

   @JsonProperty("image")
   String image;

   @JsonProperty("isDelete")
   Boolean isDelete;

   public Integer getBrandId() {
      return brandId;
   }

   public void setBrandId(Integer brandId) {
      this.brandId = brandId;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getSlug() {
      return slug;
   }

   public void setSlug(String slug) {
      this.slug = slug;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public String getOrigin() {
      return origin;
   }

   public void setOrigin(String origin) {
      this.origin = origin;
   }

   public String getImage() {
      return image;
   }

   public void setImage(String image) {
      this.image = image;
   }

   public Boolean getDelete() {
      return isDelete;
   }

   public void setDelete(Boolean delete) {
      isDelete = delete;
   }
}
