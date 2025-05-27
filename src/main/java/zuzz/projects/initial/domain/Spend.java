package zuzz.projects.initial.domain;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Spend {

    private Long id;
    private String category;
    private String description;
    private Double amount;
    private LocalDate date;
}
