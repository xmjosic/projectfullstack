package hr.xmjosic.projectfullstack.service;

import hr.xmjosic.projectfullstack.exception.EmployeeNotFoundException;
import hr.xmjosic.projectfullstack.model.Employee;
import hr.xmjosic.projectfullstack.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        employee.setUuid(UUID.randomUUID().toString());
        employee.setCreatedTimestamp(LocalDateTime.now());
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        employee.setUpdatedTimestamp(LocalDateTime.now());
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeByEmployeeUUID(String uuid) {
        return employeeRepository.findEmployeeByUuid(uuid)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee by id " + uuid + " was not found."));
    }

    public void deleteEmployee(String uuid) {
        employeeRepository.deleteEmployeeByUuid(uuid);
    }
}
