package de.telran.employee.repository;

import de.telran.employee.dto.EmployeeDto;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;

@Repository
public class EmployeeRepository extends AbstractRepository<EmployeeDto> {

    String pattern = "yyyy-MM-dd";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    @PostConstruct
    @SneakyThrows
    public void init() {
        EmployeeDto employee1 = new EmployeeDto();
        employee1.setFirstName("Vasya");
        employee1.setLastName("Pupkin");
        employee1.setBirthDate(simpleDateFormat.parse("1980-01-01"));
        employee1.setPosition(1);
        createRecord(employee1);
        logger.info("employee1 ", employee1.toString());

        EmployeeDto employee2 = new EmployeeDto();
        employee2.setFirstName("Petya");
        employee2.setLastName("Vaskin");
        employee2.setBirthDate(simpleDateFormat.parse("1980-01-01"));
        employee2.setPosition(2);
        createRecord(employee2);
        logger.info("employee2 ", employee2.toString());
    }
}
