package pl.put.poznan.aplikacje.mobilne.cocktails;

public class Cocktail {
    private String name;
    private String recipe;

    public static final Cocktail[] cocktails = {
            new Cocktail("Bloody Mary", "Składniki: \n 40 ml wódki \n 10 ml soku z cytryny" +
                    "\n 120 ml soku pomidorowego \n sos worchestershire \n sól \n pieprz \n tabasco " +
                    "\n gałązka selera naciowego \n\n Sposób przygotowania: \n Wszystkie składniki" +
        "wymieszać w szklance z lodem i ozdobić selerem naciowym."),
            new Cocktail("Long island", "1 cytryna, ekologiczna\n" +
                    "400 g kostek lodu\n" +
                    "40 g białego rumu\n" +
                    "40 g wódki\n" +
                    "40 g ginu\n" +
                    "40 g tequili silver\n" +
                    "40 g likieru pomarańczowego, np. Cointreau\n" +
                    "15 g soku z limonki, świeżo wyciśniętego\n" +
                    "500 g coli")
    };

    public Cocktail(String name, String recipe) {
        this.name = name;
        this.recipe = recipe;
    }

    public Cocktail() {
    }

    public String getName() {
        return name;
    }

    public String getRecipe() {
        return recipe;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
