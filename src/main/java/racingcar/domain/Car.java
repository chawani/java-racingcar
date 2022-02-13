package racingcar.domain;

public class Car implements Comparable<Car> {
    private static final String CAR_NAME_ERROR_MESSAGE = "유효하지 않은 자동차 이름";
    private static final String CAR_NAME_LENGTH_ERROR_MESSAGE = "자동차 이름 5글자 초과";
    private static final int MAX_NAME_LENGTH = 5;
    private static final int DO_NOT_MOVE_THRESHOLD = 3;

    private final String name;
    private int position = 0;

    public Car(final String name) {
        validateCarName(name);
        validateCarNameLength(name);
        this.name = name;
    }

    private void validateCarName(final String carName) {
        if (carName == null || carName.isEmpty()) {
            throw new IllegalArgumentException(CAR_NAME_ERROR_MESSAGE);
        }
    }

    private void validateCarNameLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    public void move(int number) {
        if (number > DO_NOT_MOVE_THRESHOLD) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isSamePosition(Car car) {
        return this.position == car.position;
    }

    @Override
    public int compareTo(Car car) {
        return this.position - car.position;
    }
}
