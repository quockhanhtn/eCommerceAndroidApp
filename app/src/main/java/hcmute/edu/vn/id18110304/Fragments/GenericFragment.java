package hcmute.edu.vn.id18110304.Fragments;

import androidx.fragment.app.Fragment;

import hcmute.edu.vn.id18110304.Interfaces.INavigationListener;

/**
 * @author Khanh Lam
 * @version 1.0
 */
public abstract class GenericFragment extends Fragment {
   protected INavigationListener navigationListener;

   public GenericFragment() {
   }

   public GenericFragment(INavigationListener navigationListener) {
      this.navigationListener = navigationListener;
   }
}
