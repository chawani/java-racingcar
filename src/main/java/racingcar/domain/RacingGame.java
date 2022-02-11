package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();

    public RacingGame(String[] names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move(car.generateRandomNumber());
        }
    }

    public List<String> getAllCurrentPosition() {
        List<String> positions = new ArrayList<>();

        for (Car car : cars) {
            positions.add(car.getCurrentPosition());
        }

        return positions;
    }

    public int getHighScore() {
        int highScore = 0;

        for (Car car : cars) {
            highScore = car.getBiggerPosition(highScore);
        }

        return highScore;
    }

    public List<String> getChampionNames() {
        List<String> championNames = new ArrayList<>();
        int highScore = getHighScore();

        for (Car car : cars) {
            if (car.isChampion(highScore)) {
                championNames.add(car.getName());
            }
        }

        return championNames;
    }
}
