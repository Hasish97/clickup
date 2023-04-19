package com.Inova.ClickupDashboard.controllers;
import com.Inova.ClickupDashboard.dtos.ProjectAssignersDetailsDto;
import com.Inova.ClickupDashboard.dtos.ProjectWorkSummaryDto;
import com.Inova.ClickupDashboard.dtos.RequestDateRangeDto;
import com.Inova.ClickupDashboard.dtos.RequestEmpWorkSummaryDto;
import com.Inova.ClickupDashboard.exception.aop.ResponseExceptionHandler;
import com.Inova.ClickupDashboard.service.impl.ProjectWorkSummaryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.Inova.ClickupDashboard.service.UserAuthentication.AuthenticateUser;


@RestController
@RequestMapping("/api/project")
public class Project_summary_controller {
    @Autowired
    ProjectWorkSummaryImpl projectWorkSummary;

    @ResponseExceptionHandler
    @GetMapping("/{project_Id}/get_all_work_summary")
    public ResponseEntity<List<ProjectWorkSummaryDto>> getAllSummay(@PathVariable String project_Id) throws Exception{
        AuthenticateUser();
        List<ProjectWorkSummaryDto> projectWorkSummary = this.projectWorkSummary.getAllProjectWorkSummary(project_Id);
        return new ResponseEntity<>(projectWorkSummary, HttpStatus.OK);
    }
    @ResponseExceptionHandler
    @PostMapping("/{project_Id}/get_project_summary")
    public ResponseEntity<List<ProjectWorkSummaryDto>> getAllSummaryWithinDates(@PathVariable String project_Id, @RequestBody RequestEmpWorkSummaryDto requestEmpWorkSummaryDto) throws Exception{
        AuthenticateUser();
        List<ProjectWorkSummaryDto> projectWorkSummary = this.projectWorkSummary.getAllProjectWorkSummaryWithinDates(project_Id, requestEmpWorkSummaryDto);
        return new ResponseEntity<>(projectWorkSummary, HttpStatus.OK);
    }
    @ResponseExceptionHandler
    @PostMapping("get_project_Assginers_summary")
    public ResponseEntity<List<ProjectAssignersDetailsDto>> getProjectAssginersSummary(@RequestBody RequestDateRangeDto requestDateRangeDto) throws Exception{
        List<ProjectAssignersDetailsDto> projectAssignersDetails = this.projectWorkSummary.getProjectAssignersDetails(requestDateRangeDto);
        return new ResponseEntity<>(projectAssignersDetails, HttpStatus.OK);
    }

}
