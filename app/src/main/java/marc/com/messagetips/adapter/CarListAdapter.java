package marc.com.messagetips.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jauker.widget.BadgeView;

import java.util.List;

import marc.com.messagetips.Bean.JsonBean;
import marc.com.messagetips.R;
import marc.com.messagetips.Listner.ReycleViewClickListner;
import marc.com.messagetips.Helper.StaticVal;

/**
 * Created by Broderick on 2017/1/6.
 */

public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.CarViewHolder>
							implements View.OnClickListener,View.OnLongClickListener{
	private Context mContext;
	private List<JsonBean.DataBean.CarBean> beans;

	private ReycleViewClickListner listner;

	public CarListAdapter(Context mContext) {
		this.mContext = mContext;
	}

	public void setBeans(List<JsonBean.DataBean.CarBean> beans) {
		this.beans = beans;
	}

	public void setListner(ReycleViewClickListner listner) {
		this.listner = listner;
	}

	@Override
	public CarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

		View v = LayoutInflater.from(mContext).inflate(R.layout.car_info_display,parent,false);
		v.setOnClickListener(this);
		v.setOnLongClickListener(this);
		CarViewHolder holder = new CarViewHolder(v);
		return holder;
	}

	@Override
	public void onBindViewHolder(CarViewHolder holder, int position) {
		JsonBean.DataBean.CarBean car = beans.get(position);

		Glide.with(mContext)
				.load(car.getImage())
				.into(holder.car_img);
		holder.car_name.setText(car.getName());
		holder.itemView.setTag(car.getNo());

		//设置消息数量
		StaticVal.BADGE_VIEW = new BadgeView(mContext);
		StaticVal.BADGE_VIEW.setTargetView(holder.car_name);
		StaticVal.BADGE_VIEW.setBadgeCount(42);
	}

	@Override
	public int getItemCount() {
		return beans==null?0:beans.size();
	}

	@Override
	public void onClick(View v) {
		if(listner!=null){
			listner.OnItemClick(v,v.getTag().toString());
		}
	}

	@Override
	public boolean onLongClick(View v) {
		if(listner!=null){
			listner.OnItemLongPress(v,v.getTag().toString());
		}
		return false;
	}

	static class CarViewHolder extends RecyclerView.ViewHolder{
		private ImageView car_img;
		private TextView car_name;
		public CarViewHolder(View itemView) {
			super(itemView);
			car_img = (ImageView)itemView.findViewById(R.id.car_img);
			car_name = (TextView)itemView.findViewById(R.id.car_name);
		}

	}
}
