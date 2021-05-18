package hcmute.edu.vn.id18110304.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

import hcmute.edu.vn.id18110304.Domains.CategoryDomain;
import hcmute.edu.vn.id18110304.R;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryItemViewHolder> {
   private List<CategoryDomain> categories;
   private Context context;

   public CategoryAdapter(List<CategoryDomain> categories, Context c) {
      this.categories = categories;
      this.context = c;
   }

   @Override
   public int getItemCount() {
      return categories.size();
   }

   @Override
   public CategoryItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View itemView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_category, parent, false);
      return new CategoryItemViewHolder(itemView);
   }

   @Override
   public void onBindViewHolder(CategoryAdapter.CategoryItemViewHolder holder, int position) {
      CategoryDomain category = categories.get(position);
      // should add android:usesCleartextTraffic="true" to application tag in AndroidManifest.xml
      Picasso.get().load(category.getImage()).into(holder.ivCategoryImage);
      holder.tvCategoryName.setText(category.getName());
   }

   public static class CategoryItemViewHolder extends RecyclerView.ViewHolder {
      public TextView tvCategoryName;
      public RoundedImageView ivCategoryImage;

      public CategoryItemViewHolder(View itemView) {
         super(itemView);
         tvCategoryName = itemView.findViewById(R.id.textview_category_item_name);
         ivCategoryImage = itemView.findViewById(R.id.imageview_category_item_image);
      }
   }
}