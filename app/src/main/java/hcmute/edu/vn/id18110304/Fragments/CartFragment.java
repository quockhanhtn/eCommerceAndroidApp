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
public class CartFragment extends Fragment {

   public static final String TAG = CartFragment.class.getSimpleName();
   private FragmentCartBinding binding;

   private List<CartEntity> listCarts = new ArrayList<>();
   CartAdapter cartAdapter = null;

   public CartFragment() {
      // Required empty public constructor
   }

   public static CartFragment newInstance(String param1, String param2) {
      CartFragment fragment = new CartFragment();
      Bundle args = new Bundle();

      fragment.setArguments(args);
      return fragment;
   }

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
   }

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
      binding = FragmentCartBinding.inflate(inflater, container, false);

      cartAdapter = new CartAdapter(getContext(), listCarts);
      binding.recyclerviewCart.setLayoutManager(LayoutManagerUtils.getVertical(getContext(), 1));
      binding.recyclerviewCart.setHasFixedSize(false);
      binding.recyclerviewCart.setAdapter(cartAdapter);

      return binding.getRoot();
   }

   public void addToCart(ProductDomain product, String productType, int quantity) {

      for (int i = 0; i < listCarts.size(); i++) {
         if (listCarts.get(i).getProduct().getProductId() == product.getProductId()
               && listCarts.get(i).getProductType().equals(productType)) {
            listCarts.get(i).setQuantity(listCarts.get(i).getQuantity() + 1);
            return;
         }
      }

      CartEntity newCart = new CartEntity();

      if (product != null) {
         newCart.setProduct(product);
      }

      if (productType != null && !productType.isEmpty()) {
         newCart.setProductType(productType);
      }

      newCart.setQuantity(quantity);

      listCarts.add(newCart);
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
}