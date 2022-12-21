public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Wolrd");


        Movie eka = new Movie("Fast and Furious", 2009);
        Movie toka = new Movie("Harry Potter", 1999);
        Movie kolmas = new Movie("Star Wars", 1987);
        Movie neljäs = new Movie("Batman", 1974);
        Movie viides = new Movie("Hulk", 1999);
        Movie kuudes = new Movie("Django", 2016);
        Movie seiska = new Movie("Suljettu saari", 2004);
        Movie kasi = new Movie("Fight club", 2001);
        Movie ysi = new Movie("Tuntematon sotilas", 2016);

        MovieDatabase<Movie> tietokanta = new MovieDatabase<>();

        tietokanta.addToNotCategorized(eka);
        tietokanta.addToNotCategorized(toka);
        tietokanta.addToNotCategorized(kolmas);
        tietokanta.addToNotCategorized(neljäs);
        tietokanta.addToNotCategorized(viides);
        tietokanta.addToNotCategorized(kuudes);
        tietokanta.addToNotCategorized(seiska);
        tietokanta.addToNotCategorized(kasi);
        tietokanta.addToNotCategorized(ysi);

        tietokanta.printShowns();

        tietokanta.categorize(kolmas); //K
        tietokanta.categorize(eka);    //K
        tietokanta.categorize(toka);   //H
        tietokanta.categorize(ysi);    //K
        tietokanta.categorize(seiska); //K
        tietokanta.categorize(kuudes); //H
        tietokanta.categorize(neljäs); //H

        tietokanta.showMovie(kolmas);
        tietokanta.showMovie(eka);
        tietokanta.showMovie(ysi);


        tietokanta.printShowns();
        tietokanta.printBads();

        tietokanta.notPlayedMovies();

    }
}
