package hcmute.edu.vn.id18110304.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.nio.ReadOnlyBufferException;
import java.util.List;

import hcmute.edu.vn.id18110304.Communications.Domains.CategoryDomain;
import hcmute.edu.vn.id18110304.R;

/**
 * SubCategoryAdapter
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class CategorySubAdapter
      extends GenericAdapter<CategorySubAdapter.CategorySubItemViewHolder, CategoryDomain> {

   public CategorySubAdapter(Context c, List<CategoryDomain> list) {
      super(c, list);
   }

   @Override
   public @NotNull
   CategorySubAdapter.CategorySubItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View itemView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_category_sub, parent, false);
      return new CategorySubItemViewHolder(itemView);
   }

   @Override
   public void onBindViewHolder(CategorySubItemViewHolder holder, int position) {
      CategoryDomain category = getListItems().get(position);
      Picasso.get().load(category.getImage()).into(holder.ivCategoryImage);
      holder.tvCategoryName.setText(category.getName());
   }

   public static class CategorySubItemViewHolder extends RecyclerView.ViewHolder {
      private TextView tvCategoryName;
      private ImageView ivCategoryImage;

      public CategorySubItemViewHolder(View itemView) {
         super(itemView);
         tvCategoryName = itemView.findViewById(R.id.textview_subcategory_item_name);
         ivCategoryImage = itemView.findViewById(R.id.imageview_subcategory_item_image);
      }
   }
}
