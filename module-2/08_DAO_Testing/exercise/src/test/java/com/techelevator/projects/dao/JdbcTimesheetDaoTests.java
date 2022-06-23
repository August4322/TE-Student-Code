package com.techelevator.projects.dao;

import com.techelevator.projects.model.Timesheet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcTimesheetDaoTests extends BaseDaoTests {

    private static final Timesheet TIMESHEET_1 = new Timesheet(1, 1, 1,
            LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
    private static final Timesheet TIMESHEET_2 = new Timesheet(2, 1, 1,
            LocalDate.parse("2021-01-02"), 1.5, true, "Timesheet 2");
    private static final Timesheet TIMESHEET_3 = new Timesheet(3, 2, 1,
            LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
    private static final Timesheet TIMESHEET_4 = new Timesheet(4, 2, 2,
            LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");
    
    private JdbcTimesheetDao sut;

    private Timesheet testTimesheet;

    @Before
    public void setup() {

        testTimesheet = new Timesheet(-1, 1, 1,
                LocalDate.parse("2022-01-01"), 1.0, true, "Timesheet Test");

        sut = new JdbcTimesheetDao(dataSource);
    }

    @Test
    public void getTimesheet_returns_correct_timesheet_for_id() {
        //Arrange
        //Done above

        //Act
        Timesheet result = sut.getTimesheet(1);

        //Assert
        assertTimesheetsMatch(TIMESHEET_1, result);

        //Act
        Timesheet result2 = sut.getTimesheet(2);

        //Assert
        assertTimesheetsMatch(TIMESHEET_2, result2);

        //Act
        Timesheet result3 = sut.getTimesheet(3);

        //Assert
        assertTimesheetsMatch(TIMESHEET_3, result3);

        //Act
        Timesheet result4 = sut.getTimesheet(4);

        //Assert
        assertTimesheetsMatch(TIMESHEET_4, result4);
    }

    @Test
    public void getTimesheet_returns_null_when_id_not_found() {
        //Arrange
        //Done above

        //Act
        Timesheet result = sut.getTimesheet(100);

        //Assert
        Assert.assertNull(result);
    }

    @Test
    public void getTimesheetsByEmployeeId_returns_list_of_all_timesheets_for_employee() {
        //Arrange
        List<Timesheet> timesheets = new ArrayList<>();

        //Act
        timesheets = sut.getTimesheetsByEmployeeId(1);

        //Assert
        Assert.assertEquals(2, timesheets.size());
        assertTimesheetsMatch(TIMESHEET_1, timesheets.get(0));
        assertTimesheetsMatch(TIMESHEET_2, timesheets.get(1));
    }

    @Test
    public void getTimesheetsByProjectId_returns_list_of_all_timesheets_for_project() {
        //Arrange
        List<Timesheet> timesheets = new ArrayList<>();

        //Act
        timesheets = sut.getTimesheetsByProjectId(1);

        //Assert
        Assert.assertEquals(3, timesheets.size());
        assertTimesheetsMatch(TIMESHEET_1, timesheets.get(0));
        assertTimesheetsMatch(TIMESHEET_2, timesheets.get(1));
        assertTimesheetsMatch(TIMESHEET_3, timesheets.get(2));
    }

    @Test
    public void createTimesheet_returns_timesheet_with_id_and_expected_values() {
        //Arrange
        Timesheet createdTimesheet = sut.createTimesheet(testTimesheet);

        //Act
        Integer newId = createdTimesheet.getTimesheetId();
        Assert.assertTrue(newId > 0);
        testTimesheet.setTimesheetId(newId);

        //Assert
        assertTimesheetsMatch(testTimesheet, createdTimesheet);

    }

    @Test
    public void created_timesheet_has_expected_values_when_retrieved() {
        //Arrange
        Timesheet createdTimesheet = sut.createTimesheet(testTimesheet);

        //Act
        Integer newId = createdTimesheet.getTimesheetId();
        Timesheet retrievedTimesheet = sut.getTimesheet(newId);

        //Assert
        assertTimesheetsMatch(createdTimesheet, retrievedTimesheet);

    }

    @Test
    public void updated_timesheet_has_expected_values_when_retrieved() {
        //Arrange
        Timesheet timesheetToUpdate = sut.getTimesheet(1);

        timesheetToUpdate.setEmployeeId(2);
        timesheetToUpdate.setProjectId(2);
        timesheetToUpdate.setDateWorked(LocalDate.parse("2022-01-01"));
        timesheetToUpdate.setHoursWorked(3);
        timesheetToUpdate.setBillable(false);
        timesheetToUpdate.setDescription("Timesheet 1 Update");

        //Act
        sut.updateTimesheet(timesheetToUpdate);
        Timesheet retrievedTimesheet = sut.getTimesheet(1);

        //Assert
        assertTimesheetsMatch(timesheetToUpdate, retrievedTimesheet);

    }

    @Test
    public void deleted_timesheet_cant_be_retrieved() {
        //Arrange
        sut.deleteTimesheet(1);

        //Act
        Timesheet retrievedTimesheet = sut.getTimesheet(1);

        //Assert
        Assert.assertNull(retrievedTimesheet);

    }

    @Test
    public void getBillableHours_returns_correct_total() {
        //Arrange
        double billableHoursTotal = TIMESHEET_1.getHoursWorked() + TIMESHEET_2.getHoursWorked() + TIMESHEET_3.getHoursWorked();

        //Act
        double retrievedTimesheet = sut.getBillableHours(1, 1) + sut.getBillableHours(2, 1) + sut.getBillableHours(2, 2);

        //Assert
        Assert.assertEquals(billableHoursTotal, retrievedTimesheet, 0.01);


    }

    private void assertTimesheetsMatch(Timesheet expected, Timesheet actual) {
        Assert.assertEquals(expected.getTimesheetId(), actual.getTimesheetId());
        Assert.assertEquals(expected.getEmployeeId(), actual.getEmployeeId());
        Assert.assertEquals(expected.getProjectId(), actual.getProjectId());
        Assert.assertEquals(expected.getDateWorked(), actual.getDateWorked());
        Assert.assertEquals(expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        Assert.assertEquals(expected.isBillable(), actual.isBillable());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
    }

}
