package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.EmployeeCompensationService;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompensationController {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeCompensationService employeeCompensationService;

    @GetMapping("/compensation/employee/{id}")
    public Compensation getEmployeeCompensation(@PathVariable String id) {
        LOG.debug("Received employee's compensation create request for id [{}]", id);
        Employee emp = employeeService.read(id);
        Compensation empCompensation = employeeCompensationService.read(emp);
        return empCompensation;
    }

    @PostMapping("/compensation")
    public Compensation createEmployeeCompensation(@RequestBody Compensation employeeCompensation) {
        LOG.debug("Received compensation create request for [{}]", employeeCompensation);

        return employeeCompensationService.create(employeeCompensation);
    }
}
