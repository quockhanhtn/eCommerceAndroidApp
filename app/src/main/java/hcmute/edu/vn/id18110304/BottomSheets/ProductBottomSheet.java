package hcmute.edu.vn.id18110304.BottomSheets;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.squareup.picasso.Picasso;

import hcmute.edu.vn.id18110304.Communications.Domains.ProductDomain;
import hcmute.edu.vn.id18110304.CustomViews.MyRadioButton;
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

   public interface IProductBottomSheetListener {
      void addToFavorite(ProductDomain product, String productType, int quantity);

      void addToCart(ProductDomain product, String productType, int quantity);

      void buyNow(ProductDomain product, String productType, int quantity);
   }

   public static void show(Context context, ProductDomain product, IProductBottomSheetListener listener) {
      final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
            context,
            R.style.BottomSheetDialogTheme
      );

      BottomSheetProductBinding binding = BottomSheetProductBinding.inflate(
            LayoutInflater.from(context)
      );

      Picasso.get().load(product.getThumbnail()).into(binding.ivProductThumbnail);

      binding.tvProductName.setText(product.getName());
      binding.tvProductPrice.setText(product.getPriceFormat());
      TextViewUtils.setHtml(binding.tvProductMarketPrice, product.getMarketPriceFormat());
      TextViewUtils.setHtml(binding.tvProductCategory, product.getCategoryName());
      TextViewUtils.setHtml(binding.tvProductBrand, product.getBrandName());
      binding.tvProductDiscountPercent.setText(product.getDiscountPercent());

      boolean hasProductType = product.getProductTypes() != null && product.getProductTypes().size() > 0;
      if (hasProductType) {
         binding.layoutProductOption.setVisibility(View.VISIBLE);

         LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
               ViewGroup.LayoutParams.WRAP_CONTENT,
               100
         );
         layoutParams.setMarginEnd(10);

         for (int i = 0; i < product.getProductTypes().size(); i++) {

            MyRadioButton radioButton = (MyRadioButton) LayoutInflater.from(context)
                  .inflate(R.layout.item_radio, null);
            radioButton.setText(product.getProductTypes().get(i));
            radioButton.setId(i + 100);
            radioButton.setLayoutParams(layoutParams);
            radioButton.setChecked(i == 0);
            binding.radioGroup.addView(radioButton);
         }
      } else {
         binding.layoutProductOption.setVisibility(View.GONE);
      }

      binding.layoutBtnAddToCarts.setOnClickListener(v -> {
         if (hasProductType) {
            @SuppressLint("ResourceType") int typeIndex = binding.radioGroup.getCheckedRadioButtonId() - 100;
            listener.addToCart(
                  product,
                  product.getProductTypes().get(typeIndex),
                  1
            );
         } else {
            listener.addToCart(product, null, 1);
         }
         bottomSheetDialog.dismiss();
      });

      bottomSheetDialog.setContentView(binding.getRoot());
      bottomSheetDialog.show();
   }
}
