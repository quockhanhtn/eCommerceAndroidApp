package hcmute.edu.vn.id18110304.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hcmute.edu.vn.id18110304.Domains.CountryDomain;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryItemViewHolder> {
   private List<CountryDomain> users;
   private Context context;

   public CountryAdapter(List<CountryDomain> users, Context c) {
      this.users = users;
      this.context = c;
   }

   @Override
   public int getItemCount() {
      return users.size();
   }

   @Override
   public CountryItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//      View itemView = LayoutInflater.from(parent.getContext())
//            .inflate(R.layout.item_user, parent, false);
//
//      return new CountryItemViewHolder(itemView);
      return null;
   }

   @Override
   public void onBindViewHolder(CountryItemViewHolder holder, int position) {
//      User u = users.get(position);
//      Picasso.with(context)
//            .load(u.avatar_url)
//            .into(holder.ivAvatar);
//      holder.tvLoginName.setText(u.login);
//      holder.tvId.setText(String.valueOf(u.id));
   }

   public static class CountryItemViewHolder extends RecyclerView.ViewHolder {
      public TextView tvLoginName;
      public TextView tvId;
      public ImageView ivAvatar;

      public CountryItemViewHolder(View itemView) {
         super(itemView);
//         tvLoginName = (TextView) itemView.findViewById(R.id.tv_login_name);
//         tvId = (TextView) itemView.findViewById(R.id.tv_id);
//         ivAvatar = (ImageView) itemView.findViewById(R.id.iv_avatar);
      }
   }
}
