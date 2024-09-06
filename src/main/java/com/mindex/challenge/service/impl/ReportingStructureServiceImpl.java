package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public ReportingStructure getReportingStructure(UUID employeeId) {
        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        return new ReportingStructure(employee);
    }
}
