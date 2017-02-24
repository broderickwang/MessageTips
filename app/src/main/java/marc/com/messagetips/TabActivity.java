package marc.com.messagetips;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import marc.com.messagetips.Adapter.TabViewPagerAdapter;
import marc.com.messagetips.Fragement.TestFragement;

public class TabActivity extends AppCompatActivity {

	@Bind(R.id.tab)
	TabLayout tab;
	@Bind(R.id.viewpager)
	ViewPager viewpager;
	private Fragment[] fragments = {new TestFragement(), new TestFragement(),
			new TestFragement(), new TestFragement()};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab);
		ButterKnife.bind(this);

		viewpager.setAdapter(new TabViewPagerAdapter(getSupportFragmentManager(),fragments) );
		tab.setupWithViewPager(viewpager);
	}
}
