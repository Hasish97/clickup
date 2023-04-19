package com.Inova.ClickupDashboard.service;

import com.Inova.ClickupDashboard.dtos.ProjectAssignersDetailsDto;
import com.Inova.ClickupDashboard.dtos.ProjectWorkSummaryDto;
import com.Inova.ClickupDashboard.dtos.RequestDateRangeDto;
import com.Inova.ClickupDashboard.dtos.RequestEmpWorkSummaryDto;
import com.Inova.ClickupDashboard.exception.impl.AppsException;

import java.util.List;

public interface ProjectWorkSummaryService {
    List<ProjectWorkSummaryDto> getAllProjectWorkSummary(String project_id) throws AppsException;

    List<ProjectWorkSummaryDto> getAllProjectWorkSummaryWithinDates(String project_id, RequestEmpWorkSummaryDto requestEmpWorkSummaryDto) throws AppsException;

    List<ProjectAssignersDetailsDto> getProjectAssignersDetails(RequestDateRangeDto requestDateRangeDto) throws AppsException;
}
