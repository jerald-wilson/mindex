package com.mindex.challenge.service;

import com.mindex.challenge.data.ReportingStructure;

import java.util.UUID;

public interface ReportingStructureService {
    ReportingStructure getReportingStructure(UUID employeeId);
}
