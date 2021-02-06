package hr.xmjosic.projectfullstack.repository;

import hr.xmjosic.projectfullstack.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//    @Modifying
//    @Query("DELETE FROM employee e WHERE e.employeeUUID=:employeeUUID")
//    int deleteByEmployeeUUID(@Param("employeeUUID") String employeeUUID);

    void deleteEmployeeByUuid(String uuid);

    Optional<Employee> findEmployeeByUuid(String uuid);
}
