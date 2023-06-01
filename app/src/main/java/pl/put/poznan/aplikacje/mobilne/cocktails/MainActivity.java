package pl.put.poznan.aplikacje.mobilne.cocktails;

import static pl.put.poznan.aplikacje.mobilne.cocktails.CocktailListFragment.CLICKED_COCKTAIL_ID;
import static pl.put.poznan.aplikacje.mobilne.cocktails.DetailsActivity.EXTRA_COCKTAIL_ID;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import java.util.Optional;

import pl.put.poznan.aplikacje.mobilne.cocktails.databinding.ActivityMainBinding;
import pl.put.poznan.aplikacje.mobilne.cocktails.databinding.FragmentCocktailDetailBinding;

public class MainActivity extends AppCompatActivity implements CocktailListFragmentListener {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    public void itemClicked(long id) {
        View fragmentContainer = binding.fragmentContainer;
        if(fragmentContainer != null){
            CocktailDetailFragment details = new CocktailDetailFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            details.setCocktail(id);
            ft.replace(fragmentContainer.getId(), details);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(null);
            ft.commit();

        }else{
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra(EXTRA_COCKTAIL_ID, (int) id);
            startActivity(intent);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
    }
}