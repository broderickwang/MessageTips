package marc.com.messagetips;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Broderick on 2017/2/9.
 */

public class TestFragement extends Fragment {
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View v = inflater.inflate(android.R.layout.simple_list_item_1,container,false);
		TextView tv = (TextView) v.findViewById(android.R.id.text1);
		tv.setText("test fragment");
		return v;
	}
}
