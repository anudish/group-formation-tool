package com.group3.AdminAndAuthorization.Services;
import java.util.ArrayList;

import com.group3.AdminAndAuthorization.Services.IAddCourseService;
import com.group3.AdminAndAuthorization.Services.ICourseInputValidation;
import org.springframework.stereotype.Service;

import com.group3.BusinessModels.Course;
import com.group3.AdminAndAuthorization.DAO.IAddCourseDAO;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class AddCourseService implements IAddCourseService {
	 	private IAddCourseDAO iAddCourseDAO;
	   	private Logger logger = LogManager.getLogger(AddCourseService.class);
	    
	    public AddCourseService iAddCourseService;
        private ArrayList<String> ErrorList,SuccessMessage;
        
        
        
	    public AddCourseService(IAddCourseDAO iAddCourseDAO) {
	        this.iAddCourseDAO = iAddCourseDAO;
	        ErrorList = new ArrayList<>();
	        SuccessMessage = new ArrayList<>();
	    }

	    public ArrayList<String> insertCourseDetails(Course course, ICourseInputValidation icourseInputValidation ) {
	        
	        ErrorList = icourseInputValidation.validateInputCourse(course);
	        
	        //return back to Controller if there is Validation Error
	        if(ErrorList.size() > 0) {
	        	return ErrorList;
	        	
	        }
	        
	        else {
	        	
	        	String feedBackMessage =  iAddCourseDAO.isCourseExist(course.getCourseId());
	        	
                if(feedBackMessage.isEmpty()) {
                	feedBackMessage = iAddCourseDAO.addCourse(course);
                	
                }//In case course doesn't exist at all
	        	SuccessMessage.add(feedBackMessage);
	        	return SuccessMessage;
	        }
	    }

		
}
