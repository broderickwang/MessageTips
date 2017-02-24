package marc.com.messagetips.UI;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.jauker.widget.BadgeView;

import marc.com.messagetips.GalleryActivity;
import marc.com.messagetips.R;
import marc.com.messagetips.RetrofitActivity;
import marc.com.messagetips.Service.MyService;
import marc.com.messagetips.TabActivity;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
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
		findViewById(R.id.date).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//DatePickerDialog dlg = new DatePickerDialog(MainActivity.this,MainActivity.this,2017,1,1);
				DatePickerDialog dlg = new DatePickerDialog(MainActivity.this,R.style.MyDatepickerTheme,MainActivity.this,2017,1,1);
				dlg.show();
			}
		});
		findViewById(R.id.confirm).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this,R.style.MyConfirmDialogTheme);
				builder.setTitle("确认");
				final String[] items = getResources().getStringArray(R.array.ringtone_list);
				builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(MainActivity.this, "您选择的是:"+items[which], Toast.LENGTH_SHORT).show();
					}
				});
				builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				});
				builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				});
				AlertDialog dlg = builder.create();
				dlg.show();
			}
		});
		findViewById(R.id.tab).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this,TabActivity.class));
			}
		});
		findViewById(R.id.dbbind).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this,DataBindActivity.class));
			}
		});
		findViewById(R.id.expplay).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this,ExoPlayActivity.class));
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

	@Override
	public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
		Toast.makeText(this, year+"-"+month+"-"+dayOfMonth, Toast.LENGTH_SHORT).show();
	}
}
