package com.example.u1tema3materiadesign;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.drawerlayout);


    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);


// Navigation Drawer
    DrawerLayout drawer = (DrawerLayout) findViewById(
            R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
            drawer, toolbar, R.string.drawer_open, R.string.drawer_close);
    drawer.addDrawerListener(toggle);
    toggle.syncState();


    NavigationView navigationView = (NavigationView) findViewById(
            R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);
  }

  @SuppressWarnings("StatementWithEmptyBody")
  @Override
  public boolean onNavigationItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.nav_compartir:
        Intent paramView;
        paramView = new Intent("android.intent.action.SEND");
        paramView.setType("text/plain");
        paramView.putExtra("android.intent.extra.TEXT", "Descarga nuestra app de la PlayStore" +
                " \n" + "https://play.google.com/store/apps/details?id=app.product.demarktec.alo14_pasajero");
        startActivity(Intent.createChooser(paramView, "Comparte Nuestro aplicativo"));
        break;
      case R.id.nav_salir:
        finish();
        break;
      default:
        break;
    }
    DrawerLayout drawer = (DrawerLayout) findViewById(
            R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }

  @Override
  public void onBackPressed() {
    DrawerLayout drawer = (DrawerLayout) findViewById(
            R.id.drawer_layout);
    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }

  public void ButtonDerecha(View view) {
    Snackbar.make(view, "Replace with your own action",
            Snackbar.LENGTH_LONG).setAction("Action", null).show();

  }

  public void ButtonIzquierda(View view) {
    Toast.makeText(this, "Se pulso el floating button de la izquierda "+ view.getTag(), Toast.LENGTH_LONG).show();
  }
}

