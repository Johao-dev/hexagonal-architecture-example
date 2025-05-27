package zuzz.projects.initial.application.ports.input;

import zuzz.projects.initial.application.dto.NewSpendRequest;

public interface CreateSpendInputPort {

    void execute(NewSpendRequest newSpendRequest);
}
