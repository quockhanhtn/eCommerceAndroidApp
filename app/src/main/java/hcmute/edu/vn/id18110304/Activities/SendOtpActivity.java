package hcmute.edu.vn.id18110304.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

import hcmute.edu.vn.id18110304.Cons;
import hcmute.edu.vn.id18110304.databinding.ActivitySendOtpBinding;

/**
 * SendOtpActivity
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class SendOtpActivity extends AppCompatActivity {

   public static final String TAG = SendOtpActivity.class.getSimpleName();
   ActivitySendOtpBinding binding;

   final PhoneAuthProvider.OnVerificationStateChangedCallbacks otpVerifyCallbacks =
         new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull @NotNull PhoneAuthCredential phoneAuthCredential) {
               binding.progressbarGetOtp.setVisibility(View.GONE);
               binding.buttonGetOtp.setVisibility(View.VISIBLE);
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
               binding.progressbarGetOtp.setVisibility(View.GONE);
               binding.buttonGetOtp.setVisibility(View.VISIBLE);

               Toast.makeText(SendOtpActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
               Log.e(TAG, e.getMessage());
            }

            @Override
            public void onCodeSent(@NonNull String verificationId,
                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
               binding.progressbarGetOtp.setVisibility(View.GONE);
               binding.buttonGetOtp.setVisibility(View.VISIBLE);

               Intent intent = new Intent(getApplicationContext(), VerifyOtpActivity.class);
               intent.putExtra(Cons.KEY_OTP_PHONE_NUMBER, binding.ccpPhoneNumber.getFormattedFullNumber());
               intent.putExtra(Cons.KEY_OTP_VERIFICATION_ID, verificationId);
               startActivity(intent);
               finish();
            }
         };
   FirebaseAuth firebaseAuth;
   PhoneAuthOptions phoneAuthOptions;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      binding = ActivitySendOtpBinding.inflate(getLayoutInflater());
      View view = binding.getRoot();
      setContentView(view);

      initialVariables();
      setViewListeners();
   }

   public void initialVariables() {
      firebaseAuth = FirebaseAuth.getInstance();
      firebaseAuth.setLanguageCode(Locale.getDefault().getLanguage());

      binding.ccpPhoneNumber.registerCarrierNumberEditText(binding.edittextPhoneNumber);
      binding.ccpPhoneNumber.isValidFullNumber();
   }

   public void setViewListeners() {
      binding.buttonGetOtp.setOnClickListener(v -> {
         if (binding.edittextPhoneNumber.getText().toString().trim().isEmpty()) {
            Toast.makeText(SendOtpActivity.this, "Enter Mobile", Toast.LENGTH_SHORT).show();
            return;
         }

         binding.edittextPhoneNumber.clearFocus();
         binding.progressbarGetOtp.setVisibility(View.VISIBLE);
         binding.buttonGetOtp.setVisibility(View.INVISIBLE);

         phoneAuthOptions = PhoneAuthOptions.newBuilder(firebaseAuth)
               .setPhoneNumber(binding.ccpPhoneNumber.getFullNumberWithPlus())   // Phone number to verify
               .setTimeout(60L, TimeUnit.SECONDS)                         // Timeout and unit
               .setActivity(this)                                                // Activity (for callback binding)
               .setCallbacks(otpVerifyCallbacks)                                         // OnVerificationStateChangedCallbacks
               .build();
         PhoneAuthProvider.verifyPhoneNumber(phoneAuthOptions);
      });
   }
}