package zuzz.projects.initial.application.usecase;

import java.time.LocalDate;

import lombok.RequiredArgsConstructor;
import zuzz.projects.initial.application.dto.NewSpendRequest;
import zuzz.projects.initial.application.ports.input.CreateSpendInputPort;
import zuzz.projects.initial.application.ports.output.SpendRepository;
import zuzz.projects.initial.domain.Spend;

@RequiredArgsConstructor
public class CreateSpendUseCase implements CreateSpendInputPort {

    private final SpendRepository spendRepository;

    @Override
    public void execute(NewSpendRequest newSpendRequest) {
        Spend spend = Spend.builder()
                .category(newSpendRequest.getCategory())
                .description(newSpendRequest.getDescription())
                .amount(newSpendRequest.getAmount())
                .date(LocalDate.now())
                .build();

        spendRepository.save(spend);
    }
}
