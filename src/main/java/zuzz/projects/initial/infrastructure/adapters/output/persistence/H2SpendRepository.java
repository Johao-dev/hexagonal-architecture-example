package zuzz.projects.initial.infrastructure.adapters.output.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import zuzz.projects.initial.application.ports.output.SpendRepository;
import zuzz.projects.initial.domain.Spend;
import zuzz.projects.initial.infrastructure.adapters.output.persistence.entity.SpendEntity;

@RequiredArgsConstructor
@Repository
public class H2SpendRepository implements SpendRepository {

    private final SpringDataRepository springDataRepository;

    @Override
    public void save(Spend spend) {
        SpendEntity spendEntity = SpendEntity.builder()
                .category(spend.getCategory())
                .description(spend.getDescription())
                .amount(spend.getAmount())
                .date(spend.getDate())
                .build();

        springDataRepository.save(spendEntity);
    }

    @Override
    public void update(Spend spend) {
        if (springDataRepository.existsById(spend.getId())) {
            SpendEntity spendEntity = springDataRepository.findById(spend.getId())
                .orElseThrow(() -> new IllegalArgumentException("No se ha encontrado el id " + spend.getId()));

            spendEntity.setCategory(spend.getCategory());
            spendEntity.setDescription(spend.getDescription());
            spendEntity.setAmount(spend.getAmount());
            spendEntity.setDate(spend.getDate());

            springDataRepository.save(spendEntity);
        }
    }

    @Override
    public void delete(Long spendId) {
        if (springDataRepository.existsById(spendId)) {
            springDataRepository.deleteById(spendId);
        }
    }

    @Override
    public Spend findById(Long id) {
        springDataRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("No se ha encontrado el id " + id));
        return null;
    }

    @Override
    public List<Spend> findAll() {
        Iterable<SpendEntity> spendEntities = springDataRepository.findAll();
        List<Spend> spends = new ArrayList<>();
        spendEntities.forEach(spendEntity -> spends.add(Spend.builder()
                .category(spendEntity.getCategory())
                .description(spendEntity.getDescription())
                .amount(spendEntity.getAmount())
                .date(spendEntity.getDate())
                .build()));
        return spends;
    }

    @Override
    public List<Spend> findByCategory(String category) {
        List<SpendEntity> spendEntities = springDataRepository.findByCategory(category);
        List<Spend> spends = new ArrayList<>();
        spendEntities.forEach(spendEntity -> spends.add(Spend.builder()
                .category(spendEntity.getCategory())
                .description(spendEntity.getDescription())
                .amount(spendEntity.getAmount())
                .date(spendEntity.getDate())
                .build()));
        return spends;
    }
}
