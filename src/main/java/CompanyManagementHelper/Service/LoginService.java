package CompanyManagementHelper.Service;

import CompanyManagementHelper.Entity.UserEntity;

import static CompanyManagementHelper.Utils.HibernateUtils.findUserByEmail;

public class LoginService {

  public boolean login(String email, String password) {
    //TODO Hashowanie hasła
    UserEntity userEntity = findUserByEmail(email);
    if (email.equals(userEntity.getEmail()) && password.equals(userEntity.getPassword())) {
      return true;
    } else {
      return false;
    }
  }

  public UserEntity profilInfo(String email){
    return findUserByEmail(email);
  }
}
