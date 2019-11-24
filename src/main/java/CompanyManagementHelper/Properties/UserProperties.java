package CompanyManagementHelper.Properties;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UserProperties {

  IntegerProperty id = new SimpleIntegerProperty();
  StringProperty name = new SimpleStringProperty();
  StringProperty surname = new SimpleStringProperty();
  StringProperty email = new SimpleStringProperty();
  StringProperty password = new SimpleStringProperty();
  StringProperty pesel = new SimpleStringProperty();
  StringProperty dateOfBirth = new SimpleStringProperty();
  StringProperty city = new SimpleStringProperty();
  StringProperty street = new SimpleStringProperty();
  StringProperty houseNumber = new SimpleStringProperty();
  StringProperty flatNumber = new SimpleStringProperty();
  StringProperty postalCode = new SimpleStringProperty();
  StringProperty role = new SimpleStringProperty();
  StringProperty salary = new SimpleStringProperty();
  StringProperty bankAccountNumber = new SimpleStringProperty();
  StringProperty jobTime = new SimpleStringProperty();
  StringProperty workSince = new SimpleStringProperty();

  public int getId() {
    return id.get();
  }

  public IntegerProperty idProperty() {
    return id;
  }

  public void setId(int id) {
    this.id.set(id);
  }

  public String getName() {
    return name.get();
  }

  public StringProperty nameProperty() {
    return name;
  }

  public void setName(String name) {
    this.name.set(name);
  }

  public String getSurname() {
    return surname.get();
  }

  public StringProperty surnameProperty() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname.set(surname);
  }

  public String getEmail() {
    return email.get();
  }

  public StringProperty emailProperty() {
    return email;
  }

  public void setEmail(String email) {
    this.email.set(email);
  }

  public String getPassword() {
    return password.get();
  }

  public StringProperty passwordProperty() {
    return password;
  }

  public void setPassword(String password) {
    this.password.set(password);
  }

  public String getPesel() {
    return pesel.get();
  }

  public StringProperty peselProperty() {
    return pesel;
  }

  public void setPesel(String pesel) {
    this.pesel.set(pesel);
  }

  public String getDateOfBirth() {
    return dateOfBirth.get();
  }

  public StringProperty dateOfBirthProperty() {
    return dateOfBirth;
  }

  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth.set(dateOfBirth);
  }

  public String getCity() {
    return city.get();
  }

  public StringProperty cityProperty() {
    return city;
  }

  public void setCity(String city) {
    this.city.set(city);
  }

  public String getStreet() {
    return street.get();
  }

  public StringProperty streetProperty() {
    return street;
  }

  public void setStreet(String street) {
    this.street.set(street);
  }

  public String getHouseNumber() {
    return houseNumber.get();
  }

  public StringProperty houseNumberProperty() {
    return houseNumber;
  }

  public void setHouseNumber(String houseNumber) {
    this.houseNumber.set(houseNumber);
  }

  public String getFlatNumber() {
    return flatNumber.get();
  }

  public StringProperty flatNumberProperty() {
    return flatNumber;
  }

  public void setFlatNumber(String flatNumber) {
    this.flatNumber.set(flatNumber);
  }

  public String getPostalCode() {
    return postalCode.get();
  }

  public StringProperty postalCodeProperty() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode.set(postalCode);
  }

  public String getRole() {
    return role.get();
  }

  public StringProperty roleProperty() {
    return role;
  }

  public void setRole(String role) {
    this.role.set(role);
  }

  public String getSalary() {
    return salary.get();
  }

  public StringProperty salaryProperty() {
    return salary;
  }

  public void setSalary(String salary) {
    this.salary.set(salary);
  }

  public String getBankAccountNumber() {
    return bankAccountNumber.get();
  }

  public StringProperty bankAccountNumberProperty() {
    return bankAccountNumber;
  }

  public void setBankAccountNumber(String bankAccountNumber) {
    this.bankAccountNumber.set(bankAccountNumber);
  }

  public String getJobTime() {
    return jobTime.get();
  }

  public StringProperty jobTimeProperty() {
    return jobTime;
  }

  public void setJobTime(String jobTime) {
    this.jobTime.set(jobTime);
  }

  public String getWorkSince() {
    return workSince.get();
  }

  public StringProperty workSinceProperty() {
    return workSince;
  }

  public void setWorkSince(String workSince) {
    this.workSince.set(workSince);
  }
}
