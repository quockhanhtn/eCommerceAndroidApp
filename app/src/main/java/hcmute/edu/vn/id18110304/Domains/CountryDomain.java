package hcmute.edu.vn.id18110304.Domains;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountryDomain {
   @JsonProperty("_id")
   String id;

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
}
