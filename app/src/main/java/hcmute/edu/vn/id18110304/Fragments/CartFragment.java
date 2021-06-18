package hcmute.edu.vn.id18110304.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.ItemTouchHelper;

import java.util.ArrayList;
import java.util.List;

import hcmute.edu.vn.id18110304.Adapters.CartAdapter;
import hcmute.edu.vn.id18110304.Communications.Domains.CartEntity;
import hcmute.edu.vn.id18110304.Communications.Domains.ProductDomain;
import hcmute.edu.vn.id18110304.CustomViews.RVItemTouchHelper;
import hcmute.edu.vn.id18110304.Interfaces.INavigationListener;
import hcmute.edu.vn.id18110304.R;
import hcmute.edu.vn.id18110304.Utils.DialogUtils;
import hcmute.edu.vn.id18110304.Utils.FormatUtils;
import hcmute.edu.vn.id18110304.Utils.LayoutManagerUtils;
import hcmute.edu.vn.id18110304.Utils.SnackbarUtils;
import hcmute.edu.vn.id18110304.Utils.TextViewUtils;
import hcmute.edu.vn.id18110304.databinding.FragmentCartBinding;

/**
 * CartFragment
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class CartFragment extends GenericFragment
      implements CartAdapter.ICartAdapterListener {

   public static final String TAG = CartFragment.class.getSimpleName();
   CartAdapter cartAdapter = null;
   private FragmentCartBinding binding;
   private final List<CartEntity> listCarts = new ArrayList<>();

   public CartFragment() {
   }

   public CartFragment(INavigationListener navigationListener) {
      super(navigationListener);
   }

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      binding = FragmentCartBinding.inflate(inflater, container, false);

      cartAdapter = new CartAdapter(getContext(), listCarts, this);
      binding.recyclerviewCart.setLayoutManager(LayoutManagerUtils.getVertical(getContext(), 1));
      binding.recyclerviewCart.setHasFixedSize(false);
      binding.recyclerviewCart.setAdapter(cartAdapter);
      //binding.recyclerviewCart.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

      ItemTouchHelper.SimpleCallback simpleCallback = new RVItemTouchHelper(0, ItemTouchHelper.LEFT, holder -> {
         if (holder instanceof CartAdapter.CartItemViewHolder) {
            int pos = holder.getAbsoluteAdapterPosition();
            CartEntity cartDelete = listCarts.get(pos);

            cartAdapter.removeItemAt(pos);
            updateView();

            String snackbarMess = getString(R.string.txt_remove_item) + " \"" + cartDelete.getProduct().getName() + "\"";
            SnackbarUtils.showLong(binding.getRoot(), snackbarMess, getString(R.string.txt_undo), v ->
            {
               cartAdapter.undoRemove(cartDelete, pos);
               binding.recyclerviewCart.scrollToPosition(pos);
               updateView();
            });
         }
      });

      new ItemTouchHelper(simpleCallback).attachToRecyclerView(binding.recyclerviewCart);

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
         if (cart.getQuantity() == 0) {
            cartAdapter.removeItem(cart);
         }
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

      if (navigationListener != null) {
         navigationListener.setBadge(3, listCarts.size());
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
}