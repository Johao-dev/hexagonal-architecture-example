package zuzz.projects.initial.infrastructure.adapters.input;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import zuzz.projects.initial.application.dto.NewSpendRequest;
import zuzz.projects.initial.application.ports.input.CreateSpendInputPort;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/spends")
public class SpendApiController {

    private final CreateSpendInputPort createSpendInputPort;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody NewSpendRequest newSpendRequest) {
        createSpendInputPort.execute(newSpendRequest);
        return ResponseEntity.created(URI.create("/api/spends")).build();
    }
}
