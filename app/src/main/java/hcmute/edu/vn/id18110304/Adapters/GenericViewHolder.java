package hcmute.edu.vn.id18110304.Adapters;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/**
 * GenericViewHolder
 *
 * @author Khanh Lam
 * @version 1.0
 */
public abstract class GenericViewHolder<BindingObjectType extends ViewBinding, DataType>
      extends RecyclerView.ViewHolder {

   BindingObjectType bd;

   public GenericViewHolder(BindingObjectType binding) {
      super(binding.getRoot());
      bd = binding;
   }

   public abstract void updateView(DataType dataType);
}
