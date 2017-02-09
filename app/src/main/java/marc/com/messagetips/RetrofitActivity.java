package marc.com.messagetips;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends AppCompatActivity {

	@Bind(R.id.car_list)
	RecyclerView carList;
	private CarListAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_http);
		ButterKnife.bind(this);

//		LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
		LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
		carList.setLayoutManager(linearLayoutManager);

		adapter = new CarListAdapter(this);

		adapter.setListner(new ReycleViewClickListner() {
			@Override
			public void OnItemClick(View v, String data) {
				StaticVal.BADGE_VIEW.setBadgeCount(0);
				Toast.makeText(RetrofitActivity.this, data, Toast.LENGTH_SHORT).show();
			}

			@Override
			public void OnItemLongPress(View v, String data) {
				Toast.makeText(RetrofitActivity.this, data, Toast.LENGTH_SHORT).show();
			}
		});

		carList.setAdapter(adapter);
		new LinearSnapHelper().attachToRecyclerView(carList);

		retrofit();
	}


	private void retrofit() {
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("http://139.129.211.43:8050/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();

		HttpService service = retrofit.create(HttpService.class);
		Call<JsonBean> call = service.queryCar();
		call.enqueue(new Callback<JsonBean>() {
			@Override
			public void onResponse(Call<JsonBean> call, Response<JsonBean> response) {

				JsonBean bean = response.body();

				String msg = bean.getMessage();
				if (msg.equalsIgnoreCase("success")) {
					List<JsonBean.DataBean.CarBean> cars = bean.getData().getCardata();
					/*for (int i = 0; i < cars.size(); i++) {
						JsonBean.DataBean.CarBean car = cars.get(i);
					}*/
					adapter.setBeans(cars);
					adapter.notifyDataSetChanged();
				}

//				Log.i("TAG", "onResponse: "+response.toString());
			}

			@Override
			public void onFailure(Call<JsonBean> call, Throwable t) {

			}
		});
	}
}
