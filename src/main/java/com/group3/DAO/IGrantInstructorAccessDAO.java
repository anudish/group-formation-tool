package com.group3.DAO;

import java.util.ArrayList;

import com.group3.BusinessModels.GuestModel;

public interface IGrantInstructorAccessDAO {
   ArrayList<GuestModel> returnEligibleUsersList();
}
