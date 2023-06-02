package pl.put.poznan.aplikacje.mobilne.cocktails;

import static pl.put.poznan.aplikacje.mobilne.cocktails.DetailsActivity.EXTRA_COCKTAIL_ID;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import pl.put.poznan.aplikacje.mobilne.cocktails.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements CocktailListFragmentListener {
    private ActivityMainBinding binding;
    private ShareActionProvider shareActionProvider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        SectionsPagerAdapter pagerAdapter =
                new SectionsPagerAdapter(getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(pagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        setShareActionIntent("test");
        return super.onCreateOptionsMenu(menu);
    }

    private void setShareActionIntent(String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_action) {
            Intent intent = new Intent(this, ActionActivity.class);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void itemClicked(long id) {
        View fragmentContainer = binding.fragmentContainer;
        if (fragmentContainer != null) {
            CocktailDetailFragment details = new CocktailDetailFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            details.setCocktail(id);
            ft.replace(fragmentContainer.getId(), details);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(null);
            ft.commit();

        } else {
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra(EXTRA_COCKTAIL_ID, (int) id);
            startActivity(intent);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
    }
    public void onClickDone(View view) {
        CharSequence text = "To jest prosty pasek snackbar.";
        int duration = 10;
        Snackbar snackbar = Snackbar.make(findViewById(R.id.coordinator), text, duration);
        snackbar.setAction("Cofnij", new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(), "Cofnięto!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        snackbar.show();
    }


}