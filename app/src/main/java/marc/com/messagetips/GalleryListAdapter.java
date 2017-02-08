package marc.com.messagetips;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.DrawableUtils;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Broderick on 2017/2/8.
 */

public class GalleryListAdapter extends RecyclerView.Adapter<GalleryListAdapter.GalleryViewHolder> {


	private ArrayList<Drawable> imgs;
	private Context mContext;

	public GalleryListAdapter(ArrayList<Drawable> imgs, Context mContext) {
		this.imgs = imgs;
		this.mContext = mContext;
	}

	@Override
	public GalleryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View v = LayoutInflater.from(mContext).inflate(R.layout.gallery_info_display,parent,false);

		GalleryViewHolder holder = new GalleryViewHolder(v);
		return holder;
	}

	@Override
	public void onBindViewHolder(GalleryViewHolder holder, int position) {
		holder.galImg.setImageDrawable(imgs.get(position));
	}

	@Override
	public int getItemCount() {
		return imgs==null?0:imgs.size();
	}

	static class GalleryViewHolder extends RecyclerView.ViewHolder{
		private ImageView galImg;
		public GalleryViewHolder(View itemView) {
			super(itemView);
			galImg = (ImageView)itemView.findViewById(R.id.gal_img);
		}
	}
}
