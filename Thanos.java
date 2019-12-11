import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

    public class Thanos {

    public static void main(String[] args) {

        List<Hero> heroes = new ArrayList<>();
        heroes.add(new Hero("Hulk", 49));
        heroes.add(new Hero("Black Widow", 34));
        heroes.add(new Hero("Captain America", 100));
        heroes.add(new Hero("Thor", 1501));
        heroes.add(new Hero("thor", 501));
        heroes.add(new Hero("captain america", 10));

        // TODO 1 : Modify Hero to implements Comparable and sort by name (ascending)

        Collections.sort(heroes);

        System.out.println("\nOrder by name:");
        showList(heroes);

        // TODO 2: Add a Comparator and sort by age (descending)
        Comparator<Hero> nachAge = Comparator.comparing(Hero::getAge).reversed();
        Comparator<String> caseInsensitive = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.toLowerCase().compareTo(s2.toLowerCase());
            }
        };

        Comparator<Hero> nachName = Comparator.comparing(Hero::getName, caseInsensitive); 
        Collections.sort(heroes, nachAge);

        System.out.println("\nOrder by age:");
        showList(heroes);

        Collections.sort(heroes, nachName.reversed());

        System.out.println("\nOrder by name (reversed):");
        showList(heroes);
        // 
    }

    private static void showList(List<Hero> heroes) {
        for (Hero heroe : heroes) {
            System.out.println(heroe.getName() + ", " + heroe.getAge());
        }
    }
}