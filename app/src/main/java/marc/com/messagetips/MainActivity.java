package marc.com.messagetips;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.jauker.widget.BadgeView;

public class MainActivity extends AppCompatActivity {
	BadgeView badge;
	Intent i;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView t = (TextView)findViewById(R.id.text);

		badge = new BadgeView(this);
		badge.setTargetView(t);
		badge.setBadgeCount(42);

		findViewById(R.id.clean).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				badge.setBadgeCount(0);
			}
		});

		findViewById(R.id.vedio).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this,VideoAcitivity.class));
			}
		});

		findViewById(R.id.retrofit).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this,RetrofitActivity.class));
			}
		});
		findViewById(R.id.gallery).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this,GalleryActivity.class));
			}
		});

		i = new Intent(this,MyService.class);
//		startService(i);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i("TAG", "onDestroy: 关闭service ");
		stopService(i);
	}
}
