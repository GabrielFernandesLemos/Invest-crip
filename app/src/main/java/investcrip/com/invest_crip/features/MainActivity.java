package investcrip.com.invest_crip.features;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import investcrip.com.invest_crip.R;

public class MainActivity extends AppCompatActivity {

    private MenuItem prevMenuItem;
    private BottomNavigationView bottomNavigation;
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewpager);
        bottomNavigation = findViewById(R.id.bottom_navigation);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        setUpViewPagerAndBottomNav();
        setupViewPager();
    }

    private void setUpViewPagerAndBottomNav() {

        bottomNavigation.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        switch (item.getItemId()) {
                            case R.id.firstMenu:
                                viewPager.setCurrentItem(0, true);
                                return true;
                            case R.id.secondMenu:
                                viewPager.setCurrentItem(1, true);
                                return true;
                        }

                        return true;
                    }
                }
        );

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    bottomNavigation.getMenu().getItem(0).setChecked(false);
                }
                bottomNavigation.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigation.getMenu().getItem(position);
            }
        });
    }

    private void setupViewPager() {
        viewPager.setAdapter(
                new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle())
        );
    }
}
