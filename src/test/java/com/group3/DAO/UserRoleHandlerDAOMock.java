package com.group3.DAO;
import java.util.ArrayList;

import com.group3.BusinessModels.GuestModel;
public class UserRoleHandlerDAOMock implements IUserRoleHandlerDAO {

	
	ArrayList<GuestModel> userDataSet;
	public UserRoleHandlerDAOMock() {
		userDataSet = new ArrayList<>();
		GuestModel data =  new GuestModel();
		data.setEmail("john@dal.ca");
		data.setFirstName("John");
		data.setLastName("Kellog");
		data.setUserRole("Guest");
		userDataSet.add(data);
		
		data =  new GuestModel();
		data.setEmail("vlado@dal.ca");
		data.setFirstName("Vlado");
		data.setLastName("Keslji");
		data.setUserRole("instructor");
		userDataSet.add(data);
		
		data =  new GuestModel();
		data.setEmail("robert@dal.ca");
		data.setFirstName("Robert");
		data.setLastName("Hawkey");
		data.setUserRole("instructor");
		userDataSet.add(data);
		
	}
	@Override
	public String updateUserRole(String Role, String MaildId) {
		String feedBackMessage = new String();
		for(GuestModel model:userDataSet) {
			
			if(model.getEmail().equals(MaildId)) {
				
				model.setUserRole(Role);
				userDataSet.set(userDataSet.indexOf(model), model);
				feedBackMessage = "Role of user is altered to "+ Role;
			}
		}
		return feedBackMessage;
	}

	@Override
	public String returnUserRole(String MailId) {
		String feedBackMessage = new String();
		for(GuestModel model:userDataSet) {
			
			if(model.getEmail().equals(MailId)) {
				feedBackMessage  = model.getUserRole();
				
			}
		}
		return feedBackMessage;
		
	}

}
