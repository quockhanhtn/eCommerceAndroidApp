package hcmute.edu.vn.id18110304.Domains;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public class ResponseDomain<T> {
   public static final String TAG = ResponseDomain.class.getSimpleName();

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
