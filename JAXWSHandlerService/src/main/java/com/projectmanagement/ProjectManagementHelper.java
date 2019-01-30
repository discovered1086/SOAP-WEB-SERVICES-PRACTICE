package com.projectmanagement;


import com.projectmanagementservice.project.Member;
import com.projectmanagementservice.project.Project;
import com.projectmanagementservice.project.SkillSet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kingshuk on 11/19/17.
 */
public class ProjectManagementHelper {
    Map<String, Project> projectMap=new HashMap<>();

    public Project getProjectDetailsFromId(String projectId){
        return buildProjectMap().get(projectId);
    }

    private Map<String, Project> buildProjectMap(){


        Member manager =new Member();
        manager.setEmailAddress("atul.kharkanis@thehartford.com");
        manager.setEmployeeId("145568455");
        manager.setExperience(7);
        manager.setFirstName("Atul");
        manager.setLastName("kharkanis");
        manager.setPhoneNum("860-841-9878");
        manager.setSkillSet(SkillSet.PROJECT_MANAGER);

        Member techLead =new Member();
        techLead.setEmailAddress("steve.quiambao@thehartford.com");
        techLead.setEmployeeId("87895686");
        techLead.setExperience(4);
        techLead.setFirstName("Steve");
        techLead.setLastName("Quiambao");
        techLead.setPhoneNum("860-841-2458");
        techLead.setSkillSet(SkillSet.TECH_LEAD);

        Member qaLead =new Member();
        qaLead.setEmailAddress("nandan.vyas@thehartford.com");
        qaLead.setEmployeeId("87954556");
        qaLead.setExperience(4);
        qaLead.setFirstName("Nandan");
        qaLead.setLastName("Vyas");
        qaLead.setPhoneNum("860-841-9878");
        qaLead.setSkillSet(SkillSet.QA_LEAD);

        Member scrumMaster =new Member();
        scrumMaster.setEmailAddress("brian.kohn@thehartford.com");
        scrumMaster.setEmployeeId("12741475");
        scrumMaster.setExperience(5);
        scrumMaster.setFirstName("Brian");
        scrumMaster.setLastName("Kohn");
        scrumMaster.setPhoneNum("860-841-9878");
        scrumMaster.setSkillSet(SkillSet.SCRUM_MASTER);

        Member developer =new Member();
        developer.setEmailAddress("kingshuk.mukherjee@thehartford.com");
        developer.setEmployeeId("145568455");
        developer.setExperience(7);
        developer.setFirstName("Kingshuk");
        developer.setLastName("Mukherjee");
        developer.setPhoneNum("860-841-0242");
        developer.setSkillSet(SkillSet.DEVELOPER);

        Project project=new Project();
        project.setProjectId("123456");
        project.setProjectLength(12);
        project.setProjectManager(manager);

        List<Member> memberList=project.getMembers();
        memberList.add(techLead);
        memberList.add(developer);
        memberList.add(scrumMaster);
        memberList.add(qaLead);

        project.setTechnology("J2EE");

        projectMap.put("123456",project);

        return projectMap;

    }
}
