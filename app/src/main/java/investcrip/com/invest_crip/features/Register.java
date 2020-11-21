package investcrip.com.invest_crip.features;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import investcrip.com.invest_crip.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView2);

        bottomNavigationView.setSelectedItemId(R.id.secondMenu);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.firstMenu:
                        finish();
                        startActivity(new Intent(getApplicationContext(), Main.class));
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
