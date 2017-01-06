package marc.com.messagetips;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Broderick on 2017/1/6.
 */

public class MyService extends Service {

	Handler handler = new Handler();
	Runnable run  = new Runnable() {
		@Override
		public void run() {

			Log.i("TAG", "run: 进行网络访问");

			handler.postDelayed(this,1000*5);
		}
	};

	public MyService() {
	}

	@Nullable
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		handler.post(run);
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		handler.removeCallbacks(run);
	}
}
