package hcmute.edu.vn.id18110304.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import hcmute.edu.vn.id18110304.Communications.Domains.CategoryDomain;
import hcmute.edu.vn.id18110304.R;

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
   public @NotNull CategoryItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View itemView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_category, parent, false);
      return new CategoryItemViewHolder(itemView);
   }

   @Override
   public void onBindViewHolder(CategoryAdapter.CategoryItemViewHolder holder, int position) {
      CategoryDomain category = getListItems().get(position);

      holder.tvCategoryName.setText(category.getName());
      holder.loadImage(category.getImage());
   }

   public static class CategoryItemViewHolder extends RecyclerView.ViewHolder {
      private TextView tvCategoryName;
      private RoundedImageView ivCategoryImage;
      LottieAnimationView lottieLoading;
      LottieAnimationView lottieError;

      public CategoryItemViewHolder(View itemView) {
         super(itemView);
         tvCategoryName = itemView.findViewById(R.id.item_category_fd_textview_name);
         ivCategoryImage = itemView.findViewById(R.id.item_category_fd_imageview);
         lottieLoading = itemView.findViewById(R.id.item_category_loading);
         lottieError = itemView.findViewById(R.id.item_category_error);
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