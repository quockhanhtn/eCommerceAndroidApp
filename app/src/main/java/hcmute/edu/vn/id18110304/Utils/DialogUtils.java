package hcmute.edu.vn.id18110304.Utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import org.jetbrains.annotations.NotNull;

import hcmute.edu.vn.id18110304.R;

/**
 * DialogUtils
 *
 * @author  Khanh Lam
 * @version 1.0
 */
public class DialogUtils {

   enum DialogType {SUCCESS, WARNING, ERROR}

   public static void showSuccessDialog(String title, String message, @NotNull Activity activity) {
      showSuccessDialog(title, message, activity, v -> {
      });
   }

   public static void showSuccessDialog(String title, String message, @NotNull Activity activity, View.OnClickListener btnOkOnClick) {
      showDialog(DialogType.SUCCESS, title, message, activity, btnOkOnClick, null, null);
   }

   public static void showWarningDialog(String title, String message, @NotNull Activity activity,
                                        Object btnYesOnClick, Object btnNoOnClick) {
      showDialog(DialogType.WARNING, title, message, activity, null, btnYesOnClick, btnNoOnClick);
   }

   public static void showErrorDialog(String title, String message, @NotNull Activity activity) {
      showErrorDialog(title, message, activity, v -> {
      });
   }

   public static void showErrorDialog(String title, String message, @NotNull Activity activity, View.OnClickListener btnOkOnClick) {
      showDialog(DialogType.ERROR, title, message, activity, btnOkOnClick, null, null);
   }


   public static void showDialog(@NotNull DialogType type, String title, String message,
                                 @NotNull Activity activity,
                                 Object btnOkOnClick,
                                 Object btnYesOnClick,
                                 Object btnNoOnClick) {

      AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.AlertDialogTheme);

      View dialogView = LayoutInflater.from(activity.getApplicationContext()).inflate(
            R.layout.layout_dialog,
            activity.findViewById(R.id.layout_dialog_container)
      );
      builder.setView(dialogView);

      TextView tvTitle = dialogView.findViewById(R.id.textview_dialog_title);
      ImageView ivIcon = dialogView.findViewById(R.id.imageview_dialog_icon);
      TextView tvMessage = dialogView.findViewById(R.id.textview_dialog_message);
      Button btnOk = dialogView.findViewById(R.id.button_dialog_ok);
      Button btnYes = dialogView.findViewById(R.id.button_dialog_yes);
      Button btnNo = dialogView.findViewById(R.id.button_dialog_no);

      tvTitle.setText(title);
      tvMessage.setText(message);

      switch (type) {
         case SUCCESS:
            tvTitle.setBackground(ContextCompat.getDrawable(activity, R.drawable.bg_dialog_title_success));
            ivIcon.setImageResource(R.drawable.ic_success);
            btnOk.setVisibility(View.VISIBLE);
            btnOk.setBackground(ContextCompat.getDrawable(activity, R.drawable.bg_button_success));
            btnYes.setVisibility(View.GONE);
            btnNo.setVisibility(View.GONE);
            break;
         case WARNING:
            tvTitle.setBackground(ContextCompat.getDrawable(activity, R.drawable.bg_dialog_title_warning));
            ivIcon.setImageResource(R.drawable.ic_warning);
            btnOk.setVisibility(View.GONE);
            btnNo.setVisibility(View.VISIBLE);
            btnYes.setVisibility(View.VISIBLE);
            btnYes.setBackground(ContextCompat.getDrawable(activity, R.drawable.bg_button_warning));
            break;

         case ERROR:
            tvTitle.setBackground(ContextCompat.getDrawable(activity, R.drawable.bg_dialog_title_error));
            ivIcon.setImageResource(R.drawable.ic_error);
            btnOk.setVisibility(View.VISIBLE);
            btnOk.setBackground(ContextCompat.getDrawable(activity, R.drawable.bg_button_error));
            btnYes.setVisibility(View.GONE);
            btnNo.setVisibility(View.GONE);
            break;
         default:
            return;
      }


      final AlertDialog alertDialog = builder.create();

      btnOk.setOnClickListener(v -> {
         alertDialog.dismiss();
         if (btnOkOnClick instanceof View.OnClickListener) {
            ((View.OnClickListener) btnOkOnClick).onClick(v);
         }
      });

      btnYes.setOnClickListener(v -> {
         alertDialog.dismiss();
         if (btnYesOnClick instanceof View.OnClickListener) {
            ((View.OnClickListener) btnYesOnClick).onClick(v);
         }
      });

      btnNo.setOnClickListener(v -> {
         alertDialog.dismiss();
         if (btnNoOnClick instanceof View.OnClickListener) {
            ((View.OnClickListener) btnNoOnClick).onClick(v);
         }
      });

      if (alertDialog.getWindow() != null) {
         alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      }
      alertDialog.show();
   }
}
