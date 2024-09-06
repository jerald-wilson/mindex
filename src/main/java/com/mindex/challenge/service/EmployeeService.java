package com.mindex.challenge.service;

import com.mindex.challenge.data.Employee;

import java.util.UUID;

public interface EmployeeService {
    Employee create(Employee employee);
    Employee read(UUID id);
    Employee update(Employee employee);
}
