package marc.com.messagetips;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GalleryActivity extends AppCompatActivity {

	@Bind(R.id.gallery_recy)
	RecyclerView galleryRecy;

	ArrayList<Drawable> imgs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gallery);
		ButterKnife.bind(this);

		imgs = new ArrayList<>();
		Resources resources = this.getResources();
		imgs.add( resources.getDrawable(R.drawable.a));
		imgs.add( resources.getDrawable(R.drawable.b));
		imgs.add( resources.getDrawable(R.drawable.c));
		GalleryListAdapter adapter = new GalleryListAdapter(imgs,this);

		LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
		galleryRecy.setLayoutManager(linearLayoutManager);
		galleryRecy.setAdapter(adapter);
		new LinearSnapHelper().attachToRecyclerView(galleryRecy);



	}
}
