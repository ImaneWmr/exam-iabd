package exo;

import models.Trip;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

public class Partie2 {

    private final Function<Trip, String> getCity = Trip::city;

    private final Function<Trip, String> getDriverId = Trip::driverId;
    private final ToDoubleFunction<Trip> getPrice = Trip::price;

    private final ToDoubleFunction<Trip> getDuration = Trip::durationMin;
    public Map<String, Long> countByCity(List<Trip> trips) {
        return trips.stream()
                .collect(Collectors.groupingBy(
                        getCity,
                        Collectors.counting()
                ));
    }
    public Map<String, Double> revenueByDriver(List<Trip> trips) {
        return trips.stream()
                .collect(Collectors.groupingBy(
                        getDriverId,
                        Collectors.summingDouble(getPrice)
                ));
    }
    public Map<String, Double> avgDurationByCity(List<Trip> trips) {
        return trips.stream()
                .collect(Collectors.groupingBy(
                        getCity,
                        Collectors.averagingDouble(getDuration)
                ));
    }
}
