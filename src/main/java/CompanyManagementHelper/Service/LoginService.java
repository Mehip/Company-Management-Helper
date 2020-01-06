package CompanyManagementHelper.Service;

import CompanyManagementHelper.Entity.UserEntity;

import static CompanyManagementHelper.Utils.HibernateUtils.findUserByEmail;

public class LoginService {

  public boolean login(String email, String password) {
    UserEntity userEntity = findUserByEmail(email);
    return email.equals(userEntity.getEmail()) && password.hashCode() == Integer.parseInt(userEntity.getPassword());
  }

  public UserEntity profilInfo(String email){
    return findUserByEmail(email);
  }
}
