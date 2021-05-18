package hcmute.edu.vn.id18110304.Domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryDomain extends GenericDomain {
   @JsonProperty("name")
   String name;

   @JsonProperty("parent")
   CategoryDomain parent;

   @JsonProperty("isPrimary")
   Boolean isPrimary;

   @JsonProperty("image")
   String image;

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public CategoryDomain getParent() {
      return parent;
   }

   public void setParent(CategoryDomain parent) {
      this.parent = parent;
   }

   public Boolean getPrimary() {
      return isPrimary;
   }

   public void setPrimary(Boolean primary) {
      isPrimary = primary;
   }

   public String getImage() {
      return image;
   }

   public void setImage(String image) {
      this.image = image;
   }
}