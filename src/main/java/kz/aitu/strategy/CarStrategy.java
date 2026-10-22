package kz.aitu.strategy;

public final class CarStrategy implements RouteStrategy {
    private static final double AVERAGE_SPEED_KMH = 40.0;

    @Override
    public RoutePlan plan(Route route) {
        double minutes = TravelTime.minutes(route.distanceKm(), AVERAGE_SPEED_KMH);
        return new RoutePlan("Car", minutes, "Estimated driving time (no traffic data)");
    }
}
