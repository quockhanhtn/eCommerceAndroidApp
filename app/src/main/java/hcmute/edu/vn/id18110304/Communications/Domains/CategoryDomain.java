package hcmute.edu.vn.id18110304.Communications.Domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * CategoryDomain
 *
 * @author  Khanh Lam
 * @version 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryDomain extends GenericDomain<Integer> {
   @JsonProperty("name")
   String name;

   @JsonProperty("parent")
   CategoryDomain parent;

   @JsonProperty("isPrimary")
   Boolean isPrimary;

   @JsonProperty("image")
   String image;

   @JsonProperty("children")
   List<CategoryDomain> children;

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

   public List<CategoryDomain> getChildren() {
      return children;
   }

   public void setChildren(List<CategoryDomain> children) {
      this.children = children;
   }
}