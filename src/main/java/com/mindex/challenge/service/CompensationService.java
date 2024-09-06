package com.mindex.challenge.service;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import org.springframework.stereotype.Service;

import java.util.UUID;

public interface CompensationService {
    Compensation read(UUID id);
    Employee update(UUID id, Compensation compensation);
}
