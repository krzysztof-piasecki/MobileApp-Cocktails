package pl.put.poznan.aplikacje.mobilne.cocktails;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Tab1Fragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView cocktailRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_tab1, container, false);
        String[] cocktailNames = new String[Cocktail.cocktails.length];
        for (int i = 0; i < cocktailNames.length; i++) {
            cocktailNames[i] = Cocktail.cocktails[i].getName();
        }
        int[] cocktailImages = new int[Cocktail.cocktails.length];
        for (int i = 0; i < cocktailImages.length; i++) {
            cocktailImages[i] = CocktailCard.cocktails_card[i].getImageResourceId();
        }
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(cocktailNames, cocktailImages);
        cocktailRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        cocktailRecycler.setLayoutManager(layoutManager);
        adapter.setListener(position -> {
            Intent intent = new Intent(getActivity(), CocktailDetailActivity.class);
            intent.putExtra(CocktailDetailActivity.EXTRA_COCKTAIL_CARD_ID, position);
            getActivity().startActivity(intent);
        });
        return cocktailRecycler;
    }
}