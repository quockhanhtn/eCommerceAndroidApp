package hcmute.edu.vn.id18110304.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import hcmute.edu.vn.id18110304.Communications.Domains.CategoryDomain;
import hcmute.edu.vn.id18110304.R;
import hcmute.edu.vn.id18110304.Utils.LayoutManagerUtils;
import hcmute.edu.vn.id18110304.databinding.ItemCategoryFoldingcellBinding;

/**
 * @author Khanh Lam
 * @version 1.0
 */
public class CategoryFCAdapter extends GenericAdapter<CategoryFCAdapter.CategoryItemFCViewHolder, CategoryDomain> {

   public static final String TAG = CategoryFCAdapter.class.getSimpleName();

   public CategoryFCAdapter(Context c, List<CategoryDomain> list) {
      super(c, list);
   }

   @Override
   public CategoryFCAdapter.CategoryItemFCViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      ItemCategoryFoldingcellBinding binding = ItemCategoryFoldingcellBinding.inflate(
            LayoutInflater.from(parent.getContext()), parent, false
      );
      return new CategoryItemFCViewHolder(binding);
   }

   public class CategoryItemFCViewHolder
         extends GenericViewHolder<ItemCategoryFoldingcellBinding, CategoryDomain> {

      private final CategorySubAdapter adapter;

      public CategoryItemFCViewHolder(ItemCategoryFoldingcellBinding binding) {
         super(binding);

         adapter = new CategorySubAdapter(itemView.getContext(), null);
         bd.rvSubcategory.setLayoutManager(LayoutManagerUtils.getVertical(itemView.getContext(), 1));
         bd.rvSubcategory.setHasFixedSize(false);
         bd.rvSubcategory.setAdapter(adapter);
      }

      @SuppressLint("SetTextI18n")
      @Override
      public void updateView(CategoryDomain category) {
         bd.foldingCell.setOnClickListener(v -> bd.foldingCell.toggle(false));

         bd.tvCategoryName.setText(category.getName());
         bd.tvCategoryNameHide.setText(category.getName());

         if (category.getChildren() != null) {
            bd.tvCategoryDesc.setText(category.getChildren().size() + " " + getResourceString(R.string.txt_sub_categories));
            bd.tvCategoryDescHide.setText(String.valueOf(category.getChildren().size()));

            adapter.setListItems(category.getChildren());

            if (category.getChildren().size() > 0) {
               bd.lottieLoadingSub.setVisibility(View.GONE);
            }

            if (category.getChildren().size() < 2) {
               bd.rvSubcategory.setMinimumHeight(160);
            }
         }

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