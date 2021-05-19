package hcmute.edu.vn.id18110304.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

import java.util.logging.Logger;

import hcmute.edu.vn.id18110304.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
   
   public static final String TAG = ProfileFragment.class.getSimpleName();

   // TODO: Rename parameter arguments, choose names that match
   // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
   private static final String ARG_PARAM1 = "param1";
   private static final String ARG_PARAM2 = "param2";

   // TODO: Rename and change types of parameters
   private String mParam1;
   private String mParam2;

   public ProfileFragment() {
      // Required empty public constructor
   }

   /**
    * Use this factory method to create a new instance of
    * this fragment using the provided parameters.
    *
    * @param param1 Parameter 1.
    * @param param2 Parameter 2.
    * @return A new instance of fragment ProfileFragment.
    */
   // TODO: Rename and change types and number of parameters
   public static ProfileFragment newInstance(String param1, String param2) {
      ProfileFragment fragment = new ProfileFragment();
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

      Log.e(TAG, "onCreate");
   }

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
      Log.e(TAG, "onCreateView");

      // Inflate the layout for this fragment
      return inflater.inflate(R.layout.fragment_profile, container, false);
   }

   @Override
   public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
      super.onViewCreated(view, savedInstanceState);
      Log.e(TAG, "onViewCreated");
   }

   @Override
   public void onViewStateRestored(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
      super.onViewStateRestored(savedInstanceState);
      Log.e(TAG, "onViewStateRestored");
   }


   @Override
   public void onStart() {
      super.onStart();
      Log.e(TAG, "onStart");
   }

   @Override
   public void onResume() {
      super.onResume();
      Log.e(TAG, "onResume");
   }

   @Override
   public void onPause() {
      super.onPause();
      Log.e(TAG, "onPause");
   }

   @Override
   public void onStop() {
      super.onStop();
      Log.e(TAG, "onStop");
   }

   @Override
   public void onSaveInstanceState(@NonNull @NotNull Bundle outState) {
      super.onSaveInstanceState(outState);
      Log.e(TAG, "onSaveInstanceState");
   }

   @Override
   public void onDestroyView() {
      super.onDestroyView();
      Log.e(TAG, "onDestroyView");
   }

   @Override
   public void onDestroy() {
      super.onDestroy();
      Log.e(TAG, "onDestroy");
   }
}