package de.telran.employee.repository;

import de.telran.employee.dto.DtoWithId;
import de.telran.employee.dto.EmployeeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AbstractRepository<T extends DtoWithId> {

    Logger logger = LoggerFactory.getLogger(AbstractRepository.class);

    private int lastId = 0;

    private final Map<Integer, T> repository = new HashMap<>();

    public List<T> getAllRecords() {
        return new ArrayList<>(repository.values());
    }

    public T createRecord(T object) {
        object.setId(generateNewId());
        repository.put(object.getId(), object);
        return object;
    }

    public T getById(Integer id) {
        return repository.get(id);
    }

    public T updateRecord(T object) {
        repository.put(object.getId(), object);
        return repository.get(object.getId());
    }

    public T deleteRecord(Integer id) {
        return repository.remove(id);
    }

    private int generateNewId() {
        return ++lastId;
    }

}
