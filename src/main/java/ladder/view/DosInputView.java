package ladder.view;


import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class DosInputView implements InputView {
    private final Scanner scanner;

    public DosInputView() {
        this.scanner = new Scanner(System.in);
    }

    private void printEmptyLine() {
        System.out.println();
    }

    private String inputLine(Text guideText) {
        System.out.println(guideText.toString());
        String input = scanner.nextLine();

        printEmptyLine();

        return input;
    }

    private int inputNumber(Text guideText) {
        String input = inputLine(guideText);

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(Text.NOT_NUMBER_FORMAT);
            return inputNumber(guideText);
        }
    }

    @Override
    public List<String> inputPlayerNames() {
        List<String> playerNames = RegexPatterns.DELIMITER.split(
                inputLine(Text.INPUT_PLAYER_NAMES)
        );
        if (playerNames.size() != new HashSet<>(playerNames).size()) {
            System.out.println(Text.OVERLAP_PLAYER_NAMES);
            return inputPlayerNames();
        }
        return playerNames;
    }

    @Override
    public int inputLineHeight() {
        return inputNumber(Text.INPUT_LINE_HEIGHT);
    }


    private enum Text {
        NOT_NUMBER_FORMAT("숫자의 형식이 아닙니다. 다시 입력 해주세요."),
        OVERLAP_PLAYER_NAMES("중복되 이름이 존재합니다. 다시 입력 해주세요."),
        INPUT_PLAYER_NAMES("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"),
        INPUT_LINE_HEIGHT("최대 사다리 높이는 몇 개인가요?");

        private final String str;

        Text(String str) {
            this.str = str;
        }

        @Override
        public String toString() {
            return str;
        }
    }

    private enum RegexPatterns {
        DELIMITER(
                Pattern.compile("\\s*,\\s*")
        );

        private final Pattern pattern;

        RegexPatterns(Pattern pattern) {
            this.pattern = pattern;
        }

        public List<String> split(String text) {
            return pattern.splitAsStream(text)
                    .collect(Collectors.toList());
        }
    }
}
