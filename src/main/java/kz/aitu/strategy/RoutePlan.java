package kz.aitu.strategy;

/** A route estimate, not real-world navigation directions. */
public record RoutePlan(String transport, double minutes, String description) {
    public RoutePlan {
        if (transport == null || transport.isBlank() || description == null || description.isBlank()
                || !Double.isFinite(minutes) || minutes <= 0) {
            throw new IllegalArgumentException("Invalid route plan");
        }
    }
}
