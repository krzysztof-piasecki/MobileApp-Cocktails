package pl.put.poznan.aplikacje.mobilne.cocktails;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pl.put.poznan.aplikacje.mobilne.cocktails.databinding.FragmentCocktailDetailBinding;

public class CocktailListFragment extends ListFragment {
    private CocktailListFragmentListener listener;
    private FragmentCocktailDetailBinding binding;
    public static final String CLICKED_COCKTAIL_ID = "cocktail_id" ;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        List<String> names = Arrays.stream(Cocktail.cocktails)
                .map(Cocktail::getName)
                .collect(Collectors.toList());

        ArrayAdapter<String> adapter = new ArrayAdapter<> (
                inflater.getContext(), android.R.layout.simple_list_item_1, names);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (CocktailListFragmentListener)context;
    }
    @Override
    public void onListItemClick(ListView listView, View itemView, int position, long id) {
        if (listener != null) {
            listener.itemClicked(id);
        }
    }
}