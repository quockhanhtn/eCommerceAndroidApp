package hcmute.edu.vn.id18110304.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import hcmute.edu.vn.id18110304.Adapters.BrandAdapter;
import hcmute.edu.vn.id18110304.Adapters.CategoryAdapter;
import hcmute.edu.vn.id18110304.Adapters.ProductAdapter;
import hcmute.edu.vn.id18110304.Communications.Domains.BrandDomain;
import hcmute.edu.vn.id18110304.Communications.Domains.CategoryDomain;
import hcmute.edu.vn.id18110304.Communications.Domains.ProductDomain;
import hcmute.edu.vn.id18110304.Communications.Response.BrandResponse;
import hcmute.edu.vn.id18110304.Communications.Response.CategoryResponse;
import hcmute.edu.vn.id18110304.Communications.Response.ProductResponse;
import hcmute.edu.vn.id18110304.Communications.WebServices.BrandService;
import hcmute.edu.vn.id18110304.Communications.WebServices.CategoryService;
import hcmute.edu.vn.id18110304.Communications.WebServices.ProductService;
import hcmute.edu.vn.id18110304.Interfaces.INavigationListener;
import hcmute.edu.vn.id18110304.Utils.LayoutManagerUtils;
import hcmute.edu.vn.id18110304.databinding.FragmentHomeBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * HomeFragment
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class HomeFragment extends GenericFragment {

   public static final String TAG = HomeFragment.class.getSimpleName();
   List<CategoryDomain> listCategories = null;
   CategoryAdapter categoryAdapter = null;
   List<BrandDomain> listBrands = null;
   BrandAdapter brandAdapter = null;
   List<ProductDomain> listProducts = null;
   ProductAdapter productAdapter = null;
   private IAddCartListener iAddCartListener;
   ProductAdapter.IProductAdapterListener productAdapterListener = new ProductAdapter.IProductAdapterListener() {
      @Override
      public void addToFavorite(ProductDomain product, String productType, int quantity) {

      }

      @Override
      public void addToCart(ProductDomain product, String productType, int quantity) {
         iAddCartListener.addToCart(product, productType, quantity);
      }

      @Override
      public void buyNow(ProductDomain product, String productType, int quantity) {
         iAddCartListener.addToCart(product, productType, quantity);
      }
   };
   private FragmentHomeBinding binding;

   public HomeFragment() {
   }

   public HomeFragment(INavigationListener navigationListener) {
      super(navigationListener);
   }

   @Override
   public void onAttach(@NonNull @NotNull Context context) {
      super.onAttach(context);
      iAddCartListener = (IAddCartListener) getActivity();
   }

   @Override
   public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
      binding = FragmentHomeBinding.inflate(inflater, container, false);

      //region Categories
      categoryAdapter = new CategoryAdapter(getContext(), listCategories);
      binding.recyclerviewCategory.setLayoutManager(LayoutManagerUtils.getHorizontal(getContext(), 1));
      binding.recyclerviewCategory.setHasFixedSize(false);
      binding.recyclerviewCategory.setAdapter(categoryAdapter);
      //endregion

      //region Brand
      brandAdapter = new BrandAdapter(getContext(), listBrands);
      binding.recyclerviewBrand.setLayoutManager(LayoutManagerUtils.getHorizontal(getContext(), 2));
      binding.recyclerviewBrand.setHasFixedSize(false);
      binding.recyclerviewBrand.setAdapter(brandAdapter);
      //endregion

      //region Product
      productAdapter = new ProductAdapter(getContext(), listProducts, productAdapterListener);
      binding.recyclerviewProduct.setLayoutManager(LayoutManagerUtils.getVertical(getContext(), 2));
      binding.recyclerviewProduct.setHasFixedSize(false);
      binding.recyclerviewProduct.setAdapter(productAdapter);
      //endregion

      return binding.getRoot();
   }

   @Override
   public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
      super.onViewCreated(view, savedInstanceState);

      binding.lottieLoadingCategories.setVisibility(View.VISIBLE);
      binding.lottieLoadingBrands.setVisibility(View.VISIBLE);

      loadCategory();
      loadBrand();
      loadProduct();
   }

   void loadCategory() {
      CategoryService.getInstance().getAll(new Callback<CategoryResponse>() {
         @Override
         public void onResponse(@NotNull Call<CategoryResponse> call, @NotNull Response<CategoryResponse> response) {
            if (response.isSuccessful()) {
               CategoryResponse responseDomain = response.body();
               listCategories = responseDomain != null ? responseDomain.getData() : new ArrayList<>();

               requireActivity().runOnUiThread(() -> {
                  categoryAdapter.setListItems(listCategories);
                  binding.lottieLoadingCategories.setVisibility(View.GONE);
               });

            } else {
               Log.d(TAG, String.valueOf(response.errorBody()));
            }
         }

         @Override
         public void onFailure(@NotNull Call<CategoryResponse> call, @NotNull Throwable t) {
            Log.e(TAG, "Call api error, message: " + t.getMessage());
         }
      });
   }

   void loadBrand() {
      BrandService.getInstance().getAll(new Callback<BrandResponse>() {
         @Override
         public void onResponse(@NotNull Call<BrandResponse> call, @NotNull Response<BrandResponse> response) {
            if (response.isSuccessful()) {
               BrandResponse responseDomain = response.body();
               listBrands = responseDomain != null ? responseDomain.getData() : new ArrayList<>();

               requireActivity().runOnUiThread(() -> {
                  brandAdapter.setListItems(listBrands);
                  binding.lottieLoadingBrands.setVisibility(View.GONE);
               });
            } else {
               Log.d(TAG, String.valueOf(response.errorBody()));
            }
         }

         @Override
         public void onFailure(Call<BrandResponse> call, Throwable t) {
            Log.e(TAG, "Call api error, message: " + t.getMessage());
         }
      });
   }

   void loadProduct() {
      ProductService.getInstance().getAll(new Callback<ProductResponse>() {
         @Override
         public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
            if (response.isSuccessful()) {
               ProductResponse responseDomain = response.body();
               listProducts = responseDomain != null ? responseDomain.getData() : new ArrayList<>();

               requireActivity().runOnUiThread(() -> {
                  productAdapter.setListItems(listProducts);
                  binding.lottieLoadingProducts.setVisibility(View.GONE);
               });
            } else {
               Log.d(TAG, String.valueOf(response.errorBody()));
            }
         }

         @Override
         public void onFailure(Call<ProductResponse> call, Throwable t) {
            Log.e(TAG, "Call api error, message: " + t.getMessage());
         }
      });
   }

   public interface IAddCartListener {
      void addToCart(ProductDomain product, String productType, int quantity);
   }
}