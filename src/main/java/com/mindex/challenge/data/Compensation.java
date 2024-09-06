package com.mindex.challenge.data;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Compensation {
    private BigDecimal salary;
    private LocalDate effectiveDate;

    public Compensation() {
    }

    public Compensation(BigDecimal salary, String effectiveDateString) {
        this.salary = salary;

        LocalDate effectiveDate = LocalDate.parse(effectiveDateString);
        this.effectiveDate = effectiveDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Compensation{");
        sb.append("salary=").append(salary);
        sb.append(", effectiveDate=").append(effectiveDate);
        sb.append('}');
        return sb.toString();
    }
}
