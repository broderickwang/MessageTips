package marc.com.messagetips;

import okhttp3.ResponseBody;
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
