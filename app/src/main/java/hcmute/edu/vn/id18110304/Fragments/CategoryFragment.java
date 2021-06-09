package hcmute.edu.vn.id18110304.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import hcmute.edu.vn.id18110304.R;

/**
 * CategoryFragment
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class CategoryFragment extends Fragment {

   public CategoryFragment() {
      // Required empty public constructor
   }

   public static CategoryFragment newInstance(String param1, String param2) {
      CategoryFragment fragment = new CategoryFragment();
      Bundle args = new Bundle();
//      args.putString(ARG_PARAM1, param1);
//      args.putString(ARG_PARAM2, param2);
      fragment.setArguments(args);
      return fragment;
   }

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
//      if (getArguments() != null) {
//         mParam1 = getArguments().getString(ARG_PARAM1);
//         mParam2 = getArguments().getString(ARG_PARAM2);
//      }
   }

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
      // Inflate the layout for this fragment
      return inflater.inflate(R.layout.fragment_category, container, false);
   }
}