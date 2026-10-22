package kz.aitu.strategy;

/** Shared conversion for simplified distance/speed estimates. */
final class TravelTime {
    private static final double MINUTES_PER_HOUR = 60.0;
    private TravelTime() { }

    static double minutes(double distanceKm, double speedKmh) {
        if (!Double.isFinite(distanceKm) || distanceKm <= 0.0
                || !Double.isFinite(speedKmh) || speedKmh <= 0.0) {
            throw new IllegalArgumentException("Distance and speed must be positive and finite");
        }
        return distanceKm / speedKmh * MINUTES_PER_HOUR;
    }
}
