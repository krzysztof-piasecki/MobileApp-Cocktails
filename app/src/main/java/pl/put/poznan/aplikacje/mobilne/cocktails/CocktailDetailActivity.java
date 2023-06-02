package pl.put.poznan.aplikacje.mobilne.cocktails;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

public class CocktailDetailActivity extends AppCompatActivity {
    public static final String EXTRA_COCKTAIL_CARD_ID = "cocktail_card_Id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coctail_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        int cocktailId = (Integer) getIntent().getExtras().get(EXTRA_COCKTAIL_CARD_ID);
        String cocktailName = CocktailCard.cocktails_card[cocktailId].getName();
        TextView textView = (TextView) findViewById(R.id.cocktail_text);
        textView.setText(cocktailName);
        int cocktailImage = CocktailCard.cocktails_card[cocktailId].getImageResourceId();
        ImageView imageView = (ImageView) findViewById(R.id.cocktail_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, cocktailImage));
        imageView.setContentDescription(cocktailName);
    }
}