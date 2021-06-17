package hcmute.edu.vn.id18110304.Communications.Domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

import hcmute.edu.vn.id18110304.Utils.FormatUtils;

/**
 * ProductDomain
 *
 * @author Khanh Lam
 * @version 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDomain extends GenericDomain<String> implements Serializable {

   @JsonProperty("productId")
   private int productId;

   @JsonProperty("name")
   private String name;

   @JsonProperty("slug")
   private String slug;

   @JsonProperty("description")
   private String description;

   @JsonProperty("marketPrice")
   private long marketPrice;

   @JsonProperty("price")
   private long price;

   @JsonProperty("productTypes")
   private List<String> productTypes;

   @JsonProperty("thumbnail")
   private String thumbnail;

   @JsonProperty("images")
   private List<String> images;

   @JsonProperty("category")
   private CategoryDomain category;

   @JsonProperty("brand")
   private BrandDomain brand;

   public String getCategoryName() {
      if (category != null) {
         return "<u>" + getCategory().getName() + "</u>";
      }
      return "<u>" + "Un category" + "</u>";
   }

   public String getBrandName() {
      if (brand != null) {
         return "<u>" + getBrand().getName() + "</u>";
      }
      return "<u>" + "No brand" + "</u>";
   }

   public String getDiscountPercent() {
      return "-" + String.valueOf(100 - (price * 100) / marketPrice) + "%";
   }

   public String getPriceFormat() {
      return FormatUtils.formatPrice(price);
   }

   public String getMarketPriceFormat() {
      return FormatUtils.formatPriceWithTag(marketPrice, "del");
   }

   public int getProductId() {
      return productId;
   }

   public void setProductId(int productId) {
      this.productId = productId;
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

   public long getMarketPrice() {
      return marketPrice;
   }

   public void setMarketPrice(long marketPrice) {
      this.marketPrice = marketPrice;
   }

   public long getPrice() {
      return price;
   }

   public void setPrice(long price) {
      this.price = price;
   }

   public List<String> getProductTypes() {
      return productTypes;
   }

   public void setProductTypes(List<String> productTypes) {
      this.productTypes = productTypes;
   }

   public String getThumbnail() {
      return thumbnail;
   }

   public void setThumbnail(String thumbnail) {
      this.thumbnail = thumbnail;
   }

   public List<String> getImages() {
      return images;
   }

   public void setImages(List<String> images) {
      this.images = images;
   }

   public CategoryDomain getCategory() {
      return category;
   }

   public void setCategory(CategoryDomain category) {
      this.category = category;
   }

   public BrandDomain getBrand() {
      return brand;
   }

   public void setBrand(BrandDomain brand) {
      this.brand = brand;
   }
}
