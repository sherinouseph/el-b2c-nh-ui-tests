//package com.englishtown.newhouse.school.beanandenum;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//   // should use SchoolStudentBean
//public class ExtendedProfileDetails extends StudentProfileDetails {
//
//    private static final Logger logger = LoggerFactory.getLogger(ExtendedProfileDetails.class);
//
//    //protected String englishLevel;    protected String gender;    protected String age ;    protected String livingIn ;
//   // protected String nativeLanguage ;    protected String industry ;    protected String chatAccessibility ;
//    protected String firstName;
//    protected String lastName;
//    protected String email;
//    protected String password;
//    protected String birthdayMonthDateYear;  //January_1_1977
//    protected String viewAndSearchableBy; // Viewable and searchable by Everyone, friends
//    protected String mobile;
//    protected String homePhone;
//    protected String billAddress1;
//    protected String city;
//    protected String postCode;
//    protected String country;
//
//
//    public ExtendedProfileDetails(){};
//
//    public ExtendedProfileDetails(String firstName, String lastName, String email, String englishLevel, String gender, String age, String livingIn, String nativeLanguage,
//                                  String industry, String chatAccessibility) {
//        super(englishLevel, gender, age, livingIn, nativeLanguage, industry, chatAccessibility);
//        this.firstName =  firstName;
//        this.lastName = lastName;
//        this.email = email;
//        logger.info("Created Student ....!\n"+this.toString());
//    }
//
//
//    @Override
//    public String toString() {
//        return super.toString() + "\n ExtendedProfileDetails{" +
//                "firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                ", birthdayMonthDateYear='" + birthdayMonthDateYear + '\'' +
//                ", viewAndSearchableBy='" + viewAndSearchableBy + '\'' +
//                ", mobile='" + mobile + '\'' +
//                ", homePhone='" + homePhone + '\'' +
//                ", billAddress1='" + billAddress1 + '\'' +
//                ", city='" + city + '\'' +
//                ", postCode='" + postCode + '\'' +
//                ", country='" + country + '\'' +
//                '}';
//    }
//
//    //----------
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getBirthdayMonthDateYear() {
//        return birthdayMonthDateYear;
//    }
//
//    public void setBirthdayMonthDateYear(String birthdayMonthDateYear) {
//        this.birthdayMonthDateYear = birthdayMonthDateYear;
//    }
//
//    public String getViewAndSearchableBy() {
//        return viewAndSearchableBy;
//    }
//
//    public void setViewAndSearchableBy(String viewAndSearchableBy) {
//        this.viewAndSearchableBy = viewAndSearchableBy;
//    }
//
//    public String getMobile() {
//        return mobile;
//    }
//
//    public void setMobile(String mobile) {
//        this.mobile = mobile;
//    }
//
//    public String getHomePhone() {
//        return homePhone;
//    }
//
//    public void setHomePhone(String homePhone) {
//        this.homePhone = homePhone;
//    }
//
//    public String getBillAddress1() {
//        return billAddress1;
//    }
//
//    public void setBillAddress1(String billAddress1) {
//        this.billAddress1 = billAddress1;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getPostCode() {
//        return postCode;
//    }
//
//    public void setPostCode(String postCode) {
//        this.postCode = postCode;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
//
//}