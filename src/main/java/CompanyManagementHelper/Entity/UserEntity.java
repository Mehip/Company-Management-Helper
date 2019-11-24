package CompanyManagementHelper.Entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "uzytkownicy")
public class UserEntity {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "surname")
  private String surname;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

  @Column(name = "pesel_nip")
  private String pesel;

  @Column(name = "date_of_birth")
  private LocalDate dateOfBirth;

  @Column(name = "city")
  private String city;

  @Column(name = "street")
  private String street;

  @Column(name = "house_number")
  private String houseNumber;

  @Column(name = "flat_number")
  private String flatNumber;

  @Column(name = "postal_code")
  private String postalCode;

  @Column(name = "role")
  private String role;

  @Column(name = "salary")
  private Double salary;

  @Column(name = "bank_account_number")
  private String bankAccountNumber;

  @Column(name = "job_time")
  private Double jobTime;

  @Column(name = "work_since")
  private LocalDate workSince;

  @Column(name = "vacation")
  private Boolean vacation;

  public UserEntity(String name, String surname, String email, String password, String pesel, LocalDate dateOfBirth, String city, String street, String houseNumber, String flatNumber, String postalCode, String role, Double salary, String bankAccountNumber, Double jobTime, LocalDate workSince) {
    this.name = name;
    this.surname = surname;
    this.email = email;
    this.password = password;
    this.pesel = pesel;
    this.dateOfBirth = dateOfBirth;
    this.city = city;
    this.street = street;
    this.houseNumber = houseNumber;
    this.flatNumber = flatNumber;
    this.postalCode = postalCode;
    this.role = role;
    this.salary = salary;
    this.bankAccountNumber = bankAccountNumber;
    this.jobTime = jobTime;
    this.workSince = workSince;
    this.vacation = false;
  }

  public UserEntity() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPesel() {
    return pesel;
  }

  public void setPesel(String pesel) {
    this.pesel = pesel;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getHouseNumber() {
    return houseNumber;
  }

  public void setHouseNumber(String houseNumber) {
    this.houseNumber = houseNumber;
  }

  public String getFlatNumber() {
    return flatNumber;
  }

  public void setFlatNumber(String flatNumber) {
    this.flatNumber = flatNumber;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public Double getSalary() {
    return salary;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }

  public String getBankAccountNumber() {
    return bankAccountNumber;
  }

  public void setBankAccountNumber(String bankAccountNumber) {
    this.bankAccountNumber = bankAccountNumber;
  }

  public Double getJobTime() {
    return jobTime;
  }

  public void setJobTime(Double jobTime) {
    this.jobTime = jobTime;
  }

  public LocalDate getWorkSince() {
    return workSince;
  }

  public void setWorkSince(LocalDate workSince) {
    this.workSince = workSince;
  }
}
