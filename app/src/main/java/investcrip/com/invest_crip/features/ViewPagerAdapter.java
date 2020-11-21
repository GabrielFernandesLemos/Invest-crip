package investcrip.com.invest_crip.features;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import investcrip.com.invest_crip.features.crypto.CryptoListFragment;
import investcrip.com.invest_crip.features.register.RegisterFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(
            @NonNull FragmentManager fragmentManager,
            @NonNull Lifecycle lifecycle
    ) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        Fragment fragment;

        switch (position) {
            case 0:
                fragment = new CryptoListFragment();
                break;
            default:
                fragment = new RegisterFragment();
                break;
        }

        return fragment;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
