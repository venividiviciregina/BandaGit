package de.telran.employee.repository;

import de.telran.employee.dto.PositionDto;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class PositionRepository extends AbstractRepository<PositionDto> {

    @PostConstruct
    public void init() {
        createRecord(new PositionDto(1, "Worker"));
        createRecord(new PositionDto(2, "Manager"));
        createRecord(new PositionDto(3, "Co-Worker"));
    }

}
