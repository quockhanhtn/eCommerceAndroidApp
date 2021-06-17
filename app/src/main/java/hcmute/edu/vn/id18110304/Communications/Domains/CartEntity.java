package hcmute.edu.vn.id18110304.Communications.Domains;

/**
 * CartEntity
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class CartEntity {
   private int order;
   private String productUuid;
   private ProductDomain product;
   private String productType;
   private int quantity;
   boolean isSelected;

   public int getOrder() {
      return order;
   }

   public void setOrder(int order) {
      this.order = order;
   }

   public String getProductUuid() {
      return productUuid;
   }

   public void setProductUuid(String productUuid) {
      this.productUuid = productUuid;
   }

   public ProductDomain getProduct() {
      return product;
   }

   public void setProduct(ProductDomain product) {
      this.product = product;
   }

   public String getProductType() {
      return productType;
   }

   public void setProductType(String productType) {
      this.productType = productType;
   }

   public int getQuantity() {
      return quantity;
   }

   public void setQuantity(int quantity) {
      this.quantity = quantity;
   }

   public boolean isSelected() {
      return isSelected;
   }

   public void setSelected(boolean selected) {
      isSelected = selected;
   }
}
