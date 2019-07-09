package com.mindex.challenge.controller;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReportingStructureController {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/reportingStructure/{id}")
    public ReportingStructure getEmployeeReportingStructure(@PathVariable String id) {
        LOG.debug("Received employee's reporting structure create request for id [{}]", id);
        ReportingStructure empReportingStructure = new ReportingStructure();
        Employee emp = employeeService.read(id);
        if(emp != null){
            empReportingStructure.setEmployee(emp);
            if(emp.getDirectReports().isEmpty()){
                empReportingStructure.setNumberOfReports(0);
            }
            else{
                empReportingStructure.setNumberOfReports(emp.getDirectReports().size());
            }
        }
        return empReportingStructure;
    }

}
