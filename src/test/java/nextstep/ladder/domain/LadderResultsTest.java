package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LadderResultsTest {

    @Test
    @DisplayName("팩토리 메소드 정상 작동")
    void of() {
        assertNotNull(LadderResults.of(4, Arrays.asList("꽝", "5000", "꽝", "3000")));
    }

    @Test
    @DisplayName("팩토리 메소드 유효성 검사")
    void validateCount() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                LadderResults.of(4, Arrays.asList("꽝"))
        );
    }

    @Test
    @DisplayName("Lane에 해당되는 결과 반환")
    void getResultByLane() {
        LadderResults results = LadderResults.of(2, Arrays.asList("당첨", "꽝"));
        assertEquals("꽝", results.getResultByLane(Lane.of(1)));
    }
}