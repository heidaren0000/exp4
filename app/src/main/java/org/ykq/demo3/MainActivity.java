package org.ykq.demo3;

import androidx.fragment.app.Fragment;

public class MainActivity extends SingleFragmentActivity{
    @Override
    protected Fragment createFragment() {
        return new FoodListFragment();
    }

}
