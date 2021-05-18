package hcmute.edu.vn.id18110304.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.Objects;

import hcmute.edu.vn.id18110304.R;
import hcmute.edu.vn.id18110304.Utils.DialogUtils;
import hcmute.edu.vn.id18110304.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {

   public static final String TAG = HomeFragment.class.getSimpleName();

   private FragmentHomeBinding binding;

   // Required empty public constructor
   public HomeFragment() {
   }

   public static HomeFragment newInstance() {
      return new HomeFragment();
   }

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
   }

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
      binding = FragmentHomeBinding.inflate(inflater, container, false);
      return binding.getRoot();
   }

   @Override
   public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
      super.onActivityCreated(savedInstanceState);

      binding.buttonShowBottomSheet.setOnClickListener(v -> {
         final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
               requireActivity(),
               R.style.BottomSheetDialogTheme
         );
         View bottomSheetView = LayoutInflater.from(getContext())
               .inflate(
                     R.layout.layout_bottom_sheet,
                     (LinearLayout) requireActivity().findViewById(R.id.bottom_sheet_container)
               );
         bottomSheetView.findViewById(R.id.bottom_sheet_main_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Toast.makeText(getActivity(), "Share...", Toast.LENGTH_SHORT).show();
               bottomSheetDialog.dismiss();
            }
         });
         bottomSheetDialog.setContentView(bottomSheetView);
         bottomSheetDialog.show();
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
      DialogUtils.showWarningDialog(
            "Warning dialog",
            "Message",
            getActivity(),
            (View.OnClickListener) v -> {
               Toast.makeText(getContext(), "Yes", Toast.LENGTH_SHORT).show();
            },
            (View.OnClickListener) v -> {
               Toast.makeText(getContext(), "No", Toast.LENGTH_SHORT).show();
            });
   }

   void showError() {
      DialogUtils.showErrorDialog(
            "Error dialog",
            "Message",
            getActivity(),
            (View.OnClickListener) v -> {
               Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
            });

   }
}