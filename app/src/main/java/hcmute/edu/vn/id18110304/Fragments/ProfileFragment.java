package hcmute.edu.vn.id18110304.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hcmute.edu.vn.id18110304.Interfaces.INavigationListener;
import hcmute.edu.vn.id18110304.R;

/**
 * ProfileFragment
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class ProfileFragment extends GenericFragment {

   public static final String TAG = ProfileFragment.class.getName();

   public ProfileFragment() {
   }

   public ProfileFragment(INavigationListener navigationListener) {
      super(navigationListener);
   }

   public static ProfileFragment newInstance() {
      ProfileFragment fragment = new ProfileFragment();
      return fragment;
   }

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
   }

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
      return inflater.inflate(R.layout.fragment_profile, container, false);
   }
}