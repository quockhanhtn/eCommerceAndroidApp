package hcmute.edu.vn.id18110304.Domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryDomain extends GenericDomain {
   @JsonProperty("name")
   String name;

   @JsonProperty("nativeName")
   String nativeName;

   @JsonProperty("alpha2Code")
   String alpha2Code;

   @JsonProperty("alpha3Code")
   String alpha3Code;

   @JsonProperty("callingCodes")
   String callingCodes;

   @JsonProperty("region")
   String region;

   @JsonProperty("subregion")
   String subregion;

   @JsonProperty("imageBase64")
   String imageBase64;

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("userId: " + this.getId() + ", ");
      sb.append("id: " + this.getId() + ", ");
      return sb.toString();
   }
}
