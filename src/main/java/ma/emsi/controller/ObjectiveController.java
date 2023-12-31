package ma.emsi.controller;

import lombok.AllArgsConstructor;
import ma.emsi.service.ObjectiveService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/objective")
public class ObjectiveController {

    private final ObjectiveService objectiveService;
}
