package hcmute.edu.vn.id18110304.Utils;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * FormatUtils
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class FormatUtils {
   public static String formatPrice(long price, String currency) {
      return NumberFormat.getNumberInstance(Locale.GERMAN).format(price) + currency;
   }

   public static String formatPrice(long price) {
      return formatPrice(price, "₫");
   }

   public static String formatPriceWithTag(long price, String htmlTag, String currency) {
      return "<" + htmlTag + ">" + formatPrice(price, currency) + "</" + htmlTag + ">";
   }

   public static String formatPriceWithTag(long price, String htmlTag) {
      return formatPriceWithTag(price, htmlTag, "₫");
   }
}
