package pl.put.poznan.aplikacje.mobilne.cocktails;

import static pl.put.poznan.aplikacje.mobilne.cocktails.Cocktail.cocktails;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import pl.put.poznan.aplikacje.mobilne.cocktails.databinding.FragmentCocktailDetailBinding;

public class CocktailDetailFragment extends Fragment {
    private long cocktailId;

    public void setCocktail(long id) {
        this.cocktailId = id;
    }
    private FragmentCocktailDetailBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCocktailDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();

        Cocktail cocktail = cocktails[(int) cocktailId];
        binding.textTitle.setText(cocktail.getName());
        binding.textDescription.setText(cocktail.getRecipe());
    }
}