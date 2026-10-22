package kz.aitu.strategy;

import java.util.List;
import java.util.Locale;

/** Client chooses strategies; the Navigator never branches on their types. */
public final class Main {
    private Main() { }

    public static void main(String[] args) {
        Route route = new Route("AITU", "Botanical Garden", 6.0);
        Navigator navigator = new Navigator(new CarStrategy());
        List<RouteStrategy> options = List.of(new CarStrategy(), new WalkStrategy(), new CycleStrategy(), new BusStrategyExample());

        System.out.println("From " + route.origin() + " to " + route.destination());
        for (RouteStrategy option : options) {
            navigator.setStrategy(option); // Runtime strategy switching
            RoutePlan plan = navigator.planRoute(route);
            System.out.printf(Locale.US, "%s: %.1f min — %s%n",
                    plan.transport(), plan.minutes(), plan.description());
        }
    }
}
