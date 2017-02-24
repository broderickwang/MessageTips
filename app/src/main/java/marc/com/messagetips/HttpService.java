package marc.com.messagetips;

import marc.com.messagetips.Bean.JsonBean;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Broderick on 2017/1/6.
 */

public interface HttpService {
	//http://139.129.211.43:8050/api/UsedCars
	@GET("/api/UsedCars")
	Call<JsonBean> queryCar();
}
