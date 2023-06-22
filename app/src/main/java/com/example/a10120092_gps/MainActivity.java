package com.example.a10120092_gps;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
/*   Nama  : Alfandi Khaerul Rahman
 *   NIM   : 10120092
 *   Kelas : IF-3
 */
public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    private BottomNavigationView.OnNavigationItemSelectedListener navigation = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected( MenuItem item) {
            Fragment f = null;
            switch (item.getItemId()){
                case R.id.profile:
                    f = new FragmentProfile();
                    break;
                case R.id.tempat_favorit:
                    f = new FragmentTempatFavorit();
                    break;
                case R.id.lokasi_pengguna:
                    f = new MapsActivity();
                    break;
                case R.id.info:
                    f = new FragmentInfo();
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment,f).commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_nav_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigation);
    }
}