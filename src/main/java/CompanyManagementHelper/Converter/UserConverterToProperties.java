package CompanyManagementHelper.Converter;

import CompanyManagementHelper.Entity.UserEntity;
import CompanyManagementHelper.Properties.UserProperties;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserConverterToProperties {

  public static UserEntity convertToUserEntity(UserProperties userProperties) {
    UserEntity userEntity = new UserEntity();
    userEntity.setId(userProperties.getId());
    userEntity.setName(userProperties.getName());
    userEntity.setSurname(userProperties.getSurname());
    userEntity.setEmail(userProperties.getEmail());
    userEntity.setPassword(userProperties.getPassword());
    userEntity.setPesel(userProperties.getPesel());
    userEntity.setCity(userProperties.getCity());
    userEntity.setStreet(userProperties.getStreet());
    userEntity.setHouseNumber(userProperties.getHouseNumber());
    userEntity.setFlatNumber(userProperties.getFlatNumber());
    userEntity.setPostalCode(userProperties.getPostalCode());
    userEntity.setRole(userProperties.getRole());
    userEntity.setSalary(Double.parseDouble(userProperties.getSalary()));
    userEntity.setBankAccountNumber(userProperties.getBankAccountNumber());
    userEntity.setJobTime(Double.parseDouble(userProperties.getJobTime()));
    userEntity.setDateOfBirth(LocalDate.parse(userProperties.getDateOfBirth(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    userEntity.setWorkSince(LocalDate.parse(userProperties.getWorkSince(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));


    return userEntity;
  }


  public static UserProperties convertToUserProperties(UserEntity userEntity) {
    UserProperties userProperties = new UserProperties();

    userProperties.setId(userEntity.getId());
    userProperties.setName(userEntity.getName());
    userProperties.setSurname(userEntity.getSurname());
    userProperties.setEmail(userEntity.getEmail());
    userProperties.setPassword(userEntity.getPassword());
    userProperties.setPesel(userEntity.getPesel());
    userProperties.setCity(userEntity.getCity());
    userProperties.setStreet(userEntity.getStreet());
    userProperties.setHouseNumber(userEntity.getHouseNumber());
    userProperties.setFlatNumber(userEntity.getFlatNumber());
    userProperties.setPostalCode(userEntity.getPostalCode());
    userProperties.setRole(userEntity.getRole());
    userProperties.setSalary(String.valueOf(userEntity.getSalary()));
    userProperties.setBankAccountNumber(userEntity.getBankAccountNumber());
    userProperties.setJobTime(String.valueOf(userEntity.getJobTime()));

    try {
      userProperties.setDateOfBirth(userEntity.getDateOfBirth().toString());
      userProperties.setWorkSince(userEntity.getWorkSince().toString());
    } catch (NullPointerException e) {
      userProperties.setDateOfBirth("----------");
      userProperties.setWorkSince("----------");
    }

    return userProperties;
  }
}
