package de.telran.employee.controller;

import de.telran.employee.dto.EmployeeDto;
import de.telran.employee.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping("")
    public Integer createEmployee(@RequestBody EmployeeDto employee) {
        employeeRepository.createRecord(employee);
        return employee.getId();
    }

    @PutMapping("")
    public Integer updateEmployee(@RequestBody EmployeeDto employee) {
        employeeRepository.updateRecord(employee);
        return employee.getId();
    }

    @DeleteMapping("/{id}")
    public Integer deleteEmployee(@PathVariable Integer id) {
        return employeeRepository.deleteRecord(id).getId();
    }

    @GetMapping("")
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.getAllRecords();
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployees(@PathVariable Integer id) {
        return employeeRepository.getById(id);
    }
}
