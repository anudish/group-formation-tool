package com.group3.Services;

import java.util.ArrayList;

import com.group3.BusinessModels.GuestModel;
import com.group3.DAO.IInstructorHandlerDAO;
import com.group3.DAO.IUserRoleHandlerDAO;

public class AdminPageServices implements IAdminPageServices {
    private IInstructorHandlerDAO iInstructorHandlerDAO;
    private IUserRoleHandlerDAO  iUserRoleHandlerDAO;
    String Role,MailId,LastName,FirstName,outputMessage;
    private static final String Guest = "Guest";
	private static final String Instructor = "Instructor";
	private GuestModel guestmodel;
	private String CourseId;
	public  AdminPageServices(IInstructorHandlerDAO iInstructorHandlerDAO,IUserRoleHandlerDAO  iUserRoleHandlerDAO,GuestModel guestmodel,String CourseId ) {
		this.iInstructorHandlerDAO = iInstructorHandlerDAO;
		this.iUserRoleHandlerDAO = iUserRoleHandlerDAO;
		this.guestmodel = guestmodel;
		this.CourseId = CourseId;
	}
	@Override
	public String alterUserRole() {
		// TODO Auto-generated method stub
		Role = guestmodel.getUserRole();
		MailId = guestmodel.getEmail();
		LastName = guestmodel.getLastName();
		FirstName = guestmodel.getFirstName();
		if(this.iUserRoleHandlerDAO.returnUserRole(MailId).equals(Role)) {
			
			outputMessage = FirstName+" "+LastName+" has already holds position for "+Role;
		}
		else {
			String previousRole = this.iUserRoleHandlerDAO.returnUserRole(MailId);
			if(this.iUserRoleHandlerDAO.updateUserRole(Role, MailId).length() > 0) {
				outputMessage = FirstName+" "+LastName+" "+" switched their role from "+previousRole+" to "+Role;
			}
			
		}
		if(Role.equals(Guest) && this.iInstructorHandlerDAO.isInstructorExists(MailId)) {
			if(this.iInstructorHandlerDAO.deleteinstructor(MailId).length() > 0) {
				
				System.out.println("Instructor Deleted from database");
			}
			
		}
		if(Role.equals(Instructor)) {
			if(this.iInstructorHandlerDAO.isInstructorExists(MailId) ) {
				ArrayList<String> courseList = this.iInstructorHandlerDAO.getInstructorCourses(MailId);
				for (String courseid:courseList) {
					System.out.println(CourseId +" "+courseid);
					if(courseid.equalsIgnoreCase(CourseId)) {
						
						outputMessage = FirstName+" "+LastName+" "+"is already an instructor for the course "+courseid;
						return outputMessage;
					}
				}
				outputMessage = this.iInstructorHandlerDAO.createNewInstructor(MailId, CourseId);
			}
		}
		return outputMessage;
	}

}
