package hcmute.edu.vn.id18110304.Communications.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import hcmute.edu.vn.id18110304.Communications.Domains.ProductDomain;

/**
 * ProductResponse
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class ProductResponse extends GenericResponse<ProductDomain> {

   @JsonProperty("pagination")
   private PaginationBean pagination;

   public PaginationBean getPagination() {
      return pagination;
   }

   public void setPagination(PaginationBean pagination) {
      this.pagination = pagination;
   }

   @JsonIgnoreProperties(ignoreUnknown = true)
   public static class PaginationBean {
      @JsonProperty("totalPage")
      private int totalPage;

      @JsonProperty("total")
      private int total;

      @JsonProperty("hasPrevPage")
      private boolean hasPrevPage;

      @JsonProperty("hasNextPage")
      private boolean hasNextPage;

      @JsonProperty("pagingCounter")
      private int pagingCounter;

      @JsonProperty("offset")
      private int offset;

      @JsonProperty("limit")
      private int limit;

      @JsonProperty("page")
      private int page;

      public int getTotalPage() {
         return totalPage;
      }

      public void setTotalPage(int totalPage) {
         this.totalPage = totalPage;
      }

      public int getTotal() {
         return total;
      }

      public void setTotal(int total) {
         this.total = total;
      }

      public boolean getHasPrevPage() {
         return hasPrevPage;
      }

      public void setHasPrevPage(boolean hasPrevPage) {
         this.hasPrevPage = hasPrevPage;
      }

      public boolean getHasNextPage() {
         return hasNextPage;
      }

      public void setHasNextPage(boolean hasNextPage) {
         this.hasNextPage = hasNextPage;
      }

      public int getPagingCounter() {
         return pagingCounter;
      }

      public void setPagingCounter(int pagingCounter) {
         this.pagingCounter = pagingCounter;
      }

      public int getOffset() {
         return offset;
      }

      public void setOffset(int offset) {
         this.offset = offset;
      }

      public int getLimit() {
         return limit;
      }

      public void setLimit(int limit) {
         this.limit = limit;
      }

      public int getPage() {
         return page;
      }

      public void setPage(int page) {
         this.page = page;
      }
   }
}
