package pl.put.poznan.aplikacje.mobilne.cocktails;

import static pl.put.poznan.aplikacje.mobilne.cocktails.CocktailListFragment.CLICKED_COCKTAIL_ID;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import pl.put.poznan.aplikacje.mobilne.cocktails.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {
    private ActivityDetailsBinding binding;
    public static final String EXTRA_COCKTAIL_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        CocktailDetailFragment frag = (CocktailDetailFragment)
                getSupportFragmentManager().findFragmentById(R.id.detail_frag);

        int cocktailId = (int) getIntent().getExtras().get(EXTRA_COCKTAIL_ID);
        frag.setCocktail(cocktailId);


    }
}