package hcmute.edu.vn.id18110304.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import hcmute.edu.vn.id18110304.BottomSheets.ProductBottomSheet;
import hcmute.edu.vn.id18110304.Communications.Domains.ProductDomain;
import hcmute.edu.vn.id18110304.R;
import hcmute.edu.vn.id18110304.databinding.ItemProductBinding;

/**
 * ProductAdapter
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class ProductAdapter extends GenericAdapter<ProductAdapter.ProductItemViewHolder, ProductDomain> {

   public static final String TAG = ProductAdapter.class.getSimpleName();

   public ProductAdapter(Context c, List<ProductDomain> list) {
      super(c, list);
   }

   @Override
   public ProductAdapter.ProductItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      ItemProductBinding binding = ItemProductBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
      return new ProductItemViewHolder(binding);
   }

   public static class ProductItemViewHolder extends GenericViewHolder<ItemProductBinding, ProductDomain> {

      public ProductItemViewHolder(ItemProductBinding binding) {
         super(binding);
      }

      @Override
      public void updateView(ProductDomain product) {
         bd.layoutItemProduct.setOnClickListener(v -> ProductBottomSheet.show(v.getContext(), product));

         bd.tvProductName.setText(product.getName());
         bd.tvProductPrice.setText(product.getPriceFormat());
         bd.tvDiscountPercent.setText(product.getDiscountPercent());

         bd.ivProductThumbnail.setVisibility(View.GONE);
         bd.lottieLoading.setVisibility(View.VISIBLE);
         bd.lottieError.setVisibility(View.GONE);

         Picasso.get().load(product.getThumbnail()).into(bd.ivProductThumbnail, new Callback() {
            @Override
            public void onSuccess() {
               bd.ivProductThumbnail.setVisibility(View.VISIBLE);
               bd.lottieLoading.setVisibility(View.GONE);
               bd.lottieError.setVisibility(View.GONE);
            }

            @Override
            public void onError(Exception e) {
               bd.ivProductThumbnail.setVisibility(View.GONE);
               bd.lottieLoading.setVisibility(View.GONE);
               bd.lottieError.setVisibility(View.VISIBLE);

               Log.e(TAG, "Picasso load image failed: " + e.getMessage());
            }
         });
      }
   }
}
