package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CompensationServiceImplTest {

    private String compensationUrl;


    @Autowired
    private EmployeeService employeeService;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setup() {
        compensationUrl = "http://localhost:" + port + "/compensation/{id}";
    }

    @Test
    public void testGetReportingStructure() {
        UUID johnLennonId = UUID.fromString("16a596ae-edd3-4847-99fe-c4518e82c86f");
        UUID paulMcCartneyId = UUID.fromString("b7839309-3348-463b-a7e3-5de1c168beb3");
        UUID ringoStarrId = UUID.fromString("03aa1462-ffa9-4978-901b-7c001562cf6f");

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Compensation johnLennonCompensation = restTemplate.getForEntity(compensationUrl, Compensation.class, johnLennonId).getBody();
        assertEquals(johnLennonCompensation.getEffectiveDate(), LocalDate.parse("2024-06-05", dateFormatter));
        assertEquals(johnLennonCompensation.getSalary(), new BigDecimal(1000000));

        Compensation paulMcCartneyCompensation = restTemplate.getForEntity(compensationUrl, Compensation.class, paulMcCartneyId).getBody();
        assertEquals(paulMcCartneyCompensation.getEffectiveDate(), LocalDate.parse("2024-04-24", dateFormatter));
        assertEquals(paulMcCartneyCompensation.getSalary(), new BigDecimal(100000));

        Compensation ringoStarrCompensation = restTemplate.getForEntity(compensationUrl, Compensation.class, ringoStarrId).getBody();
        assertEquals(ringoStarrCompensation.getEffectiveDate(), LocalDate.parse("2024-03-09", dateFormatter));
        assertEquals(ringoStarrCompensation.getSalary(), new BigDecimal(10000));
    }
}
