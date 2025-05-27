package zuzz.projects.initial.application.ports.output;

import java.util.List;

import zuzz.projects.initial.domain.Spend;

public interface SpendRepository {

    void save(Spend spend);
    void update(Spend spend);
    void delete(Long spendId);

    Spend findById(Long id);
    List<Spend> findAll();
    List<Spend> findByCategory(String category);
}
