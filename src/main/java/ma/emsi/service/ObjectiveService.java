package ma.emsi.service;

import ma.emsi.model.Objective;
import ma.emsi.repository.ObjectiveRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ObjectiveService {

    private final ObjectiveRepository objectiveRepository;

    public ObjectiveService(ObjectiveRepository objectiveRepository) {
        this.objectiveRepository = objectiveRepository;
    }

    @Transactional
    public Objective createObjective(Objective objective) {
        // Perform any additional validation/business logic here before saving
        return objectiveRepository.save(objective);
    }

    public Objective getObjectiveById(int id) {
        return objectiveRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Objective not found with id: " + id));
    }

    public List<Objective> getAllObjectives() {
        return objectiveRepository.findAll();
    }

    @Transactional
    public Objective updateObjective(int id, Objective updatedObjective) {
        Objective existingObjective = getObjectiveById(id);

        // Perform any additional validation/business logic here before updating
        existingObjective.setName(updatedObjective.getName());
        existingObjective.setAmount(updatedObjective.getAmount());
        existingObjective.setPeriod(updatedObjective.getPeriod());

        return objectiveRepository.save(existingObjective);
    }

    @Transactional
    public void deleteObjective(int id) {
        Objective objective = getObjectiveById(id);
        objectiveRepository.delete(objective);
    }
}
