package hcmute.edu.vn.id18110304.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import hcmute.edu.vn.id18110304.Adapters.CartAdapter;
import hcmute.edu.vn.id18110304.Communications.Domains.CartEntity;
import hcmute.edu.vn.id18110304.Communications.Domains.ProductDomain;
import hcmute.edu.vn.id18110304.R;
import hcmute.edu.vn.id18110304.Utils.DialogUtils;
import hcmute.edu.vn.id18110304.Utils.FormatUtils;
import hcmute.edu.vn.id18110304.Utils.LayoutManagerUtils;
import hcmute.edu.vn.id18110304.Utils.TextViewUtils;
import hcmute.edu.vn.id18110304.databinding.FragmentCartBinding;

/**
 * CartFragment
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class CartFragment extends Fragment
      implements CartAdapter.ICartAdapterListener {

   public static final String TAG = CartFragment.class.getSimpleName();
   private FragmentCartBinding binding;

   private List<CartEntity> listCarts = new ArrayList<>();
   CartAdapter cartAdapter = null;

   public CartFragment() {
      // Required empty public constructor
   }

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      binding = FragmentCartBinding.inflate(inflater, container, false);

      cartAdapter = new CartAdapter(getContext(), listCarts, this);
      binding.recyclerviewCart.setLayoutManager(LayoutManagerUtils.getVertical(getContext(), 1));
      binding.recyclerviewCart.setHasFixedSize(false);
      binding.recyclerviewCart.setAdapter(cartAdapter);

      binding.btnCheckOut.setOnClickListener(v -> {
         listCarts.clear();
         updateView();
         DialogUtils.showSuccessDialog(
               getString(R.string.txt_payment_successful),
               getString(R.string.txt_payment_successful_desc),
               getActivity()
         );
      });

      return binding.getRoot();
   }

   CartEntity findCartItem(ProductDomain product, String productType) {
      for (int i = 0; i < listCarts.size(); i++) {
         if (listCarts.get(i).getProduct().getProductId() == product.getProductId()
               && listCarts.get(i).getProductType().equals(productType)) {
            return listCarts.get(i);
         }
      }
      return null;
   }

   public int addToCart(ProductDomain product, String productType, int quantity) {
      CartEntity cart = findCartItem(product, productType);

      if (cart != null) {
         cart.addQuantity(quantity);
      } else {
         cart = new CartEntity(product, productType, quantity);
         listCarts.add(cart);
      }

      return listCarts.size();
   }

   public void updateView() {
      cartAdapter.setListItems(listCarts);

      if (listCarts.size() > 0) {
         binding.lottieLoading.setVisibility(View.GONE);
         binding.layoutEmptyCart.setVisibility(View.GONE);
         binding.layoutCheckOut.setVisibility(View.VISIBLE);
         updateTotal();
      } else {
         binding.lottieLoading.setVisibility(View.GONE);
         binding.layoutEmptyCart.setVisibility(View.VISIBLE);
         binding.layoutCheckOut.setVisibility(View.GONE);
      }
   }

   void updateTotal() {
      long total = 0, totalOrigin = 0;

      for (CartEntity cart : listCarts) {
         total += cart.getProduct().getPrice() * cart.getQuantity();
         totalOrigin += cart.getProduct().getMarketPrice() * cart.getQuantity();
      }

      binding.tvTotal.setText(FormatUtils.formatPrice(total));
      TextViewUtils.setHtml(binding.tvTotalOrigin, FormatUtils.formatPriceWithTag(totalOrigin, "del"));
   }

   @Override
   public void changeQuantity(ProductDomain product, String productType, int quantity) {
      CartEntity cart = findCartItem(product, productType);
      if (cart != null) {
         cart.setQuantity(quantity);
      }
      updateView();
   }

   @Override
   public void increaseQuantity(ProductDomain product, String productType) {
      addToCart(product, productType, 1);
      updateView();
   }

   @Override
   public void decreaseQuantity(ProductDomain product, String productType) {
      addToCart(product, productType, -1);
      updateView();
   }

   @Override
   public void removeItem(ProductDomain product, String productType) {
      listCarts.remove(findCartItem(product, productType));
      updateView();
   }
}