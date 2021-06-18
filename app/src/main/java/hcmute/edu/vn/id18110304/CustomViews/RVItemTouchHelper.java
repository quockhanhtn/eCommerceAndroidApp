package hcmute.edu.vn.id18110304.CustomViews;

import android.graphics.Canvas;
import android.view.View;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import hcmute.edu.vn.id18110304.Adapters.CartAdapter;
import hcmute.edu.vn.id18110304.Interfaces.IItemTouchHelperListener;

/**
 * Recycle View Item Touch Helper
 *
 * @author Khanh Lam
 * @version 1.0
 */
public class RVItemTouchHelper extends ItemTouchHelper.SimpleCallback {

   IItemTouchHelperListener listener;

   public RVItemTouchHelper(int dragDirs, int swipeDirs, IItemTouchHelperListener listener) {
      super(dragDirs, swipeDirs);
      this.listener = listener;
   }

   @Override
   public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
      return true;
   }

   @Override
   public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
      if (listener != null) {
         listener.onSwiped(viewHolder);
      }
   }

   @Override
   public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
      if (viewHolder instanceof CartAdapter.CartItemViewHolder) {
         View view = ((CartAdapter.CartItemViewHolder) viewHolder).getSwipeLayout();
         getDefaultUIUtil().onSelected(view);
      } else {
         super.onSelectedChanged(viewHolder, actionState);
      }
   }

   @Override
   public void onChildDrawOver(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
      if (viewHolder instanceof CartAdapter.CartItemViewHolder) {
         CartAdapter.CartItemViewHolder cartHolder = ((CartAdapter.CartItemViewHolder) viewHolder);

         cartHolder.hiddenMainLayout();
         getDefaultUIUtil().onDrawOver(c, recyclerView, cartHolder.getSwipeLayout(), dX, dY, actionState, isCurrentlyActive);
         cartHolder.showMainLayout();
      } else {
         super.onChildDrawOver(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
      }
   }

   @Override
   public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
      if (viewHolder instanceof CartAdapter.CartItemViewHolder) {
         CartAdapter.CartItemViewHolder cartHolder = ((CartAdapter.CartItemViewHolder) viewHolder);

         cartHolder.hiddenMainLayout();
         getDefaultUIUtil().onDraw(c, recyclerView, cartHolder.getSwipeLayout(), dX, dY, actionState, isCurrentlyActive);
         cartHolder.showMainLayout();
      } else {
         super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
      }
   }

   @Override
   public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
      if (viewHolder instanceof CartAdapter.CartItemViewHolder) {
         View view = ((CartAdapter.CartItemViewHolder) viewHolder).getSwipeLayout();
         getDefaultUIUtil().clearView(view);
      } else {
         super.clearView(recyclerView, viewHolder);
      }
   }
}