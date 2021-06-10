package hcmute.edu.vn.id18110304.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import hcmute.edu.vn.id18110304.Adapters.CategoryAdapter;
import hcmute.edu.vn.id18110304.Adapters.CategoryFCAdapter;
import hcmute.edu.vn.id18110304.Communications.Domains.CategoryDomain;
import hcmute.edu.vn.id18110304.Communications.Response.CategoryResponse;
import hcmute.edu.vn.id18110304.Communications.WebServices.CategoryService;
import hcmute.edu.vn.id18110304.Utils.LayoutManagerUtils;
import hcmute.edu.vn.id18110304.databinding.FragmentCategoryBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * CategoryFragment
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class CategoryFragment extends Fragment {

   public static final String TAG = CategoryFragment.class.getSimpleName();
   private FragmentCategoryBinding binding;

   List<CategoryDomain> listCategories = null;
   CategoryFCAdapter categoryFCAdapter = null;

   public CategoryFragment() {
      // Required empty public constructor
   }

   public static CategoryFragment newInstance() {
      return new CategoryFragment();
   }


   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      binding = FragmentCategoryBinding.inflate(inflater, container, false);

      categoryFCAdapter = new CategoryFCAdapter(getContext(), listCategories);
      binding.recyclerviewCategory.setLayoutManager(LayoutManagerUtils.getVertical(getContext(), 1));
      binding.recyclerviewCategory.setHasFixedSize(false);
      binding.recyclerviewCategory.setAdapter(categoryFCAdapter);

      return binding.getRoot();
   }

   @Override
   public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
      CategoryService.getInstance().getAll(new Callback<CategoryResponse>() {
         @Override
         public void onResponse(@NotNull Call<CategoryResponse> call, @NotNull Response<CategoryResponse> response) {
            if (response.isSuccessful()) {
               CategoryResponse responseDomain = response.body();
               listCategories = responseDomain != null ? responseDomain.getData() : new ArrayList<>();

               requireActivity().runOnUiThread(() -> {
                  categoryFCAdapter.setListItems(listCategories);
                  binding.lottieLoadingCategories.setVisibility(View.GONE);
               });

            } else {
               Log.d(TAG, String.valueOf(response.errorBody()));
            }
         }

         @Override
         public void onFailure(@NotNull Call<CategoryResponse> call, @NotNull Throwable t) {
            Log.e(TAG, "Call api error, message: " + t.getMessage());
            requireActivity().runOnUiThread(() -> binding.lottieLoadingCategories.setVisibility(View.GONE));
         }
      });
   }
}