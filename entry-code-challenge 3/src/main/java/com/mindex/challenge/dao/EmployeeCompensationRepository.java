package com.mindex.challenge.dao;
import com.mindex.challenge.data.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.mindex.challenge.data.Compensation;



@Repository
public interface EmployeeCompensationRepository extends MongoRepository<Compensation, String> {
    Compensation getEmployeeCompensationByEmployee(Employee employee);

}
