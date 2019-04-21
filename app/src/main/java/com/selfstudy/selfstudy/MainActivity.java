package com.selfstudy.selfstudy;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import fragments.HomeFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private BottomNavigationView mBottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Menu icon clicked", Toast.LENGTH_SHORT).show();
            }
        });
        
        defaultFragmentTransaction();

        mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.menu_home :
                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_tests :
                        Toast.makeText(MainActivity.this, "Tests", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_analysis :
                        Toast.makeText(MainActivity.this, "Analysis", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_doubts :
                        Toast.makeText(MainActivity.this, "Doubts", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_profile :
                        Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_achievements:
                Toast.makeText(this, "Achievements", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_wallet:
                Toast.makeText(this, "Wallet", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    private void initializeViews(){
        mToolbar = findViewById(R.id.toolbar);
        mBottomNav = findViewById(R.id.bnv_bottomNav);
    }

    private void defaultFragmentTransaction(){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.ll_window, new HomeFragment()).commit();
    }
}
