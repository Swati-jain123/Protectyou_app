package com.example.user.navigationdrawersample;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;


import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private FrameLayout frameLayout;
    private NavigationView navigationView;
    private SwitchCompat darkModeSwitch;
    Button phone;
    Button callfragment;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        toggleDrawer();
        initializeDefaultFragment(savedInstanceState,0);
        setDarkModeSwitchListener();

    }
    /**
     * Initialize all widgets
     */
    private void initializeViews() {
        toolbar = findViewById(R.id.toolbar_id);
        toolbar.setTitle(R.string.toolbar_title);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout_id);
        frameLayout = findViewById(R.id.framelayout_id);
        navigationView = findViewById(R.id.navigationview_id);
        navigationView.setNavigationItemSelectedListener(this);
        darkModeSwitch = (SwitchCompat)navigationView.getMenu().findItem(R.id.nav_darkmode_id).getActionView();
    }

    /**
     * Checks if the savedInstanceState is null - onCreate() is ran
     * If so, display fragment of navigation drawer menu at position itemIndex and
     * set checked status as true
     * @param savedInstanceState
     * @param itemIndex
     */
    private void initializeDefaultFragment(Bundle savedInstanceState, int itemIndex){
        if (savedInstanceState == null){
            MenuItem menuItem = navigationView.getMenu().getItem(itemIndex).setChecked(true);
            onNavigationItemSelected(menuItem);
        }
    }

    /**
     * Creates an instance of the ActionBarDrawerToggle class:
     * 1) Handles opening and closing the navigation drawer
     * 2) Creates a hamburger icon in the toolbar
     * 3) Attaches listener to open/close drawer on icon clicked and rotates the icon
     */
    private void toggleDrawer() {
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        //Checks if the navigation drawer is open -- If so, close it
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        // If drawer is already close -- Do not override original functionality
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, new MessageFragment())
                        .commit();
                closeDrawer();
                break;
            case R.id.nav_helpline:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, new ChatFragment(),null).addToBackStack(null)
                        .commit();

                closeDrawer();
                break;
            case R.id.nav_about:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, new ProfileFragment(),null).addToBackStack(null)
                        .commit();
                closeDrawer();
                break;
            case R.id.nav_gps:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id,new NotebooksFragment(),null).addToBackStack(null)
                        .commit();
                closeDrawer();
                break;
            case R.id.nav_police:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id,new SettingsFragment(),null).addToBackStack(null)
                        .commit();
                closeDrawer();
                break;
            case R.id.nav_hospital:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id,new Fragment_hos(),null).addToBackStack(null)
                        .commit();
                closeDrawer();
                break;

            case R.id.nav_share:
                Intent share=new Intent();
                share.setAction(Intent.ACTION_SEND);
                share.putExtra(Intent.EXTRA_TEXT,"App Link ");
                share.setType("text/plane");
                startActivity(Intent.createChooser(share,"share via"));

                break;
        }
        return true;
    }

    /**
     * Attach setOnCheckedChangeListener to the dark mode switch
     */
    private void setDarkModeSwitchListener(){
        darkModeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked){
                    Toast.makeText(MainActivity.this, "Dark Mode Turn Off", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Dark Mode Turn On", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * Checks if the navigation drawer is open - if so, close it
     */
    private void closeDrawer(){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
    
    /**
     * Iterates through all the items in the navigation menu and deselects them:
     * removes the selection color
     */
    private void deSelectCheckedState(){
        int noOfItems = navigationView.getMenu().size();
        for (int i=0; i<noOfItems;i++){
            navigationView.getMenu().getItem(i).setChecked(false);
        }
    }

//    public boolean OnCreateOptionsMenu(Menu menu){
//        getMenuInflater().inflate(R.menu.nav_drawer_menu,menu);
//        return super.onCreateOptionsMenu(menu);
//
//    }
//    public boolean onOptionsItemSelected(@NonNull MenuItem item){
//        Intent intent=new Intent(Intent.ACTION_SEND);
//        intent.setType("text/plain");
//        intent.putExtra(intent.EXTRA_SUBJECT,"check out this application");
//        intent.putExtra(intent.EXTRA_TEXT,"link");
//        startActivity(Intent.createChooser(intent,"share via"));
//        return super.onOptionsItemSelected(item);
//
//    }
}
