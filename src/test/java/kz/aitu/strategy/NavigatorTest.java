package kz.aitu.strategy;

/** Standalone test runner: java -ea -cp out kz.aitu.strategy.NavigatorTest */
public final class NavigatorTest {
    private NavigatorTest() { }

    public static void main(String[] args) {
        Route route = new Route("A", "B", 10.0);
        Navigator navigator = new Navigator(new CarStrategy());
        checkClose(15.0, navigator.planRoute(route).minutes());
        navigator.setStrategy(new WalkStrategy());
        checkClose(120.0, navigator.planRoute(route).minutes());
        navigator.setStrategy(new CycleStrategy());
        checkClose(40.0, navigator.planRoute(route).minutes());
        navigator.setStrategy(new BusStrategyExample());
        checkClose(24.0, navigator.planRoute(route).minutes());
        expect(NullPointerException.class, () -> new Navigator(null));
        expect(NullPointerException.class, () -> navigator.setStrategy(null));
        expect(NullPointerException.class, () -> navigator.planRoute(null));
        expect(IllegalArgumentException.class, () -> new Route("A", "B", 0));
        expect(IllegalArgumentException.class, () -> new Route("A", "B", -1));
        expect(IllegalArgumentException.class, () -> new Route("A", "B", Double.NaN));
        expect(IllegalArgumentException.class, () -> new Route("A", "B", Double.POSITIVE_INFINITY));
        expect(IllegalArgumentException.class, () -> TravelTime.minutes(10, 0));
        expect(IllegalArgumentException.class, () -> new RoutePlan("Car", Double.NaN, "invalid"));
        RouteStrategy stub = r -> new RoutePlan("Stub", 7.0, "Test-only strategy");
        navigator.setStrategy(stub);
        checkClose(7.0, navigator.planRoute(route).minutes());
        System.out.println("All tests passed");
    }

    private static void checkClose(double expected, double actual) {
        if (Math.abs(expected - actual) > 1e-9) {
            throw new AssertionError("Expected " + expected + ", got " + actual);
        }
    }

    private static void expect(Class<? extends Throwable> type, Runnable action) {
        try {
            action.run();
        } catch (Throwable error) {
            if (type.isInstance(error)) return;
            throw new AssertionError("Expected " + type.getSimpleName(), error);
        }
        throw new AssertionError("Expected " + type.getSimpleName());
    }
}
