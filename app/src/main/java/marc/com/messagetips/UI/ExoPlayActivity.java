package marc.com.messagetips.UI;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.exoplayer2.util.Util;
import com.jarvanmo.exoplayerview.ui.ExoVideoPlaybackControlView;
import com.jarvanmo.exoplayerview.ui.ExoVideoView;
import com.jarvanmo.exoplayerview.ui.SimpleMediaSource;
import com.jarvanmo.exoplayerview.widget.SuperAspectRatioFrameLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import marc.com.messagetips.R;

public class ExoPlayActivity extends AppCompatActivity {
	@Bind(R.id.videoView)
	ExoVideoView videoView;
	@Bind(R.id.mode_none)
	Button modeNone;
	@Bind(R.id.mode_fit)
	Button modeFit;
	@Bind(R.id.mode_width)
	Button modeWidth;
	@Bind(R.id.mode_height)
	Button modeHeight;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exo_play);
		ButterKnife.bind(this);

		videoView.setBackListener(new ExoVideoPlaybackControlView.ExoClickListener() {
			@Override
			public void onClick(View view, boolean isPortrait) {
				if(isPortrait)
					finish();
				else
					videoView.changeOrientation();
			}
		});
		videoView.setFullScreenListener(new ExoVideoPlaybackControlView.ExoClickListener() {
			@Override
			public void onClick(View view, boolean isPortrait) {
				videoView.changeOrientation();
			}
		});
		videoView.setPortrait(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT);

		SimpleMediaSource mediaSource = new SimpleMediaSource("http://video19.ifeng.com/video07/2013/11/11/281708-102-007-1138.mp4");

		mediaSource.setDisplayName("iFeng");
		videoView.play(mediaSource);

		modeFit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				videoView.setResizeMode(SuperAspectRatioFrameLayout.RESIZE_MODE_FIT);
			}
		});
		modeNone.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				videoView.setResizeMode(SuperAspectRatioFrameLayout.RESIZE_MODE_NONE);
			}
		});
		modeHeight.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				videoView.setResizeMode(SuperAspectRatioFrameLayout.RESIZE_MODE_FIXED_HEIGHT);
			}
		});
		modeWidth.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				videoView.setResizeMode(SuperAspectRatioFrameLayout.RESIZE_MODE_FIXED_WIDTH );
			}
		});
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}
	@Override
	protected void onStart() {
		super.onStart();
		if (Util.SDK_INT > 23) {
			videoView.resume();
//            videoView.initSelfPlayer(simpleMediaSource);
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		if ((Util.SDK_INT <= 23)) {
			videoView.resume();
		}
	}

	@Override
	public void onPause() {
		super.onPause();
		if (Util.SDK_INT <= 23) {
//            videoView.releaseSelfPlayer();
			videoView.pause();
		}
	}

	@Override
	public void onStop() {
		super.onStop();
		if (Util.SDK_INT > 23) {
			videoView.pause();
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		//you should release the player created by ExoPlayerView
		videoView.releaseSelfPlayer();
	}
}
