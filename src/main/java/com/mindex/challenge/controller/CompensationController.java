package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class CompensationController {
    private static final Logger LOG = LoggerFactory.getLogger(CompensationController.class);

    @Autowired
    private CompensationService compensationService;


    @GetMapping("/compensation/{id}")
    public Compensation read(@PathVariable UUID id) {
        LOG.debug(String.format("Received employee compensation read request for id [{%s}]", id));

        return compensationService.read(id);
    }

    @PutMapping("/compensation/{id}")
    public Employee update(@PathVariable UUID id, @RequestBody Compensation compensation) {
        LOG.debug("Received employee update request for id [{}] and compensation [{}]", id, compensation.toString());

        return compensationService.update(id, compensation);
    }
}
