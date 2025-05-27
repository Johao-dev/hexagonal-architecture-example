package zuzz.projects.initial.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import zuzz.projects.initial.application.ports.output.SpendRepository;
import zuzz.projects.initial.application.usecase.CreateSpendUseCase;

@Configuration
public class UseCaseConfig {

    @Bean
    CreateSpendUseCase createSpendUseCase(SpendRepository spendRepository) {
        return new CreateSpendUseCase(spendRepository);
    }
}
