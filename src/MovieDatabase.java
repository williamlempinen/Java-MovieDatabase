import java.util.HashSet;
import java.util.Scanner;

public class MovieDatabase<T extends Movie> {
    
    private HashSet<T> notCategorized;
    private HashSet<T> insterestings;
    private HashSet<T> bad;
    private HashSet<T> played;

    public MovieDatabase() {
        notCategorized = new HashSet<>();
        insterestings = new HashSet<>();
        bad = new HashSet<>();
        played = new HashSet<>();
    }

    public void addToNotCategorized(T e) {
        notCategorized.add(e);
        System.out.println("Elokuva lisätty.");
    }

    public void printNotCategorized() {
        for (T i : notCategorized) {
            System.out.println("Elokuva: " + i.getName());
        }
    }

    public void printInterestings() {
        for (T i : insterestings) {
            System.out.println("Elokuva: " + i.getName());
        }
    }

    public void printBads() {
        for (T i : bad) {
            System.out.println("Elokuva: " + i.getName());
        }
    }

    public void categorize(T e) {
        Scanner x = new Scanner(System.in);
        if (notCategorized.contains(e)) {
            System.out.println("Luokittele elokuva " + e.getName() + " huonoihin tai kiinnostaviin (H/K).");
            String valinta = x.nextLine();
            if (valinta.equals("K")) {
                notCategorized.remove(e);
                insterestings.add(e);
                System.out.println("Valinta oli K.");
                System.out.println("Elokuva " + e.getName() + " lisätty kiinnostavien elokuvien listalle.");
            } else if (valinta.equals("H")) {
                notCategorized.remove(e);
                bad.add(e);
                System.out.println("Valinta oli H.");
                System.out.println("Elokuva " + e.getName() + " lisätty huonojen elokuvien listalle.");
            }
        } else {
            throw new RuntimeException("Elokuvaa ei löydy listalta.");
        }
    }

    public void showMovie(T e) {
        if (insterestings.contains(e)) {
            System.out.println("Esitetään elokuva " + e.getName());
            insterestings.remove(e);
            played.add(e);
        } else {
            throw new RuntimeException("Elokuvaa " + e.getName() + " ei löydy kiinnostavien listalta.");
        }
    }

    public void printShowns() {
        if (played.isEmpty()) {
            System.out.println("Ei vielä esitettyjä.");
        } else {
            System.out.println("Elokuvat, jotka ovat esitetty:");
            for (T i : played) {
                System.out.println(i.getName());
            }
        }
    }

    public void notPlayedMovies() {
        System.out.println("Esittämättömät: ");
        HashSet<T> notPlayed = new HashSet<>();
        for (T i : notCategorized) {
            for (T j : played) {
                if (!(j.equals(i))) {
                    notPlayed.add(i);
                }
            }
        }
        for (T i : insterestings) {
            for (T j : played) {
                if (!(j.equals(i))) {
                    notPlayed.add(i);
                }
            }
        }
        for (T i : bad) {
            for (T j : played) {
                if (!(j.equals(i))) {
                    notPlayed.add(i);
                }
            }
        }
        for (T i : notPlayed) {
            System.out.print(i.getName() + ", ");
        }
    }

}
