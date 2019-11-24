package CompanyManagementHelper.Service;

import CompanyManagementHelper.Entity.UserEntity;

import static CompanyManagementHelper.Utils.HibernateUtils.findUserByEmail;

public class MyProfilService {

  public UserEntity getMyProfilInfo(String email){
    return findUserByEmail(email);
  }
}
