package com.mindex.challenge.data;

public class ReportingStructure {
    private Employee employee;
    private int numberOfReports;

    public ReportingStructure() {
    }

    public ReportingStructure(Employee employee) {
        this.employee = employee;
        calculateDirectReports(employee);
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getNumberOfReports() {
        return numberOfReports;
    }

    public void setNumberOfReports(int numberOfReports) {
        this.numberOfReports = numberOfReports;
    }

    private void calculateDirectReports(Employee employee) {
        if (null != employee.getDirectReports() && !employee.getDirectReports().isEmpty()) {
            for (Employee report: employee.getDirectReports()) {
                this.numberOfReports += 1;
                calculateDirectReports(report);
            }
        }
    }
}
