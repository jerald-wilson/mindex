package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReportingStructureServiceImplTest {

    private String reportingStructureUrl;


    @Autowired
    private EmployeeService employeeService;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setup() {
        reportingStructureUrl = "http://localhost:" + port + "/reporting-structure/{id}";
    }

    @Test
    public void testGetReportingStructure() {
        UUID johnLennonId = UUID.fromString("16a596ae-edd3-4847-99fe-c4518e82c86f");
        UUID paulMcCartneyId = UUID.fromString("b7839309-3348-463b-a7e3-5de1c168beb3");
        UUID ringoStarrId = UUID.fromString("03aa1462-ffa9-4978-901b-7c001562cf6f");

        ReportingStructure johnLennonReportingStructure = restTemplate.getForEntity(reportingStructureUrl, ReportingStructure.class, johnLennonId).getBody();
        assertEquals(johnLennonReportingStructure.getNumberOfReports(), 4);

        ReportingStructure paulMcCartneyReportingStructure = restTemplate.getForEntity(reportingStructureUrl, ReportingStructure.class, paulMcCartneyId).getBody();
        assertEquals(paulMcCartneyReportingStructure.getNumberOfReports(), 0);

        ReportingStructure ringoStarrReportingStructure = restTemplate.getForEntity(reportingStructureUrl, ReportingStructure.class, ringoStarrId).getBody();
        assertEquals(ringoStarrReportingStructure.getNumberOfReports(), 2);
    }
}
