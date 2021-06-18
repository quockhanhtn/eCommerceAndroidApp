package hcmute.edu.vn.id18110304.Activities;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import hcmute.edu.vn.id18110304.Adapters.SliderImageAdapter;
import hcmute.edu.vn.id18110304.Communications.Domains.ProductDomain;
import hcmute.edu.vn.id18110304.Cons;
import hcmute.edu.vn.id18110304.CustomViews.MyRadioButton;
import hcmute.edu.vn.id18110304.R;
import hcmute.edu.vn.id18110304.Utils.StringUtils;
import hcmute.edu.vn.id18110304.Utils.TextViewUtils;
import hcmute.edu.vn.id18110304.databinding.ActivityViewProductBinding;
import io.noties.markwon.Markwon;

/**
 * ViewProductActivity
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class ViewProductActivity extends AppCompatActivity {

   public static final String TAG = ViewProductActivity.class.getSimpleName();
   private ActivityViewProductBinding binding;

   private ProductDomain product;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      binding = ActivityViewProductBinding.inflate(getLayoutInflater());
      View view = binding.getRoot();
      setContentView(view);

      initialVariables();
      setViewListeners();
   }

   public void initialVariables() {
      product = (ProductDomain) getIntent().getSerializableExtra(Cons.KEY_SELECT_PRODUCT);

      binding.etQuantity.setText("1");
      binding.btnSubtract.setEnabled(false);

      TextViewUtils.enableScrollableInScrollView(
            binding.tvProductDesc,
            binding.nestedScroll
      );

      SliderImageAdapter adapter = new SliderImageAdapter(this);
      adapter.addItem(product.getThumbnail());
      if (product.getImages() != null && product.getImages().size() > 0) {
         for (String imageUrl : product.getImages()) {
            adapter.addItem(imageUrl);
         }
      }

      binding.imageSlider.setSliderAdapter(adapter);

      binding.imageSlider.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
      binding.imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
      binding.imageSlider.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
      binding.imageSlider.setIndicatorSelectedColor(Color.WHITE);
      binding.imageSlider.setIndicatorUnselectedColor(Color.GRAY);
      binding.imageSlider.setScrollTimeInSec(5); //set scroll delay in seconds :
      binding.imageSlider.startAutoCycle();

      binding.tvProductName.setText(product.getName());
      binding.tvProductPrice.setText(product.getPriceFormat());
      TextViewUtils.setHtml(binding.tvProductMarketPrice, product.getMarketPriceFormat());
      TextViewUtils.setHtml(binding.tvProductCategory, product.getCategoryName());
      TextViewUtils.setHtml(binding.tvProductBrand, product.getBrandName());
      binding.tvProductDiscountPercent.setText(product.getDiscountPercent());

      boolean hasProductType = product.getProductTypes() != null && product.getProductTypes().size() > 0;
      if (hasProductType) {
         binding.layoutProductOption.setVisibility(View.VISIBLE);

         LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
               ViewGroup.LayoutParams.WRAP_CONTENT,
               100
         );
         layoutParams.setMarginEnd(10);

         for (int i = 0; i < product.getProductTypes().size(); i++) {

            MyRadioButton radioButton = (MyRadioButton) LayoutInflater.from(getApplicationContext())
                  .inflate(R.layout.item_radio, null);
            radioButton.setText(product.getProductTypes().get(i));
            radioButton.setId(i + 100);
            radioButton.setLayoutParams(layoutParams);
            radioButton.setChecked(i == 0);
            binding.radioGroup.addView(radioButton);
         }
      } else {
         binding.layoutProductOption.setVisibility(View.GONE);
      }

      final Markwon markwon = Markwon.create(getApplicationContext());

      // set markdown
      markwon.setMarkdown(binding.tvProductDesc, product.getDescription());
   }

   public void setViewListeners() {
      binding.btnBack.setOnClickListener(v -> this.finish());
      binding.btnAdd.setOnClickListener(v -> {
         int currentQuantity = StringUtils.toInt(binding.etQuantity.getText().toString());
         binding.etQuantity.setText(String.valueOf(currentQuantity + 1));
         if (currentQuantity > 1) {
            binding.btnSubtract.setEnabled(true);
         }
      });
      binding.btnSubtract.setOnClickListener(v -> {
         int currentQuantity = StringUtils.toInt(binding.etQuantity.getText().toString());
         binding.etQuantity.setText(String.valueOf(currentQuantity - 1));
         if (currentQuantity == 1) {
            binding.btnSubtract.setEnabled(false);
         }
      });
   }
}