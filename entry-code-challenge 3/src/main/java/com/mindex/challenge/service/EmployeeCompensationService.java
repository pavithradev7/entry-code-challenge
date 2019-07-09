package com.mindex.challenge.service;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;

public interface EmployeeCompensationService {
    Compensation create(Compensation employeeCompensation);
    Compensation read(Employee id);
    Compensation update(Compensation employeeCompensation);
}
