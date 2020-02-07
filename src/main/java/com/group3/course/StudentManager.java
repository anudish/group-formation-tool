package com.group3.course;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.multipart.MultipartFile;

import com.group3.BusinessModels.Student;
import com.group3.DAO.CourseDAO;
import com.group3.DAO.DAOInjector;
import com.group3.DAO.ICourseDAO;
import com.group3.DAO.IDAOInjector;
import com.group3.DBConnectivity.ObtainDataBaseConnection;

public class StudentManager implements IStudentManager{
	
	Connection conn;
	PreparedStatement statement;
	
	int csvBannerIndex=0, csvFNameIndex=1, csvLNameIndex=2, csvMailIndex=3;
	String sql="";
	String courseId;
	
	IDAOInjector daoInjector;
	IEmailInjector emailInjector;
	ICourseDAO courseDAO;
	IGmailService gmailService;
	IPassword passwordGenerator;
	Student studentDetails;
	
	private static Logger logger = LogManager.getLogger(StudentManager.class);
	
	public StudentManager(IDAOInjector daoInjector, IEmailInjector emailInjector, IPassword passwordGenerator) {
		this.courseDAO = daoInjector.createCourseDAO();
		this.gmailService = emailInjector.getGmailService();
		this.passwordGenerator = passwordGenerator;
	}
	
	public void addStudentToCourse(ArrayList<List<String>> studentList) {
		
		logger.info("ADDING STUDENTS");
		
		ArrayList<List<String>> students = studentList;
		courseId=CourseController.courseId;
		ArrayList<String> current_students = courseDAO.getEnrolledStudentsByCourseId(courseId);
		
		//check if students from csv file are already enrolled or not
		try {
			
			for(int i=0;i<students.size();i++) {
//				String banner=studentList.get(i).get(csvBannerIndex);
				String mail=studentList.get(i).get(csvMailIndex);
//				String fname=studentList.get(i).get(csvFNameIndex);
//				String lname=studentList.get(i).get(csvLNameIndex);
				
				studentDetails = new Student();
				studentDetails.setBannerId(studentList.get(i).get(csvBannerIndex));
				studentDetails.setEmail(studentList.get(i).get(csvMailIndex));
				studentDetails.setFirstName(studentList.get(i).get(csvFNameIndex));
				studentDetails.setLastName(studentList.get(i).get(csvLNameIndex));
				//if not enrolled, add to database and send a mail
				if(!current_students.contains(mail)) {
					
					String pass = passwordGenerator.getNewPassword(10);
					studentDetails.setEncryptedPassword(pass);
			        courseDAO.enrollStudentToCourse(studentDetails, courseId);
			        gmailService.setSMTPClient();
			        gmailService.prepareMail("Enrollment in course:" + courseId, "Dear student,\nYou have been enrolled in the course: "+courseId
			        							+".\nPlease contact the instructor if this is a mistake.\nYour credentials are: \n"
			        							+"Mail: "+mail+"\nPassword: "+pass, mail);
			        gmailService.sendEmail();
				}
			}
			
			logger.info("WRITE TO DATABASE SUCCESSFUL!");
			
		}catch (Exception e) {
			logger.info(e);
		}
	}
	
	public ArrayList<List<String>> addStudentsFromCSV(MultipartFile file) {
		
		logger.info("PARSING CSV FILE");

		ArrayList<List<String>> result = new ArrayList<>();
		if (file.isEmpty()) {
//            model.addAttribute("message", "Please select a CSV file to upload.");
//            model.addAttribute("status", false);
        } else {

            try {
                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
                List<String> row;
                while ((line = br.readLine()) != null) {
                	
                	row = Arrays.asList(line.split(","));
                	result.add(row);
                }
                br.close();
                
                System.out.println(result);
                
            } catch (IOException e) {
            	logger.info(e);
            }

            logger.info("CSV PARSED SUCCESSFULLY!");

        }
        return result;
	}
}
