package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;

public class OutputView {
    public static final String RACE_RESULT_MESSAGE = "\n실행 결과";
    public static final String NAME_AND_POSITION_SEPARATOR = " : ";
    public static final String POSITION_EXPRESSION = "-";
    public static final String CHAMPION_NAMES_SEPARATOR = ", ";
    public static final String CHAMPION_NAMES_FOLLOWING_MESSAGE = "가 최종 우승했습니다.";

    public static void printRaceResultMessage() {
        System.out.println(RACE_RESULT_MESSAGE);
    }

    public static void printOneTurnRaceResult(RacingGame racingGame) {
        for (Car car : racingGame.getCars()) {
            System.out.println(getOneCarPosition(car));
        }

        System.out.println();
    }

    private static String getOneCarPosition(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName());
        sb.append(NAME_AND_POSITION_SEPARATOR);

        for (int i = 0; i < car.getPosition(); i++) {
            sb.append(POSITION_EXPRESSION);
        }

        return sb.toString();
    }

    public static void printChampionList(RacingGame cars) {
        String championNames = String.join(CHAMPION_NAMES_SEPARATOR, cars.getChampionNames());
        System.out.println(championNames + CHAMPION_NAMES_FOLLOWING_MESSAGE);
    }
}
