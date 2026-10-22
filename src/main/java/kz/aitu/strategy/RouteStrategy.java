package kz.aitu.strategy;

/** Common algorithm contract for all transport modes. */
public interface RouteStrategy {
    RoutePlan plan(Route route);
}
