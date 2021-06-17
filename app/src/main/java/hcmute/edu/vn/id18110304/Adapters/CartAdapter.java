package hcmute.edu.vn.id18110304.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import hcmute.edu.vn.id18110304.Communications.Domains.CartEntity;
import hcmute.edu.vn.id18110304.Utils.TextViewUtils;
import hcmute.edu.vn.id18110304.databinding.ItemCartBinding;

/**
 * CartAdapter
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class CartAdapter extends GenericAdapter<CartAdapter.CartItemViewHolder, CartEntity> {

   public static final String TAG = CartAdapter.class.getSimpleName();

   public CartAdapter(Context c, List<CartEntity> list) {
      super(c, list);
   }

   @Override
   public CartItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      ItemCartBinding binding = ItemCartBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
      return new CartItemViewHolder(binding);
   }

   public static class CartItemViewHolder extends GenericViewHolder<ItemCartBinding, CartEntity> {

      public CartItemViewHolder(ItemCartBinding binding) {
         super(binding);
      }

      @Override
      public void updateView(CartEntity cart) {
         Picasso.get().load(cart.getProduct().getThumbnail()).into(bd.ivProductThumbnail);

         bd.tvProductName.setText(cart.getProduct().getName());
         bd.tvProductPrice.setText(cart.getProduct().getPriceFormat());
         TextViewUtils.setHtml(bd.tvProductMarketPrice, cart.getProduct().getMarketPriceFormat());
         bd.tvProductDiscountPercent.setText(cart.getProduct().getDiscountPercent());

         if (cart.getProductType() == null || cart.getProductType().isEmpty()) {
            bd.tvProductType.setVisibility(View.GONE);
         } else {
            bd.tvProductType.setVisibility(View.VISIBLE);
            bd.tvProductType.setText(cart.getProductType());
         }

         bd.etQuantity.setText(String.valueOf(cart.getQuantity()));
      }
   }
}