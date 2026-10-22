package kz.aitu.strategy;

/** Optional extension: adding this class does not require changes to Navigator. */
public final class BusStrategyExample implements RouteStrategy {
    private static final double AVERAGE_SPEED_KMH = 25.0;

    @Override
    public RoutePlan plan(Route route) {
        return new RoutePlan("Bus", TravelTime.minutes(route.distanceKm(), AVERAGE_SPEED_KMH),
                "Illustrative bus travel time (no waiting time)");
    }
}
