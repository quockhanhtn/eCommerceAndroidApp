package hcmute.edu.vn.id18110304.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import hcmute.edu.vn.id18110304.Communications.Domains.CategoryDomain;
import hcmute.edu.vn.id18110304.databinding.ItemCategoryBinding;

/**
 * CategoryAdapter
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class CategoryAdapter
      extends GenericAdapter<CategoryAdapter.CategoryItemViewHolder, CategoryDomain> {

   public static final String TAG = CategoryAdapter.class.getSimpleName();

   public CategoryAdapter(Context c, List<CategoryDomain> list) {
      super(c, list);
   }

   @Override
   public CategoryItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      ItemCategoryBinding binding = ItemCategoryBinding.inflate(
            LayoutInflater.from(parent.getContext()), parent, false
      );
      return new CategoryItemViewHolder(binding);
   }

   public class CategoryItemViewHolder
         extends GenericViewHolder<ItemCategoryBinding, CategoryDomain> {

      public CategoryItemViewHolder(ItemCategoryBinding binding) {
         super(binding);
      }

      @Override
      public void updateView(CategoryDomain category) {
         bd.tvCategoryName.setText(category.getName());

         bd.ivCategoryImage.setVisibility(View.GONE);
         bd.lottieLoading.setVisibility(View.VISIBLE);
         bd.lottieError.setVisibility(View.GONE);

         // should add android:usesCleartextTraffic="true" to application tag in AndroidManifest.xml
         Picasso.get().load(category.getImage()).into(bd.ivCategoryImage, new Callback() {
            @Override
            public void onSuccess() {
               bd.ivCategoryImage.setVisibility(View.VISIBLE);
               bd.lottieLoading.setVisibility(View.GONE);
               bd.lottieError.setVisibility(View.GONE);
            }

            @Override
            public void onError(Exception e) {
               bd.ivCategoryImage.setVisibility(View.GONE);
               bd.lottieLoading.setVisibility(View.GONE);
               bd.lottieError.setVisibility(View.VISIBLE);

               Log.e(TAG, "Picasso load image failed: " + e.getMessage());
            }
         });
      }
   }
}