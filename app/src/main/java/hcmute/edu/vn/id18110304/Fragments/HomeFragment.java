package hcmute.edu.vn.id18110304.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

import hcmute.edu.vn.id18110304.Adapters.CategoryAdapter;
import hcmute.edu.vn.id18110304.Communications.Requests.CategoryRequest;
import hcmute.edu.vn.id18110304.Domains.CategoryDomain;
import hcmute.edu.vn.id18110304.Utils.OkHttpUtils;
import hcmute.edu.vn.id18110304.databinding.FragmentHomeBinding;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class HomeFragment extends Fragment {

   public static final String TAG = HomeFragment.class.getSimpleName();

   private FragmentHomeBinding binding;

   List<CategoryDomain> listCategories;

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

      OkHttpUtils.sendRequest(
            "https://ecommerce-api.quockhanh.dev/api/categories",
            new Callback() {
               @Override
               public void onFailure(Call call, IOException e) {
                  Log.e(TAG, "Network Error");
               }

               @Override
               public void onResponse(Call call, Response response) throws IOException {
                  String json = response.body().string();
                  CategoryRequest responseDomain = null;
                  try {
                     responseDomain = new ObjectMapper().readValue(json, CategoryRequest.class);
                     listCategories = responseDomain.getData();

                     requireActivity().runOnUiThread(() -> {
                        binding.recyclerviewCategory.setHasFixedSize(true);
                        binding.recyclerviewCategory.setAdapter(new CategoryAdapter(listCategories, getContext()));
                     });

                  } catch (Exception e) {
                     Log.d(TAG, e.getMessage());
                  }
               }
            }
      );
   }
}