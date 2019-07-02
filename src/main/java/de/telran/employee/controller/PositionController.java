package de.telran.employee.controller;

import de.telran.employee.dto.PositionDto;
import de.telran.employee.repository.PositionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/position")
public class PositionController {

    private final PositionRepository positionRepository;

    public PositionController(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @GetMapping("")
    public List<PositionDto> getAllPositions() {
        return positionRepository.getAllRecords();
    }
}
