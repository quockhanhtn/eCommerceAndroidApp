package hcmute.edu.vn.id18110304.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import hcmute.edu.vn.id18110304.Activities.LoginActivity;
import hcmute.edu.vn.id18110304.Activities.SendOtpActivity;
import hcmute.edu.vn.id18110304.BottomSheets.ProductBottomSheet;
import hcmute.edu.vn.id18110304.R;
import hcmute.edu.vn.id18110304.Utils.DialogUtils;
import hcmute.edu.vn.id18110304.databinding.BottomSheetProductBinding;
import hcmute.edu.vn.id18110304.databinding.FragmentSavedBinding;
import io.noties.markwon.Markwon;

/**
 * SavedFragment
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class SavedFragment extends Fragment {

   public static final String TAG = SavedFragment.class.getSimpleName();

   private FragmentSavedBinding binding;

   // Required empty public constructor
   public SavedFragment() {

   }

   public static SavedFragment newInstance() {
      return new SavedFragment();
   }

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
   }

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
      binding = FragmentSavedBinding.inflate(inflater, container, false);

      final Markwon markwon = Markwon.create(getContext());

      // set markdown
      markwon.setMarkdown(binding.tvTestMarkDown, "## Cấu hình Điện thoại Vsmart Joy 4 (3GB/64GB)\n\n- Màn hình: LTPS IPS LCD6.53\"Full HD+\n- Hệ điều hành: Android 10\n- Camera sau: Chính 16 MP & Phụ 8 MP, 2 MP, 2 MP\n- Camera trước: 13 MP\n- Chip: Snapdragon 665\n- RAM: 3 GB \n- Bộ nhớ trong: 64 GB\n- SIM: 2 Nano SIM, Hỗ trợ 4G\n- Pin, Sạc: 5000 mAh18 W\n\n## Ngoại hình tinh tế, sắc sảo\n\n Vsmart Joy 4 được trang bị màn hình \"nốt ruồi\" có kich thước 6.53 inch với các cạnh màn hình được mở rộng tối đa giúp máy có thêm không gian hiển thị, mang lại trải nghiệm giải trí tuyệt vời.\n\n Mặt lưng của máy với điểm nhấn nằm ở những đường vân sáng cong cực quang tuyệt đẹp, khiến chiếc điện thoại trở nên thu hút theo từng cử động của bạn.\n\n### Nguồn [thegioididong.com](https://www.thegioididong.com/dtdd/vsmart-joy-4)");

      return binding.getRoot();
   }

   @Override
   public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
      super.onActivityCreated(savedInstanceState);

      binding.buttonShowBottomSheet.setOnClickListener(v -> {
         //ProductBottomSheet.show(getContext());
//         final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
//               requireActivity(),
//               R.style.BottomSheetDialogTheme
//         );
//         View bottomSheetView = LayoutInflater.from(getContext())
//               .inflate(
//                     R.layout.layout_bottom_sheet,
//                     (LinearLayout) requireActivity().findViewById(R.id.bottom_sheet_container)
//               );
//         bottomSheetView.findViewById(R.id.bottom_sheet_main_button).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               Toast.makeText(getActivity(), "Share...", Toast.LENGTH_SHORT).show();
//               bottomSheetDialog.dismiss();
//            }
//         });
//         bottomSheetDialog.setContentView(bottomSheetView);
//         bottomSheetDialog.show();
      });

      binding.buttonShowSuccess.setOnClickListener(v -> showSuccess());
      binding.buttonShowWarning.setOnClickListener(v -> showWarning());
      binding.buttonShowError.setOnClickListener(v -> showError());
   }

   void showSuccess() {


      DialogUtils.showSuccessDialog(
            "Success dialog",
            "Message",
            getActivity(),
            (View.OnClickListener) v -> {
               Toast.makeText(getContext(), "Success", Toast.LENGTH_SHORT).show();
            });
   }

   void showWarning() {
//      DialogUtils.showWarningDialog(
//            "Warning dialog",
//            "Message",
//            getActivity(),
//            (View.OnClickListener) v -> {
//               Toast.makeText(getContext(), "Yes", Toast.LENGTH_SHORT).show();
//            },
//            (View.OnClickListener) v -> {
//               Toast.makeText(getContext(), "No", Toast.LENGTH_SHORT).show();
//            });

      Intent intent = new Intent(getContext(), LoginActivity.class);
      startActivity(intent);
   }

   void showError() {
//      DialogUtils.showErrorDialog(
//            "Error dialog",
//            "Message",
//            getActivity(),
//            (View.OnClickListener) v -> {
//               Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
//            });

      Intent intent = new Intent(getContext(), SendOtpActivity.class);
      startActivity(intent);
   }
}