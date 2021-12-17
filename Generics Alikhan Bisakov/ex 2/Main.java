import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
        ArrayList<CapitalCities<String,String>> list = new ArrayList<>();

        list.add(new CapitalCities<String, String>("Kazakhstan", "Astana"));
        list.add(new CapitalCities<String, String>("Spain", "Madrid"));
        list.add(new CapitalCities<String, String>("Russia", "Moscow"));
        list.add(new CapitalCities<String, String>("UK", "London"));
        list.add(new CapitalCities<String, String>("Japan", "Tokyo"));
        list.add(new CapitalCities<String, String>("USA", "Washington D.C."));

        findCapital(list, "Kazakhstan");
        findCapital(list, "USA");
    }

    static void findCapital(ArrayList<CapitalCities<String,String>> list, String country) {
        for (CapitalCities<String,String> el : list) {
            if (el.getCountry() == country) {
                System.out.println(country + " - " + el.getCapital());
            }
        }
    }
}

class CapitalCities<K,V> {
    public K country;
    public V capital;

    public CapitalCities(K country, V capital) {
        this.country = country;
        this.capital = capital;
    }

    public V getCapital() {
        return this.capital;
    }

    public K getCountry() {
        return this.country;
    }

    public void setCapital(V capital) {
        this.capital = capital;
    }
}
