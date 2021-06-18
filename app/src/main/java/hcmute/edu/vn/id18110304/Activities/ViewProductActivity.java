package hcmute.edu.vn.id18110304.Activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import hcmute.edu.vn.id18110304.Interfaces.IGenericActivity;
import hcmute.edu.vn.id18110304.databinding.ActivityViewProductBinding;

/**
 * ViewProductActivity
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class ViewProductActivity extends AppCompatActivity implements IGenericActivity {

   public static final String TAG = ViewProductActivity.class.getSimpleName();
   private ActivityViewProductBinding binding;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      binding = ActivityViewProductBinding.inflate(getLayoutInflater());
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