package hcmute.edu.vn.id18110304.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hcmute.edu.vn.id18110304.Activities.LoginActivity;
import hcmute.edu.vn.id18110304.Activities.SignUpActivity;
import hcmute.edu.vn.id18110304.Interfaces.INavigationListener;
import hcmute.edu.vn.id18110304.databinding.FragmentProfileBinding;

/**
 * ProfileFragment
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class ProfileFragment extends GenericFragment {

   public static final String TAG = ProfileFragment.class.getName();
   private FragmentProfileBinding binding;

   public ProfileFragment() {
   }

   public ProfileFragment(INavigationListener navigationListener) {
      super(navigationListener);
   }

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
      binding = FragmentProfileBinding.inflate(inflater, container, false);

      binding.layoutNotLogin.setVisibility(View.VISIBLE);
      binding.layoutLogined.setVisibility(View.GONE);

      binding.btnLogin.setOnClickListener(v -> {
         Intent intent = new Intent(requireActivity(), LoginActivity.class);
         startActivity(intent);
         binding.layoutNotLogin.setVisibility(View.GONE);
         binding.layoutLogined.setVisibility(View.VISIBLE);
      });

      binding.btnSignIn.setOnClickListener(v -> {
         Intent intent = new Intent(requireActivity(), SignUpActivity.class);
         startActivity(intent);
         binding.layoutNotLogin.setVisibility(View.GONE);
         binding.layoutLogined.setVisibility(View.VISIBLE);
      });

      return binding.getRoot();
   }
}