package hcmute.edu.vn.id18110304.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import hcmute.edu.vn.id18110304.BottomSheets.ProductBottomSheet;
import hcmute.edu.vn.id18110304.Communications.Domains.ProductDomain;
import hcmute.edu.vn.id18110304.databinding.ItemProductBinding;

/**
 * ProductAdapter
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class ProductAdapter extends GenericAdapter<ProductAdapter.ProductItemViewHolder, ProductDomain> {

   public static final String TAG = ProductAdapter.class.getSimpleName();
   private final IProductAdapterListener iProductAdapterListener;
   public ProductAdapter(Context c, List<ProductDomain> list, IProductAdapterListener listener) {
      super(c, list);
      iProductAdapterListener = listener;
   }

   @Override
   public ProductAdapter.ProductItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      ItemProductBinding binding = ItemProductBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
      return new ProductItemViewHolder(binding, iProductAdapterListener);
   }

   public interface IProductAdapterListener {
      void addToFavorite(ProductDomain product, String productType, int quantity);

      void addToCart(ProductDomain product, String productType, int quantity);

      void buyNow(ProductDomain product, String productType, int quantity);
   }

   public static class ProductItemViewHolder extends GenericViewHolder<ItemProductBinding, ProductDomain> {

      private final IProductAdapterListener adapterListener;

      public ProductItemViewHolder(ItemProductBinding binding, IProductAdapterListener listener) {
         super(binding);
         adapterListener = listener;
      }

      @Override
      public void updateView(ProductDomain product) {
         bd.layoutItemProduct.setOnClickListener(v -> showProductBottomSheet(v, product));

         bd.tvProductName.setText(product.getName());
         bd.tvProductPrice.setText(product.getPriceFormat());
         bd.tvDiscountPercent.setText(product.getDiscountPercent());

         bd.ivProductThumbnail.setVisibility(View.GONE);
         bd.lottieLoading.setVisibility(View.VISIBLE);
         bd.lottieError.setVisibility(View.GONE);

         Picasso.get().load(product.getThumbnail()).into(bd.ivProductThumbnail, new Callback() {
            @Override
            public void onSuccess() {
               bd.ivProductThumbnail.setVisibility(View.VISIBLE);
               bd.lottieLoading.setVisibility(View.GONE);
               bd.lottieError.setVisibility(View.GONE);
            }

            @Override
            public void onError(Exception e) {
               bd.ivProductThumbnail.setVisibility(View.GONE);
               bd.lottieLoading.setVisibility(View.GONE);
               bd.lottieError.setVisibility(View.VISIBLE);

               Log.e(TAG, "Picasso load image failed: " + e.getMessage());
            }
         });
      }

      void showProductBottomSheet(View v, ProductDomain product) {
         ProductBottomSheet.show(v.getContext(), product, new ProductBottomSheet.IProductBottomSheetListener() {
            @Override
            public void addToFavorite(ProductDomain product, String productType, int quantity) {
               adapterListener.addToFavorite(product, productType, quantity);
            }

            @Override
            public void addToCart(ProductDomain product, String productType, int quantity) {
               adapterListener.addToCart(product, productType, quantity);
            }

            @Override
            public void buyNow(ProductDomain product, String productType, int quantity) {
               adapterListener.addToCart(product, productType, quantity);
            }
         });
      }
   }
}
