package kz.aitu.strategy;

public final class CycleStrategy implements RouteStrategy {
    private static final double AVERAGE_SPEED_KMH = 15.0;

    @Override
    public RoutePlan plan(Route route) {
        double minutes = TravelTime.minutes(route.distanceKm(), AVERAGE_SPEED_KMH);
        return new RoutePlan("Cycle", minutes, "Estimated cycling time");
    }
}
