package com.group3.course;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.group3.DAO.DAOInjector;
import com.group3.DAO.IDAOInjector;

@Controller
public class StudentCSVController {
	
	IStudentManager studentManager;
	IDAOInjector daoFactory;
	IEmailInjector emailFactory;
	IPassword passwordGenerator;
	CourseModel courseModel;
	
	public StudentCSVController() {
		daoFactory = new DAOInjector();
		emailFactory = new EmailInjector();
		passwordGenerator = new PasswordGenerator();
		studentManager = new StudentManager(daoFactory, emailFactory, passwordGenerator);
	}

	private static Logger logger = LogManager.getLogger(StudentCSVController.class);
	
	/////////////////////////////////////////STUDENT ENROLLMENT//////////////////////////////////////////////
	
	//Display the webpage that lets the TAs and instructors upload the CSV file
	@RequestMapping("/importCSV")
	public ModelAndView showImportXMLPage() {
		
		logger.info("CSV IMPORT");
		
		ModelAndView mv = new ModelAndView();
//		mv.addObject("courseId",CourseController.courseId);
//		mv.addObject("courseName",CourseController.courseName);
		courseModel = new CourseModel();
		courseModel.setCourseId(CourseController.courseId);
		courseModel.setCourseName(CourseController.courseName);
		mv.addObject("courseInfo",courseModel);
		mv.setViewName("importCSV");
		return mv;
	}
	
	//Handle the CSV file that gets uploaded
	@PostMapping("/upload-csv-file")
    public ModelAndView uploadCSVFile(@RequestParam("file") MultipartFile file, Model model) {
		
		logger.info("UPLOAD CSV");
		
        ArrayList<List<String>> rows = studentManager.addStudentsFromCSV(file);        
        
        studentManager.addStudentToCourse(rows);
        
        ModelAndView mv = new ModelAndView();
        mv.addObject("studentList",rows);
        mv.setViewName("showImportedStudents.html");
        return mv;
	}

	
}
