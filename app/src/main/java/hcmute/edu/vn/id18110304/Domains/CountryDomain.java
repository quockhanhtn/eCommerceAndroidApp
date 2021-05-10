package hcmute.edu.vn.id18110304.Domains;

public class CountryDomain {
   String countryName;
   String countryCode;
   String threeDigitIsoCode;
   String twoDigitIsoCode;
   Integer flagId;

   public CountryDomain(String countryName, String countryCode, String threeDigitIsoCode, String twoDigitIsoCode, Integer flagId) {
      this.countryName = countryName;
      this.countryCode = countryCode;
      this.threeDigitIsoCode = threeDigitIsoCode;
      this.twoDigitIsoCode = twoDigitIsoCode;
      this.flagId = flagId;
   }

   public String getCountryName() {
      return countryName;
   }

   public void setCountryName(String countryName) {
      this.countryName = countryName;
   }

   public String getCountryCode() {
      return countryCode;
   }

   public void setCountryCode(String countryCode) {
      this.countryCode = countryCode;
   }

   public String getThreeDigitIsoCode() {
      return threeDigitIsoCode;
   }

   public void setThreeDigitIsoCode(String threeDigitIsoCode) {
      this.threeDigitIsoCode = threeDigitIsoCode;
   }

   public String getTwoDigitIsoCode() {
      return twoDigitIsoCode;
   }

   public void setTwoDigitIsoCode(String twoDigitIsoCode) {
      this.twoDigitIsoCode = twoDigitIsoCode;
   }

   public Integer getFlagId() {
      return flagId;
   }

   public void setFlagId(Integer flagId) {
      this.flagId = flagId;
   }
}
