package hcmute.edu.vn.id18110304.Activities;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import hcmute.edu.vn.id18110304.databinding.ActivityVerifyOtpBinding;

public class VerifyOtpActivity extends AppCompatActivity {

   public static final String TAG = VerifyOtpActivity.class.getSimpleName();
   ActivityVerifyOtpBinding binding;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      binding = ActivityVerifyOtpBinding.inflate(getLayoutInflater());
      View view = binding.getRoot();
      setContentView(view);

      binding.textviewInputPhone.setText(String.format(
            "+84-%s", getIntent().getStringExtra("mobile")
      ));

      setupOtpInputs(binding.edittextOtpCode1, binding.edittextOtpCode2);
      setupOtpInputs(binding.edittextOtpCode2, binding.edittextOtpCode3);
      setupOtpInputs(binding.edittextOtpCode3, binding.edittextOtpCode4);
      setupOtpInputs(binding.edittextOtpCode4, binding.edittextOtpCode5);
      setupOtpInputs(binding.edittextOtpCode5, binding.edittextOtpCode6);
   }

   private void setupOtpInputs(EditText current, EditText next) {
      current.addTextChangedListener(new TextWatcher() {
         @Override
         public void beforeTextChanged(CharSequence s, int start, int count, int after) {

         }

         @Override
         public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (!s.toString().trim().isEmpty()) {
               next.requestFocus();
            }
         }

         @Override
         public void afterTextChanged(Editable s) {

         }
      });
   }
}