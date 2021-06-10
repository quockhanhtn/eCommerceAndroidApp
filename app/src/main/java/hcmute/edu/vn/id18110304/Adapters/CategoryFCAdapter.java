package hcmute.edu.vn.id18110304.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.ramotion.foldingcell.FoldingCell;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import hcmute.edu.vn.id18110304.Communications.Domains.CategoryDomain;
import hcmute.edu.vn.id18110304.R;
import hcmute.edu.vn.id18110304.Utils.LayoutManagerUtils;

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
   public @NotNull
   CategoryFCAdapter.CategoryItemFCViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View itemView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_category_foldingcell, parent, false);
      return new CategoryItemFCViewHolder(itemView);
   }

   @Override
   public void onBindViewHolder(CategoryItemFCViewHolder holder, int position) {
      CategoryDomain category = getListItems().get(position);

      holder.loadImage(category.getImage());
      holder.tvCategoryName.setText(category.getName());
      holder.tvCategoryNameHide.setText(category.getName());

      if (category.getChildren() != null) {
         holder.tvCategoryDesc.setText(String.valueOf(category.getChildren().size()));
         holder.tvCategoryDescHide.setText(String.valueOf(category.getChildren().size()));

         holder.adapter.setListItems(category.getChildren());
      }
      holder.foldingCell.setOnClickListener(v -> holder.foldingCell.toggle(false));

      if (category.getChildren().size() > 0) {
         holder.loading.setVisibility(View.GONE);
      }

      if (category.getChildren().size() < 2) {
         holder.rvSubcategory.setMinimumHeight(160);
      }

   }

   public static class CategoryItemFCViewHolder extends RecyclerView.ViewHolder {

      private ImageView ivCategoryImage;
      LottieAnimationView lottieLoading;
      LottieAnimationView lottieError;

      private TextView tvCategoryName;
      private TextView tvCategoryDesc;
      private TextView tvCategoryNameHide;
      private TextView tvCategoryDescHide;
      private RecyclerView rvSubcategory;

      private com.airbnb.lottie.LottieAnimationView loading;

      private CategorySubAdapter adapter;

      private FoldingCell foldingCell;

      public CategoryItemFCViewHolder(View itemView) {
         super(itemView);

         ivCategoryImage = itemView.findViewById(R.id.item_category_fd_imageview);
         lottieLoading = itemView.findViewById(R.id.item_category_fd_loading);
         lottieError = itemView.findViewById(R.id.item_category_fd_error);

         tvCategoryName = itemView.findViewById(R.id.item_category_fd_textview_name);
         tvCategoryNameHide = itemView.findViewById(R.id.item_category_fd_textview_name_hide);

         tvCategoryDesc = itemView.findViewById(R.id.item_category_fd_textview_desc);
         tvCategoryDescHide = itemView.findViewById(R.id.item_category_fd_textview_desc_hide);

         foldingCell = itemView.findViewById(R.id.item_category_fd_folding_cell);
         rvSubcategory = itemView.findViewById(R.id.item_category_fd_recyclerview_subcategory);

         loading = itemView.findViewById(R.id.item_category_fd_lottie_loading);

         adapter = new CategorySubAdapter(itemView.getContext(), null);
         rvSubcategory.setLayoutManager(LayoutManagerUtils.getVertical(itemView.getContext(), 1));
         rvSubcategory.setHasFixedSize(false);
         rvSubcategory.setAdapter(adapter);
      }

      void loadImage(String imageUrl) {
         ivCategoryImage.setVisibility(View.GONE);
         lottieLoading.setVisibility(View.VISIBLE);
         lottieError.setVisibility(View.GONE);

         // should add android:usesCleartextTraffic="true" to application tag in AndroidManifest.xml
         Picasso.get().load(imageUrl).into(ivCategoryImage, new Callback() {
            @Override
            public void onSuccess() {
               ivCategoryImage.setVisibility(View.VISIBLE);
               lottieLoading.setVisibility(View.GONE);
               lottieError.setVisibility(View.GONE);
            }

            @Override
            public void onError(Exception e) {
               ivCategoryImage.setVisibility(View.GONE);
               lottieLoading.setVisibility(View.GONE);
               lottieError.setVisibility(View.VISIBLE);

               Log.e(TAG, "Picasso load image failed: " + e.getMessage());
            }
         });
      }
   }
}