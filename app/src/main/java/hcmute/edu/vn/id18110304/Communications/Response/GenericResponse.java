package hcmute.edu.vn.id18110304.Communications.Response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * GenericResponse
 *
 * @author Khanh Lam
 * @version 1.0
 */
public abstract class GenericResponse<T> {

   @JsonProperty("success")
   boolean success;

   @JsonProperty("status")
   String message;

   @JsonProperty("data")
   List<T> data;

   public boolean isSuccess() {
      return success;
   }

   public void setSuccess(boolean success) {
      this.success = success;
   }

   public String getMessage() {
      return message;
   }

   public void setMessage(String message) {
      this.message = message;
   }

   public List<T> getData() {
      return data;
   }

   public void setData(List<T> data) {
      this.data = data;
   }
}
