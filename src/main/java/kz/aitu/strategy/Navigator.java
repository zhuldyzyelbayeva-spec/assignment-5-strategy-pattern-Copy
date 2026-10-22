package kz.aitu.strategy;

import java.util.Objects;

/** Context delegates route calculation to the currently selected strategy. */
public final class Navigator {
    private RouteStrategy strategy;

    public Navigator(RouteStrategy strategy) {
        setStrategy(strategy);
    }

    public void setStrategy(RouteStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy, "Strategy is required");
    }

    public RoutePlan planRoute(Route route) {
        return strategy.plan(Objects.requireNonNull(route, "Route is required"));
    }
}
