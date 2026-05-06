import exo.Partie1;
import exo.Partie2;
import exo.Partie3;
import exo.Partie4;
import factory.TripFactory;
import models.Trip;

import java.util.List;

void main() {
    //Teste avec une petite liste
    System.out.println("TESTS AVEC PETITE LISTE (10 trajets)  \n");
    List<Trip> smallTrips = TripFactory.generateTrips(10);
    testAll(smallTrips);

    //Teste avec la grande liste
    System.out.println("\n=== TESTS AVEC GRANDE LISTE (10 millions de trajets) ===\n");
    List<Trip> trips = TripFactory.generateTrips(10000000);
    testAll(trips);
}

void testAll(List<Trip> trips) {
    Partie1 partie1 = new Partie1();
    // 1 filtre
    System.out.println("Partie 1: Filtrage ");
    System.out.println("Long and Expensive: " + partie1.longAndExpensiveTrips(trips).size() + " trajets");
    System.out.println("Bad Trips (rating < 3): " + partie1.badTrips(trips).size() + " trajets");
    System.out.println("Recent Trips: " + partie1.recentTrips(trips).size() + " trajets\n");
    // 2 Analyse & statistiques

    Partie2 partie2 = new Partie2();
    System.out.println("Partie 2: Analyse & Statistiques ");
    System.out.println("Trajets par ville: " + partie2.countByCity(trips).size() + " villes");
    System.out.println("Revenu par chauffeur: " + partie2.revenueByDriver(trips).size() + " chauffeurs");
    System.out.println("Durée moyenne par ville: " + partie2.avgDurationByCity(trips).size() + " villes\n");

    Partie3 partie3 = new Partie3();
    System.out.println("Partie 3: Tri & Recherche ");
    var top10 = partie3.top10ExpensiveTrips(trips);
    System.out.println("Top 10 les plus chers: " + top10.size() + " trajets");
    if (!top10.isEmpty()) {
        System.out.println("Prix du plus cher: " + String.format("%.2f€", top10.get(0).price()));
    }
    var best = partie3.bestTrip(trips);
    if (best.isPresent()) {
        System.out.println("Meilleur trajet: rating = " + String.format("%.2f", best.get().rating()));
    }
    System.out.println();

}