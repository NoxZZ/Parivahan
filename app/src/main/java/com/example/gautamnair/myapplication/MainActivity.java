package com.example.gautamnair.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ImageButton i1;
    private ImageButton i2;
    private ImageButton i3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        i1=findViewById(R.id.i1);
        i2=findViewById(R.id.i2);
        i3=findViewById(R.id.i3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this,"No announcements yet!",Toast.LENGTH_SHORT).show();
            }
        });

        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,dashboard.class));
            }
        });

        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this,"Coming Soon!",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.about) {
            Intent i=new Intent(MainActivity.this,about.class);
            startActivity(i);
        }else if (id == R.id.vl) {
            Intent i = new Intent(this, vl.class);
            startActivity(i);
        }else if (id == R.id.dlrs) {
            Intent i = new Intent(this, dlrs.class);
            startActivity(i);
        }else if (id == R.id.dlrs) {
            Intent i=new Intent(this,dlrs.class);
            startActivity(i);
        }else if (id == R.id.cnbs) {
            Intent i=new Intent(this,cnbs.class);
            startActivity(i);
        }else if (id == R.id.smt) {
            Intent i=new Intent(this,smt.class);
            startActivity(i);
        }else if (id == R.id.ll) {
            Intent i=new Intent(this,ll.class);
            startActivity(i);
        }else if (id == R.id.pl) {
            Intent i=new Intent(this,pl.class);
            startActivity(i);
        }else if (id == R.id.rol) {
            Intent i=new Intent(this,rol.class);
            startActivity(i);
        }else if (id == R.id.dl) {
            Intent i=new Intent(this,dl.class);
            startActivity(i);
        }else if (id == R.id.faus) {
            Intent i=new Intent(this,faus.class);
            startActivity(i);
        }else if (id == R.id.trc) {
            Intent i=new Intent(this,trc.class);
            startActivity(i);
        }else if (id == R.id.prc) {
            Intent i=new Intent(this,prc.class);
            startActivity(i);
        }else if (id == R.id.rrc) {
            Intent i=new Intent(this,rrc.class);
            startActivity(i);
        }else if (id == R.id.drc) {
            Intent i=new Intent(this,drc.class);
            startActivity(i);
        }else if (id == R.id.ac) {
            Intent i=new Intent(this,ac.class);
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
