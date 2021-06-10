package hcmute.edu.vn.id18110304.Adapters;

import android.content.Context;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * GenericAdapter
 *
 * @author Khanh Lam
 * @version 1.0
 */
public abstract class GenericAdapter<ViewHolderType extends GenericViewHolder, DataItemType>
      extends RecyclerView.Adapter<ViewHolderType> {

   List<DataItemType> listItems;
   Context context;

   public GenericAdapter(Context c, List<DataItemType> list) {
      this.context = c;
      this.listItems = list != null ? list : new ArrayList<>();
   }

   public List<DataItemType> getListItems() {
      return listItems;
   }

   public void setListItems(List<DataItemType> listItems) {
      this.listItems = listItems;
      this.notifyDataSetChanged();
   }

   public Context getContext() {
      return context;
   }

   public void setContext(Context context) {
      this.context = context;
   }

   public abstract ViewHolderType onCreateViewHolder(ViewGroup parent, int viewType);

   @Override
   public void onBindViewHolder(ViewHolderType holder, int position) {
      DataItemType item = listItems.get(position);
      if (item != null) {
         holder.updateView(item);
      }
   }

   @Override
   public int getItemCount() {
      return listItems != null ? listItems.size() : 0;
   }
}
