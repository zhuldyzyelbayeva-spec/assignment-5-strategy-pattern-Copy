package kz.aitu.strategy;

/** Immutable route request shared by all strategies. */
public record Route(String origin, String destination, double distanceKm) {
    public Route {
        if (origin == null || origin.isBlank() || destination == null || destination.isBlank()) {
            throw new IllegalArgumentException("Origin and destination are required");
        }
        if (!Double.isFinite(distanceKm) || distanceKm <= 0) {
            throw new IllegalArgumentException("Distance must be positive and finite");
        }
    }
}
