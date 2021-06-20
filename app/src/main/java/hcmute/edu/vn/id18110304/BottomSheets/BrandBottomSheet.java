package hcmute.edu.vn.id18110304.BottomSheets;

import android.content.Context;
import android.view.LayoutInflater;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.squareup.picasso.Picasso;

import hcmute.edu.vn.id18110304.Communications.Domains.BrandDomain;
import hcmute.edu.vn.id18110304.R;
import hcmute.edu.vn.id18110304.databinding.BottomSheetBrandBinding;

/**
 * BrandBottomSheet
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class BrandBottomSheet {
   public static void show(Context context, BrandDomain brand) {
      final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
            context,
            R.style.BottomSheetDialogTheme
      );

      BottomSheetBrandBinding binding = BottomSheetBrandBinding.inflate(
            LayoutInflater.from(context)
      );

      Picasso.get().load("https://ecommerce-api.quockhanh.dev/" + brand.getImage())
            .into(binding.ivBrandImage);

      binding.tvBrandName.setText(brand.getName());
      binding.tvBrandDesc.setText(brand.getDescription());


      binding.btnClose.setOnClickListener(v -> {
         bottomSheetDialog.dismiss();
      });

      bottomSheetDialog.setContentView(binding.getRoot());
      bottomSheetDialog.show();
   }
}
