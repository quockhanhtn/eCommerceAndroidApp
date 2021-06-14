package hcmute.edu.vn.id18110304.BottomSheets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import hcmute.edu.vn.id18110304.R;
import hcmute.edu.vn.id18110304.databinding.BottomSheetProductBinding;
import hcmute.edu.vn.id18110304.databinding.FragmentHomeBinding;

/**
 * ProductBottomSheet
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class ProductBottomSheet {

   public static void show(Context context) {
      final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
            context,
            R.style.BottomSheetDialogTheme
      );

      BottomSheetProductBinding binding = BottomSheetProductBinding.inflate(
            LayoutInflater.from(context)
      );

      bottomSheetDialog.setContentView(binding.getRoot());
      bottomSheetDialog.show();
   }
}
