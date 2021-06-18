package hcmute.edu.vn.id18110304.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.smarteist.autoimageslider.SliderViewAdapter;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import hcmute.edu.vn.id18110304.databinding.ItemSliderImageBinding;

/**
 * @author Khanh Lam
 * @version 1.0
 */
public class SliderImageAdapter extends
      SliderViewAdapter<SliderImageAdapter.SliderAdapterVH> {

   public static final String TAG = SliderImageAdapter.class.getSimpleName();

   private Context context;
   private List<String> listImageUrls = new ArrayList<>();

   public SliderImageAdapter(Context context) {
      this.context = context;
   }

   public void setListImageUrl(List<String> urls) {
      this.listImageUrls = urls;
      notifyDataSetChanged();
   }

   public void deleteItem(int position) {
      this.listImageUrls.remove(position);
      notifyDataSetChanged();
   }

   public void addItem(String sliderItem) {
      this.listImageUrls.add(sliderItem);
      notifyDataSetChanged();
   }

   @Override
   public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
      return new SliderAdapterVH(
            ItemSliderImageBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)
      );
   }

   @Override
   public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {
      String sliderItem = listImageUrls.get(position);
      viewHolder.loadImage(sliderItem);
   }

   @Override
   public int getCount() {
      //slider view count could be dynamic size
      return listImageUrls.size();
   }

   static class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

      ItemSliderImageBinding bd;
      View itemView;
      ImageView imageViewBackground;
      ImageView imageGifContainer;

      public SliderAdapterVH(ItemSliderImageBinding binding) {
         super(binding.getRoot());
         this.bd = binding;
         this.itemView = binding.getRoot();
         this.imageViewBackground = binding.ivAutoImageSlider;
         this.imageGifContainer = binding.ivGifContainer;
      }

      public void loadImage(String url) {
         bd.ivSliderImage.setVisibility(View.GONE);
         bd.lottieLoading.setVisibility(View.VISIBLE);
         bd.lottieError.setVisibility(View.GONE);

         Picasso.get().load(url).into(bd.ivSliderImage, new Callback() {
            @Override
            public void onSuccess() {
               bd.ivSliderImage.setVisibility(View.VISIBLE);
               bd.lottieLoading.setVisibility(View.GONE);
               bd.lottieError.setVisibility(View.GONE);
            }

            @Override
            public void onError(Exception e) {
               bd.ivSliderImage.setVisibility(View.GONE);
               bd.lottieLoading.setVisibility(View.GONE);
               bd.lottieError.setVisibility(View.VISIBLE);

               Log.e(TAG, "Picasso load image failed: " + e.getMessage());
            }
         });
      }
   }
}
