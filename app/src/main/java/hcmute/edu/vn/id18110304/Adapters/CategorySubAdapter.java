package hcmute.edu.vn.id18110304.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import hcmute.edu.vn.id18110304.Communications.Domains.CategoryDomain;
import hcmute.edu.vn.id18110304.databinding.ItemCategorySubBinding;

/**
 * SubCategoryAdapter
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class CategorySubAdapter
      extends GenericAdapter<CategorySubAdapter.CategorySubItemViewHolder, CategoryDomain> {

   public static final String TAG = CategorySubAdapter.class.getSimpleName();

   public CategorySubAdapter(Context c, List<CategoryDomain> list) {
      super(c, list);
   }

   @Override
   public @NotNull
   CategorySubAdapter.CategorySubItemViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
      ItemCategorySubBinding binding = ItemCategorySubBinding.inflate(
            LayoutInflater.from(parent.getContext()), parent, false
      );
      return new CategorySubItemViewHolder(binding);
   }

   public static class CategorySubItemViewHolder
         extends GenericViewHolder<ItemCategorySubBinding, CategoryDomain> {

      public CategorySubItemViewHolder(ItemCategorySubBinding binding) {
         super(binding);
      }

      @Override
      public void updateView(CategoryDomain category) {
         bd.tvSubCategoryName.setText(category.getName());

         bd.ivSubcategoryImage.setVisibility(View.GONE);
         bd.lottieLoading.setVisibility(View.VISIBLE);
         bd.lottieError.setVisibility(View.GONE);

         Picasso.get().load(category.getImage()).into(bd.ivSubcategoryImage, new Callback() {
            @Override
            public void onSuccess() {
               bd.ivSubcategoryImage.setVisibility(View.VISIBLE);
               bd.lottieLoading.setVisibility(View.GONE);
               bd.lottieError.setVisibility(View.GONE);
            }

            @Override
            public void onError(Exception e) {
               bd.ivSubcategoryImage.setVisibility(View.GONE);
               bd.lottieLoading.setVisibility(View.GONE);
               bd.lottieError.setVisibility(View.VISIBLE);

               Log.e(TAG, "Picasso load image failed: " + e.getMessage());
            }
         });
      }
   }
}
