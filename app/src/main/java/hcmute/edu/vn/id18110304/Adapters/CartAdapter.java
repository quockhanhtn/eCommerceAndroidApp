package hcmute.edu.vn.id18110304.Adapters;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import hcmute.edu.vn.id18110304.Activities.ViewProductActivity;
import hcmute.edu.vn.id18110304.Communications.Domains.CartEntity;
import hcmute.edu.vn.id18110304.Communications.Domains.ProductDomain;
import hcmute.edu.vn.id18110304.Cons;
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
   ICartAdapterListener iCartAdapterListener;

   public CartAdapter(Context c, List<CartEntity> list, ICartAdapterListener listener) {
      super(c, list);
      iCartAdapterListener = listener;
   }

   @Override
   public CartItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      ItemCartBinding binding = ItemCartBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
      return new CartItemViewHolder(binding, iCartAdapterListener);
   }

   public interface ICartAdapterListener {
      void changeQuantity(ProductDomain product, String productType, int quantity);

      void increaseQuantity(ProductDomain product, String productType);

      void decreaseQuantity(ProductDomain product, String productType);
   }

   public class CartItemViewHolder extends GenericViewHolder<ItemCartBinding, CartEntity> {

      ICartAdapterListener adapterListener;

      public CartItemViewHolder(ItemCartBinding binding, ICartAdapterListener listener) {
         super(binding);
         adapterListener = listener;
      }

      public View getSwipeLayout() {
         return bd.layoutSwipe;
      }

      public View getMainLayout() {
         return bd.layoutMain;
      }

      public void hiddenMainLayout() {
         bd.layoutMain.setVisibility(View.GONE);
      }

      public void showMainLayout() {
         bd.layoutMain.setVisibility(View.VISIBLE);
      }

      @Override
      public void updateView(CartEntity cart) {
         ProductDomain product = cart.getProduct();
         String productType = cart.getProductType();

         Picasso.get().load(product.getThumbnail()).into(bd.ivProductThumbnail);

         bd.tvProductName.setText(product.getName());
         bd.tvProductPrice.setText(product.getPriceFormat());
         TextViewUtils.setHtml(bd.tvProductMarketPrice, product.getMarketPriceFormat());
         bd.tvProductDiscountPercent.setText(product.getDiscountPercent());

         if (productType == null || productType.isEmpty()) {
            bd.tvProductType.setVisibility(View.GONE);
         } else {
            bd.tvProductType.setVisibility(View.VISIBLE);
            bd.tvProductType.setText(productType);
         }

         bd.etQuantity.setText(String.valueOf(cart.getQuantity()));

         setListener(product, productType);
      }

      void setListener(ProductDomain product, String productType) {
         bd.tvProductName.setOnClickListener(v -> {
            Intent intent = new Intent(context, ViewProductActivity.class);
            intent.putExtra(Cons.KEY_SELECT_PRODUCT, product);
            context.startActivity(intent);
         });
         bd.btnAdd.setOnClickListener(v -> adapterListener.increaseQuantity(product, productType));
         bd.btnSubtract.setOnClickListener(v -> adapterListener.decreaseQuantity(product, productType));

         bd.etQuantity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
         });
      }
   }
}