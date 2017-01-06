package marc.com.messagetips;

import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.IOException;

public class VideoAcitivity extends AppCompatActivity implements MediaPlayer.OnBufferingUpdateListener,
		MediaPlayer.OnCompletionListener,MediaPlayer.OnPreparedListener,SurfaceHolder.Callback{
	private MediaPlayer mediaPlayer;
	private SurfaceView surfaceView;
	private SurfaceHolder surfaceHolder;
	private int videoWidth;
	private int videoHeight;
	private VideoView videoView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_video_acitivity);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_video_acitivity);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//强制为横屏
		this.surfaceView = (SurfaceView) this.findViewById(R.id.surface);
		this.surfaceHolder = this.surfaceView.getHolder();
		this.surfaceHolder.addCallback(this);
		this.surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		Log.v("cat", ">>>create ok.");


	}
	private void playVideo() throws IllegalArgumentException,
			IllegalStateException, IOException {
		this.mediaPlayer = new MediaPlayer();
		this.mediaPlayer
				.setDataSource("http://v.youku.com/v_show/id_XMTkxMjc1OTA4MA==.html?spm=a2hww.20023042.m_223465.5~5~5~5~5~5~A&from=y1.3-idx-beta-1519-23042.223465.1-1");
		this.mediaPlayer.setDisplay(this.surfaceHolder);
		this.mediaPlayer.prepare();
		this.mediaPlayer.setOnBufferingUpdateListener(this);
		this.mediaPlayer.setOnPreparedListener(this);
		this.mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		Log.i("mplayer", ">>>play video");
	}

	@Override
	public void onBufferingUpdate(MediaPlayer mp, int percent) {

	}

	@Override
	public void onCompletion(MediaPlayer mp) {

	}

	@Override
	public void onPrepared(MediaPlayer mp) {
		this.videoWidth = this.mediaPlayer.getVideoWidth();
		this.videoHeight = this.mediaPlayer.getVideoHeight();

		if (this.videoHeight != 0 && this.videoWidth != 0) {
			this.surfaceHolder.setFixedSize(this.videoWidth, this.videoHeight);
			this.mediaPlayer.start();
		}
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		try {
			this.playVideo();
		} catch (Exception e) {
			Log.i("cat", ">>>error", e);
		}
		Log.i("cat", ">>>surface created");
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		Log.v("mplayer", ">>>surface destroyed");
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
		Log.i("cat", ">>>surface changed");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (this.mediaPlayer != null) {
			this.mediaPlayer.release();
			this.mediaPlayer = null;
		}
	}
}
