package marc.com.messagetips;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Broderick on 2017/2/8.
 */

public class TabViewPagerAdapter extends FragmentPagerAdapter {
	Fragment[] fragments;

	public TabViewPagerAdapter(FragmentManager fm, Fragment[] fragments) {
		super(fm);
		this.fragments = fragments;
	}

	@Override
	public int getCount() {
		if(fragments==null){
			return 0;
		}
		return fragments.length;
	}

	@Override
	public Fragment getItem(int position) {
		/*Bundle bundle = new Bundle();
		bundle.putInt("position",position);
		fragments[position].setArguments(bundle);*/
		return fragments[position];
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view==object;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		String t;
		switch (position){
			case 0:
				t = "t0";
				break;
			case 1:
				t = "t1";
				break;
			default:
				t = "test";
				break;
		}
		return t;
	}
	@Override
	public int getItemPosition(Object object) {
		return super.getItemPosition(object);
	}
	@Override
	public long getItemId(int position){
		return super.getItemId(position);
	}
	@Override
	public void destroyItem(ViewGroup container, int position, Object object){
		super.destroyItem(container,position,object);
	}
}
