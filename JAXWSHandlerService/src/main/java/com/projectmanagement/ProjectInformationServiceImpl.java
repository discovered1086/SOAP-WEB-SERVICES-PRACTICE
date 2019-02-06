package com.projectmanagement;

import com.projectmanagementservice.project.ProjectInfoRequest;
import com.projectmanagementservice.project.ProjectInfoResponse;
import com.projectmanagementservice.project.ProjectInformationService;

/**
 * Created by kingshuk on 11/19/17.
 */
public class ProjectInformationServiceImpl implements ProjectInformationService {

    @Override
    public ProjectInfoResponse getProjectInfo(ProjectInfoRequest parameters) {
        String regEx = "[0-9]";

        String projectId = parameters.getProjectId();

        ProjectManagementHelper helper = new ProjectManagementHelper();

        ProjectInfoResponse response = new ProjectInfoResponse();

        if (projectId.matches(regEx)) {
            response.setProjectInfo(helper.getProjectDetailsFromId(projectId));
        } //else {
            //throw new ProjectMgmtBusinessException("Invalid project ID. Please request HR to send right project ID.");
        //}


        return response;
    }
}
