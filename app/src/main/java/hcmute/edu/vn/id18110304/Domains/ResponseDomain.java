package hcmute.edu.vn.id18110304.Domains;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseDomain {
   boolean status;
   String message;
   String data;

   public static final String TAG = ResponseDomain.class.getSimpleName();

   @JsonProperty
   private String responseStatus;

   @JsonProperty
   private String responseDetails;


   public String getResponseStatus() {
      return responseStatus;
   }

   public void setResponseStatus(String responseStatus) {
      this.responseStatus = responseStatus;
   }

   public String getResponseDetails() {
      return responseDetails;
   }

   public void setResponseDetails(String responseDetails) {
      this.responseDetails = responseDetails;
   }
}
