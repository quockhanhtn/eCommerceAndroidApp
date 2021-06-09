package hcmute.edu.vn.id18110304.Activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import hcmute.edu.vn.id18110304.Interfaces.IGenericActivity;
import hcmute.edu.vn.id18110304.databinding.ActivityIntroBinding;

/**
 * IntroActivity
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class IntroActivity extends AppCompatActivity implements IGenericActivity {

   private ActivityIntroBinding binding;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

      binding = ActivityIntroBinding.inflate(getLayoutInflater());
      View view = binding.getRoot();
      setContentView(view);

      initialVariables();
      setViewListeners();
   }

   @Override
   public void initialVariables() {

   }

   @Override
   public void setViewListeners() {

   }
}