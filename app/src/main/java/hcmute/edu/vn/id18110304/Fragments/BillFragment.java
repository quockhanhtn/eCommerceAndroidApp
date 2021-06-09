package hcmute.edu.vn.id18110304.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import hcmute.edu.vn.id18110304.R;

/**
 * BillFragment
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class BillFragment extends Fragment {

   public BillFragment() {
      // Required empty public constructor
   }

   public static BillFragment newInstance(String param1, String param2) {
      BillFragment fragment = new BillFragment();
      return fragment;
   }

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
   }

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
      // Inflate the layout for this fragment
      return inflater.inflate(R.layout.fragment_bill, container, false);
   }
}