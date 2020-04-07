package ladder.view;

import ladder.domain.Entry;
import ladder.domain.Ladder;
import ladder.domain.Line;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ladder.domain.Direction.RIGHT;

public class ResultView {

    private static final String LINE = "-----";
    private static final String SPACE = " ";
    private static final String EMPTY = "     ";
    private static final String SEPARATOR = "|";
    private static final int TAP_SPACE_SIZE = 5;
    private static final int NAME_SPACE_SIZE = 6;

    public static void print(Entry entry) {
        entry.getPlayerNames()
                .forEach(ResultView::printName);
        System.out.println();
    }

    private static void printName(String name) {
        for (int i = 0; i < NAME_SPACE_SIZE - name.length(); i++) {
            System.out.print(' ');
        }
        System.out.print(name);
    }

    public static void print(Ladder ladder) {
        ladder.getLines()
                .forEach(l -> {
                    printLine(l);
                    System.out.println();
                });
    }

    private static void printLine(Line line) {
        IntStream.range(0, TAP_SPACE_SIZE)
                .forEach(i -> System.out.print(SPACE));

        System.out.print(SEPARATOR);

        System.out.print(line.getPoints().subList(0, line.width() - 1)
                .stream()
                .map(p -> p.isConnectedTo(RIGHT) ? LINE : EMPTY)
                .collect(Collectors.joining(SEPARATOR)));

        System.out.print(SEPARATOR);
    }

}
