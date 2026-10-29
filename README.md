# Assignment 5 — Strategy Pattern (Java 17)

**Reference implementation for learning and independent adaptation.** Domain: navigation / route-time estimation (Option A). Distances and speeds are illustrative; this does **not** call a map service or calculate real roads.

## Build and run
From the project root (macOS/Linux):
```bash
mkdir -p out
javac -d out src/main/java/kz/aitu/strategy/*.java
java -cp out kz.aitu.strategy.Main
```
Windows PowerShell:
```powershell
New-Item -ItemType Directory -Force out | Out-Null
javac -d out src/main/java/kz/aitu/strategy/*.java
java -cp out kz.aitu.strategy.Main
```
Expected estimates for 6 km: Car 9.0 min, Walk 72.0 min, Cycle 24.0 min, Bus 14.4 min.

## Tests
```bash
javac -cp out -d out src/test/java/kz/aitu/strategy/NavigatorTest.java
java -ea -cp out kz.aitu.strategy.NavigatorTest
```

## How to add a new strategy
1. Create a class implementing `RouteStrategy` (see `BusStrategyExample`).
2. Implement `plan(Route route)` and return a `RoutePlan`.
3. In the client, call `navigator.setStrategy(new BusStrategyExample())`.
4. **Do not change** `Navigator` or `RouteStrategy`.

## Structure
- `RouteStrategy` — common interface
- `CarStrategy`, `WalkStrategy`, `CycleStrategy` — concrete algorithms
- `Navigator` — context with runtime switching
- `Main` — client
- `Route`, `RoutePlan` — immutable data objects
- `BusStrategyExample` — extension demonstrated in Main
- `TravelTime` — package-private shared calculation utility
- `NavigatorTest` — standalone boundary and switching tests
- `REPORT_TEMPLATE.md` — report example to rewrite in your own words
