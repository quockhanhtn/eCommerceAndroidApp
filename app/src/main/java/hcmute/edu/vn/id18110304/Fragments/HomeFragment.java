package hcmute.edu.vn.id18110304.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import hcmute.edu.vn.id18110304.Adapters.CategoryAdapter;
import hcmute.edu.vn.id18110304.Communications.Response.CategoryResponse;
import hcmute.edu.vn.id18110304.Communications.WebServices.CategoryService;
import hcmute.edu.vn.id18110304.Domains.CategoryDomain;
import hcmute.edu.vn.id18110304.databinding.FragmentHomeBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

   public static final String TAG = HomeFragment.class.getSimpleName();

   private FragmentHomeBinding binding;

   List<CategoryDomain> listCategories = null;

   // Required empty public constructor
   public HomeFragment() {
   }

   public static HomeFragment newInstance() {
      return new HomeFragment();
   }

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
   }

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
      binding = FragmentHomeBinding.inflate(inflater, container, false);
      return binding.getRoot();
   }

   @Override
   public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
      super.onActivityCreated(savedInstanceState);

      LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
            getContext(), LinearLayoutManager.HORIZONTAL, false
      );
      binding.recyclerviewCategory.setLayoutManager(linearLayoutManager);

      CategoryService.getInstance().getAll(new Callback<CategoryResponse>() {
         @Override
         public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
            if (response.isSuccessful()) {
               CategoryResponse responseDomain = response.body();
               listCategories = responseDomain.getData();

               requireActivity().runOnUiThread(() -> {
                  binding.recyclerviewCategory.setHasFixedSize(true);
                  binding.recyclerviewCategory.setAdapter(new CategoryAdapter(listCategories, getContext()));
               });
            } else {
               Log.d(TAG, String.valueOf(response.errorBody()));
               listCategories = new ArrayList<>();
            }
         }

         @Override
         public void onFailure(Call<CategoryResponse> call, Throwable t) {
            Log.e(TAG, "Network Error");
         }
      });
   }
}