package zuzz.projects.initial.application.dto;

import lombok.Data;

@Data
public class NewSpendRequest {

    private String category;
    private String description;
    private Double amount;
}
