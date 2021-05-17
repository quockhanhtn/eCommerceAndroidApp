package hcmute.edu.vn.id18110304.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import hcmute.edu.vn.id18110304.R;
import hcmute.edu.vn.id18110304.Utils.DialogUtils;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

   public static final String TAG = HomeFragment.class.getSimpleName();

   View selfView;

   Button btnShow, btnSuccess, btnWarning, btnError;

   // TODO: Rename parameter arguments, choose names that match
   // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
   private static final String ARG_PARAM1 = "param1";
   private static final String ARG_PARAM2 = "param2";

   // TODO: Rename and change types of parameters
   private String mParam1;
   private String mParam2;

   public HomeFragment() {
      // Required empty public constructor
   }

   /**
    * Use this factory method to create a new instance of
    * this fragment using the provided parameters.
    *
    * @param param1 Parameter 1.
    * @param param2 Parameter 2.
    * @return A new instance of fragment HomeFragment.
    */
   // TODO: Rename and change types and number of parameters
   public static HomeFragment newInstance(String param1, String param2) {
      HomeFragment fragment = new HomeFragment();
      Bundle args = new Bundle();
      args.putString(ARG_PARAM1, param1);
      args.putString(ARG_PARAM2, param2);
      fragment.setArguments(args);
      return fragment;
   }

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      if (getArguments() != null) {
         mParam1 = getArguments().getString(ARG_PARAM1);
         mParam2 = getArguments().getString(ARG_PARAM2);
      }
   }

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
      // Inflate the layout for this fragment
      selfView = inflater.inflate(R.layout.fragment_home, container, false);
      return selfView;
   }

   @Override
   public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
      super.onActivityCreated(savedInstanceState);

      btnShow = selfView.findViewById(R.id.button_show_bottom_sheet);
      btnSuccess = selfView.findViewById(R.id.button_show_success);
      btnWarning = selfView.findViewById(R.id.button_show_alert);
      btnError = selfView.findViewById(R.id.button_show_error);

      btnShow.setOnClickListener(v -> {
         final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
               getActivity(),
               R.style.BottomSheetDialogTheme
         );
         View bottomSheetView = LayoutInflater.from(getActivity().getApplicationContext())
               .inflate(
                     R.layout.layout_bottom_sheet,
                     (LinearLayout) getActivity().findViewById(R.id.bottom_sheet_container)
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

      btnSuccess.setOnClickListener(v -> showSuccess());
      btnWarning.setOnClickListener(v -> showWarning());
      btnError.setOnClickListener(v -> showError());
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