package hcmute.edu.vn.id18110304.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import hcmute.edu.vn.id18110304.Communications.Domains.BrandDomain;
import hcmute.edu.vn.id18110304.databinding.ItemBrandBinding;

/**
 * BrandAdapter
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class BrandAdapter extends GenericAdapter<BrandAdapter.BrandItemViewHolder, BrandDomain> {

   public static final String TAG = BrandAdapter.class.getSimpleName();

   public BrandAdapter(Context c, List<BrandDomain> list) {
      super(c, list);
   }

   @Override
   public BrandAdapter.BrandItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      ItemBrandBinding binding = ItemBrandBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
      return new BrandItemViewHolder(binding);
   }

   public static class BrandItemViewHolder extends GenericViewHolder<ItemBrandBinding, BrandDomain> {

      public BrandItemViewHolder(ItemBrandBinding binding) {
         super(binding);
      }

      @Override
      public void updateView(BrandDomain brand) {
         bd.tvBrandName.setText(brand.getName());

         bd.ivBrandImage.setVisibility(View.GONE);
         bd.lottieLoading.setVisibility(View.VISIBLE);
         bd.lottieError.setVisibility(View.GONE);

         // should add android:usesCleartextTraffic="true" to application tag in AndroidManifest.xml
         Picasso.get().load(brand.getImage()).into(bd.ivBrandImage, new Callback() {
            @Override
            public void onSuccess() {
               bd.ivBrandImage.setVisibility(View.VISIBLE);
               bd.lottieLoading.setVisibility(View.GONE);
               bd.lottieError.setVisibility(View.GONE);
            }

            @Override
            public void onError(Exception e) {
               bd.ivBrandImage.setVisibility(View.GONE);
               bd.lottieLoading.setVisibility(View.GONE);
               bd.lottieError.setVisibility(View.VISIBLE);

               Log.e(TAG, "Picasso load image failed: " + e.getMessage());
            }
         });
      }
   }
}