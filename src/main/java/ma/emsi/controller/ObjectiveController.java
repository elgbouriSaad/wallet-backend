package ma.emsi.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.emsi.model.Objective;
import ma.emsi.service.ObjectiveService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/objective")
@AllArgsConstructor
public class ObjectiveController {

    private final ObjectiveService objectiveService;

    @PostMapping
    public ResponseEntity<?> createObjective(@Valid @RequestBody Objective objective) {
        try {
            Objective createdObjective = objectiveService.createObjective(objective);
            return new ResponseEntity<>(createdObjective, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getObjectiveById(@PathVariable int id) {
        try {
            Objective objective = objectiveService.getObjectiveById(id);
            return ResponseEntity.ok(objective);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Objective>> getAllObjectives() {
        List<Objective> objectives = objectiveService.getAllObjectives();
        return ResponseEntity.ok(objectives);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateObjective(@PathVariable int id, @Valid @RequestBody Objective updatedObjective) {
        try {
            Objective objective = objectiveService.updateObjective(id, updatedObjective);
            return ResponseEntity.ok(objective);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteObjective(@PathVariable int id) {
        try {
            objectiveService.deleteObjective(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
