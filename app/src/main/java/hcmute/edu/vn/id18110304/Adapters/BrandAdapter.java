package hcmute.edu.vn.id18110304.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import hcmute.edu.vn.id18110304.Communications.Domains.BrandDomain;
import hcmute.edu.vn.id18110304.R;

/**
 * BrandAdapter
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class BrandAdapter extends GenericAdapter<BrandAdapter.BrandItemViewHolder, BrandDomain> {

   public BrandAdapter(Context c, List<BrandDomain> list) {
      super(c, list);
   }

   @Override
   public @NotNull BrandAdapter.BrandItemViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
      View itemView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_brand, parent, false);
      return new BrandItemViewHolder(itemView);
   }

   @Override
   public void onBindViewHolder(@NonNull @NotNull BrandItemViewHolder holder, int position) {
      BrandDomain brand = getListItems().get(position);
      Picasso.get().load(brand.getImage()).into(holder.ivBrandImage);
      holder.tvBrandName.setText(brand.getName());
   }

   public static class BrandItemViewHolder extends RecyclerView.ViewHolder {
      public TextView tvBrandName;
      public RoundedImageView ivBrandImage;

      public BrandItemViewHolder(View itemView) {
         super(itemView);
         tvBrandName = itemView.findViewById(R.id.textview_brand_item_name);
         ivBrandImage = itemView.findViewById(R.id.imageview_brand_item_image);
      }
   }
}