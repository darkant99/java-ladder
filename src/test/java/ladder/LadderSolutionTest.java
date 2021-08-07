package ladder;

import ladder.domain.view.FakeInputView;
import ladder.view.DosResultView;
import ladder.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatCode;

class LadderSolutionTest {
    @CsvSource(value = {
            "pobi,honux,crong,jk,jae,won,ㅈ,ㅃ,aa|5|꽝,5000,꽝,3000,꽝,3000,3000,꽝,3000|pobi,all",
            "pobi,honux,crong,jk,jae,won,ㅈ,ㅃ,aa,TT|5|꽝,5000,꽝,3000,꽝,3000,3000,꽝,3000,끝|pobi,all"
    }, delimiter = '|')
    @ParameterizedTest
    @DisplayName("통합 테스트")
    void runTest(String playerNames, int lineHeight, String prizeNames, String prizeOwnerNames) {
        assertThatCode(() -> {
            InputView fakeInputView = toFakeInputView(playerNames, lineHeight, prizeNames, prizeOwnerNames);
            new LadderSolution(
                    fakeInputView, new DosResultView()
            ).run();
        }).doesNotThrowAnyException();
    }

    private InputView toFakeInputView(String playerNames, int lintHeight, String prizeNames, String prizeOwnerNames) {
        return new FakeInputView(
                toList(playerNames),
                lintHeight,
                toList(prizeNames),
                toList(prizeOwnerNames)
        );
    }

    private List<String> toList(String strList) {
        return Arrays.stream(strList.split(","))
                .collect(Collectors.toList());
    }
}