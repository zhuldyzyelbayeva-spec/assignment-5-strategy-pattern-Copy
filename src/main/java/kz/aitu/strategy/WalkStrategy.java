package kz.aitu.strategy;

public final class WalkStrategy implements RouteStrategy {
    private static final double AVERAGE_SPEED_KMH = 5.0;

    @Override
    public RoutePlan plan(Route route) {
        double minutes = TravelTime.minutes(route.distanceKm(), AVERAGE_SPEED_KMH);
        return new RoutePlan("Walk", minutes, "Estimated walking time");
    }
}
