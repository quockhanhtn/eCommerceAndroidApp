package hcmute.edu.vn.id18110304.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import hcmute.edu.vn.id18110304.databinding.ActivitySendOtpBinding;

public class SendOtpActivity extends AppCompatActivity {

   public static final String TAG = SendOtpActivity.class.getSimpleName();
   ActivitySendOtpBinding binding;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      binding = ActivitySendOtpBinding.inflate(getLayoutInflater());
      View view = binding.getRoot();
      setContentView(view);

      binding.buttonGetOtp.setOnClickListener(v -> {
         if (binding.editextPhoneNumber.getText().toString().trim().isEmpty()) {
            Toast.makeText(SendOtpActivity.this, "Enter Mobile", Toast.LENGTH_SHORT).show();
            return;
         }

         Intent intent = new Intent(getApplicationContext(), VerifyOtpActivity.class);
         intent.putExtra("mobile", binding.editextPhoneNumber.getText().toString());
         startActivity(intent);
      });
   }
}