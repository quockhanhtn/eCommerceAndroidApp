package hcmute.edu.vn.id18110304.CustomViews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CompoundButton;

import androidx.appcompat.widget.AppCompatRadioButton;

/**
 * MyRadioButton
 *
 * @author Khanh Lam
 * @version 1.0
 * @see {https://jonathandelasen.com/how-to-create-custom-radio-button.html}
 */
public class MyRadioButton extends AppCompatRadioButton {

   private CompoundButton.OnCheckedChangeListener onCheckedChangeListener;

   public MyRadioButton(Context context) {
      super(context);
   }

   public MyRadioButton(Context context, AttributeSet attrs) {
      super(context, attrs);
   }

   public MyRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
      super(context, attrs, defStyleAttr);
   }

   @Override
   protected void onAttachedToWindow() {
      super.onAttachedToWindow();

      setOwnOnCheckedChangeListener();
      setButtonDrawable(null);//lets remove the default drawable to create our own

   }

   public void setOwnOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
      this.onCheckedChangeListener = onCheckedChangeListener;
   }

   private void setOwnOnCheckedChangeListener() {
      setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
         @Override
         public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (onCheckedChangeListener != null) {
               //this is called when we have set our listener
               onCheckedChangeListener.onCheckedChanged(buttonView, isChecked);
            }
         }
      });
   }
}