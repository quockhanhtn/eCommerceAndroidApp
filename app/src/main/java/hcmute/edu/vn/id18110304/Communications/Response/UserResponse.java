package hcmute.edu.vn.id18110304.Communications.Response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Khanh Lam
 * @version 1.0
 */
public abstract class UserResponse extends GenericResponse<Object> {

   public class LoginResponse {

      @JsonProperty("data")
      private DataEntity data;
      @JsonProperty("message")
      private String message;
      @JsonProperty("success")
      private boolean success;

      public DataEntity getData() {
         return data;
      }

      public void setData(DataEntity data) {
         this.data = data;
      }

      public String getMessage() {
         return message;
      }

      public void setMessage(String message) {
         this.message = message;
      }

      public boolean getSuccess() {
         return success;
      }

      public void setSuccess(boolean success) {
         this.success = success;
      }

      public class DataEntity {
         @JsonProperty("token")
         private String token;

         public String getToken() {
            return token;
         }

         public void setToken(String token) {
            this.token = token;
         }
      }
   }

   public class GetInfoResponse {
      @JsonProperty("data")
      private DataEntity data;
      @JsonProperty("success")
      private boolean success;

      public DataEntity getData() {
         return data;
      }

      public void setData(DataEntity data) {
         this.data = data;
      }

      public boolean getSuccess() {
         return success;
      }

      public void setSuccess(boolean success) {
         this.success = success;
      }

      public class DataEntity {
         @JsonProperty("image")
         private String image;
         @JsonProperty("lastName")
         private String lastName;
         @JsonProperty("firstName")
         private String firstName;
         @JsonProperty("phone")
         private String phone;
         @JsonProperty("_id")
         private String _id;
         @JsonProperty("userType")
         private String userType;
         @JsonProperty("gender")
         private int gender;

         public String getImage() {
            return image;
         }

         public void setImage(String image) {
            this.image = image;
         }

         public String getLastName() {
            return lastName;
         }

         public void setLastName(String lastName) {
            this.lastName = lastName;
         }

         public String getFirstName() {
            return firstName;
         }

         public void setFirstName(String firstName) {
            this.firstName = firstName;
         }

         public String getPhone() {
            return phone;
         }

         public void setPhone(String phone) {
            this.phone = phone;
         }

         public String get_id() {
            return _id;
         }

         public void set_id(String _id) {
            this._id = _id;
         }

         public String getUserType() {
            return userType;
         }

         public void setUserType(String userType) {
            this.userType = userType;
         }

         public int getGender() {
            return gender;
         }

         public void setGender(int gender) {
            this.gender = gender;
         }
      }
   }
}
