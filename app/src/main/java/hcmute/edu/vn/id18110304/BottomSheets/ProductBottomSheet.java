package hcmute.edu.vn.id18110304.BottomSheets;

import android.content.Context;
import android.view.LayoutInflater;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.squareup.picasso.Picasso;

import hcmute.edu.vn.id18110304.Communications.Domains.ProductDomain;
import hcmute.edu.vn.id18110304.R;
import hcmute.edu.vn.id18110304.Utils.TextViewUtils;
import hcmute.edu.vn.id18110304.databinding.BottomSheetProductBinding;

/**
 * ProductBottomSheet
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class ProductBottomSheet {

   public static void show(Context context, ProductDomain product) {
      final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
            context,
            R.style.BottomSheetDialogTheme
      );

      BottomSheetProductBinding binding = BottomSheetProductBinding.inflate(
            LayoutInflater.from(context)
      );

      binding.tvProductName.setText(product.getName());
      binding.tvProductPrice.setText(product.getPriceFormat());
      TextViewUtils.setHtml(binding.tvProductMarketPrice, product.getMarketPriceFormat());
      TextViewUtils.setHtml(binding.tvProductCategory, product.getCategoryName());
      TextViewUtils.setHtml(binding.tvProductBrand, product.getBrandName());

      Picasso.get().load(product.getThumbnail()).into(binding.ivProductThumbnail);


      bottomSheetDialog.setContentView(binding.getRoot());
      bottomSheetDialog.show();
   }
}
