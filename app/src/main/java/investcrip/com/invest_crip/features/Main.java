package investcrip.com.invest_crip.features;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import investcrip.com.invest_crip.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setSelectedItemId(R.id.firstMenu);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.secondMenu:
                        finish();
                        startActivity(new Intent(getApplicationContext(), Register.class));
                        return true;
                    case R.id.thirdMenu:
                        finish();
                        startActivity(new Intent(getApplicationContext(), Reports.class));
                        return true;
                }
                return false;
            }
        });
    }
}
