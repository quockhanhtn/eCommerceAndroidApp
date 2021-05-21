package hcmute.edu.vn.id18110304.Activities;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import hcmute.edu.vn.id18110304.Cons;
import hcmute.edu.vn.id18110304.Interfaces.IGenericActivity;
import hcmute.edu.vn.id18110304.R;
import hcmute.edu.vn.id18110304.Utils.DialogUtils;
import hcmute.edu.vn.id18110304.databinding.ActivityVerifyOtpBinding;

public class VerifyOtpActivity extends AppCompatActivity implements IGenericActivity {

   public static final String TAG = VerifyOtpActivity.class.getSimpleName();

   ActivityVerifyOtpBinding binding;
   EditText[] listEditedTextInputCodes;
   String verificationId;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      binding = ActivityVerifyOtpBinding.inflate(getLayoutInflater());
      View view = binding.getRoot();
      setContentView(view);

      initialVariables();
      setupOtpInputsFlows();
      setViewListeners();
   }

   @Override
   public void initialVariables() {
      binding.textviewInputPhone.setText(getIntent().getStringExtra(Cons.OTP_PHONE_NUMBER_KEY));
      verificationId = getIntent().getStringExtra(Cons.OTP_VERIFICATION_ID_KEY);
      listEditedTextInputCodes = new EditText[]{
            binding.edittextOtpCode1,
            binding.edittextOtpCode2,
            binding.edittextOtpCode3,
            binding.edittextOtpCode4,
            binding.edittextOtpCode5,
            binding.edittextOtpCode6
      };
   }

   @Override
   public void setViewListeners() {
      binding.buttonVerifyOtp.setOnClickListener(v -> {
         String code = getUserInputOtp();

         if (code.length() != 6) {
            DialogUtils.showErrorDialog(
                  getString(R.string.txt_invalid_otp),
                  getString(R.string.txt_please_enter_valid_otp_sent_to_your_phone),
                  VerifyOtpActivity.this);
            return;
         }

         if (verificationId != null) {
            binding.progressbarVerifyOtp.setVisibility(View.VISIBLE);
            binding.buttonVerifyOtp.setVisibility(View.INVISIBLE);

            PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(verificationId, code);
            FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
                  .addOnCompleteListener(task -> {
                     binding.progressbarVerifyOtp.setVisibility(View.GONE);
                     binding.buttonVerifyOtp.setVisibility(View.VISIBLE);

                     if (task.isSuccessful()) {
                        finish();
                     } else {
                        DialogUtils.showErrorDialog(
                              getString(R.string.txt_invalid_otp),
                              getString(R.string.txt_please_enter_valid_otp_sent_to_your_phone),
                              VerifyOtpActivity.this);
                     }
                  });
         }
      });
   }

   private void setupOtpInputsFlows() {
      for (int i = 0; i < listEditedTextInputCodes.length; i++) {
         EditText prev = listEditedTextInputCodes[Math.max((i - 1), 0)];
         EditText current = listEditedTextInputCodes[i];
         EditText next = listEditedTextInputCodes[Math.min(i + 1, listEditedTextInputCodes.length - 1)];

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
      listEditedTextInputCodes[0].requestFocus();
   }

   private String getUserInputOtp() {
      String result = "";
      for (int i = 0; i < listEditedTextInputCodes.length; i++) {
         result += listEditedTextInputCodes[i].getText();
      }
      return result;
   }
}