package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class CompensationServiceImpl implements CompensationService {

    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Compensation read(UUID id) {
        LOG.debug("Getting employee with id [{}]", id);

        Employee employee = employeeRepository.findByEmployeeId(id);

        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        return employee.getCompensation();
    }

    @Override
    @Transactional
    public Employee update(UUID id, Compensation compensation) {
        // This is not 100% correct
        // I see the changes update on individual employee records, but direct reports do not reflect the change
        // e.g. updating George Harrison displays his compensation
        // searching for George Harrison shows the new compensation
        // searching for Ringo Starr (Harrison is a direct report) displays Harrison's initial compensation (no changes reflected since db init)
        LOG.debug("Updating employee compensation [{}, {}]", id, compensation);

        Employee employee = employeeRepository.findByEmployeeId(id);

        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        employee.setCompensation(compensation);

        return employeeRepository.save(employee);
    }
}
