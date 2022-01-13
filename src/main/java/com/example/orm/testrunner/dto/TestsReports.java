package com.example.orm.testrunner.dto;

import java.time.LocalDateTime;
import java.util.List;

public class TestsReports {
    private String name;
    private LocalDateTime started;
    private LocalDateTime finished;
    private List<TestReport> testReportList;
    private TestReport.Status status;

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized LocalDateTime getStarted() {
        return started;
    }

    public synchronized void setStarted(LocalDateTime started) {
        this.started = started;
    }

    public synchronized LocalDateTime getFinished() {
        return finished;
    }

    public synchronized void setFinished(LocalDateTime finished) {
        this.finished = finished;
    }

    public synchronized List<TestReport> getTestReportList() {
        return testReportList;
    }

    public synchronized void setTestReportList(List<TestReport> testReportList) {
        this.testReportList = testReportList;
    }

    public TestReport.Status getStatus() {
        return status;
    }

    public void setStatus(TestReport.Status status) {
        this.status = status;
    }
}
