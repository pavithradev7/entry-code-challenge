package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeCompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.EmployeeCompensationService;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;


@Service
public class EmployeeCompensationServiceImpl implements EmployeeCompensationService {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeCompensationServiceImpl.class);
    @Autowired
    private EmployeeCompensationRepository employeeCmpRepository;
    @Autowired
    private EmployeeService employeeService;

    @Override
    public Compensation create(Compensation employeeCmp) {
        LOG.debug("Creating employee compensation [{}]", employeeCmp);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        employeeCmp.setEffectiveDate(formatter.format(date));
        employeeCmpRepository.insert(employeeCmp);
        return employeeCmp;
    }

    @Override
    public Compensation read(Employee employee) {
        LOG.debug("Creating compensation with employee id [{}]", employee);

        Compensation employeeCompensation = employeeCmpRepository.getEmployeeCompensationByEmployee(employee);

        if (employeeCompensation == null) {
            throw new RuntimeException("Invalid employeeId: " + employee);
        }

        return employeeCompensation;
    }

    @Override
    public Compensation update(Compensation employee) {
        LOG.debug("Updating employee compensation [{}]", employee);

        return employeeCmpRepository.save(employee);
    }

}
