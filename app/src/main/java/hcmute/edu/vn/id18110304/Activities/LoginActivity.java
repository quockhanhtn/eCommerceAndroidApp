package hcmute.edu.vn.id18110304.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import hcmute.edu.vn.id18110304.Interfaces.IGenericActivity;
import hcmute.edu.vn.id18110304.R;

/**
 * LoginActivity
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class LoginActivity extends AppCompatActivity implements IGenericActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_log_in);
   }

   @Override
   public void initialVariables() {
   }

   @Override
   public void setViewListeners() {
   }
}