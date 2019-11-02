package CompanyManagementHelper.Entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "uzytkownicy")
public class UserEntity {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Integer id;

  @Column(name = "imie")
  private String name;

  @Column(name = "nazwisko")
  private String surname;

  @Column(name = "pesel")
  private String pesel;

  @Column(name = "miejscowosc")
  private String city;

  @Column(name = "ulica")
  private String street;

  @Column(name = "nr_budynku")
  private String houseNumber;

  @Column(name = "nr_mieszkania")
  private String flatNumber;

  @Column(name = "kod_pocztowy")
  private String postalCode;

  @Column(name = "stanowisko")
  private String role;

  @Column(name = "wynagrodzenie")
  private Double salary;

  @Column(name = "nr_konta_bankowego")
  private String bankAccountNumber;

  @Column(name = "wielkosc_etatu")
  private Double jobTime;

  public UserEntity(String name, String surname, String pesel, String city, String street, String houseNumber, String flatNumber, String postalCode, String role, Double salary, String bankAccountNumber, Double jobTime) {
    this.name = name;
    this.surname = surname;
    this.pesel = pesel;
    this.city = city;
    this.street = street;
    this.houseNumber = houseNumber;
    this.flatNumber = flatNumber;
    this.postalCode = postalCode;
    this.role = role;
    this.salary = salary;
    this.bankAccountNumber = bankAccountNumber;
    this.jobTime = jobTime;
  }

  public UserEntity() {
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

  public String getPesel() {
    return pesel;
  }

  public void setPesel(String pesel) {
    this.pesel = pesel;
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
}
