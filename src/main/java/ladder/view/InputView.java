package ladder.view;

import ladder.dto.request.LadderRequest;

import java.util.List;

public interface InputView {
    List<String> inputPlayerNames();

    int inputLineHeight();

    List<String> inputPrizeNames();

    String inputPrizeOwnerName();
}