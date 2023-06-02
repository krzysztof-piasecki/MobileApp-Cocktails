package pl.put.poznan.aplikacje.mobilne.cocktails;

public class CocktailCard {
    private String name;
    private final int imageResourceId;
    public static final CocktailCard[] cocktails = {
            new CocktailCard("Blood marry #1", R.drawable.blood),
            new CocktailCard("LongIsland #2", R.drawable.long_island),
    };

    private CocktailCard(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
