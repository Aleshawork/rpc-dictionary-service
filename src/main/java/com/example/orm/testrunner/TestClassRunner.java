package com.example.orm.testrunner;

import com.example.orm.testrunner.config.TestMethod;
import com.example.orm.testrunner.config.TestRunnerApplicationContext;
import com.example.orm.testrunner.dto.TestReport;
import com.example.orm.testrunner.dto.TestsReports;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public class TestClassRunner implements Callable<TestsReports> {

    private final TestsReports testsReports;
    private final Class<?> testClass;

    public TestClassRunner(TestsReports testsReports, Class<?> testClass) {
        this.testsReports= testsReports;
        this.testClass = testClass;
    }


    @Override
    public TestsReports call() throws Exception {
        testsReports.setStatus(TestReport.Status.IN_PROGRESS);
        runtest();
        testsReports.setStatus(TestReport.Status.SUCCESS);
        return testsReports;
    }

    private void runtest() {
        for(Method method: testClass.getMethods()){
            if(!method.isAnnotationPresent(TestMethod.class)) {
                continue;
            }
            TestReport testReport = new TestReport();
            testReport.setName(String.format("%s_%s",testClass.getName(),method.getName()));
            testsReports.getTestReportList().add(testReport);
            try{
                method.invoke(TestRunnerApplicationContext.getBean(testClass));
                testReport.setStatus(TestReport.Status.SUCCESS);
            } catch (IllegalAccessException e) {
                testReport.setStatus(TestReport.Status.FAIL);
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                testReport.setStatus(TestReport.Status.FAIL);
                e.printStackTrace();
            }

        }
    }
}
