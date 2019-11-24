package CompanyManagementHelper.Service;

import CompanyManagementHelper.Properties.UserProperties;

import static CompanyManagementHelper.Converter.UserConverterToProperties.convertToUserEntity;
import static CompanyManagementHelper.Utils.HibernateUtils.delete;

public class WorkerDialogService {

  public void deleteUser(UserProperties userProperties){
    delete(userProperties.getId());
  }
}
