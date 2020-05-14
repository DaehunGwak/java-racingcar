package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<Car> cars;

    public RacingCars(final int numberOfCar) {
        this.cars = createInitialCar(numberOfCar);
    }

    public RacingGameSnapshot race(Engine engine) {
        RacingGameSnapshot snapshot = new RacingGameSnapshot();

        for (Car racingCar : cars) {
            CarSnapshot currentSnapshot = racingCar.move(engine);
            snapshot.record(currentSnapshot);
        }

        return snapshot;
    }

    private List<Car> createInitialCar(int numberOfCar) {
        List<Car> initialCars = new ArrayList<>();

        for (int i = 0; i < numberOfCar; i++) {
            initialCars.add(new Car());
        }

        return initialCars;
    }
}