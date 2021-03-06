package com.resumeweb.entity;

public class BaseInfo {
    private int baseInfoId;
    private int userId;
    private String name;
    private String gender;
    private String birthDate;
    private String highestEdu;
    private String phoneNumber;
    private String country;
    private String imagePath;
    private String idNumber;
    private String marriageStatus;
    private String ethnicGroup;
    private String email;
    private String simpleIntroduction;

    public int getBaseInfoId() {
        return baseInfoId;
    }

    public void setBaseInfoId(int baseInfoId) {
        this.baseInfoId = baseInfoId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getHighestEdu() {
        return highestEdu;
    }

    public void setHighestEdu(String highestEdu) {
        this.highestEdu = highestEdu;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getMarriageStatus() {
        return marriageStatus;
    }

    public void setMarriageStatus(String marriageStatus) {
        this.marriageStatus = marriageStatus;
    }

    public String getEthnicGroup() {
        return ethnicGroup;
    }

    public void setEthnicGroup(String ethnicGroup) {
        this.ethnicGroup = ethnicGroup;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSimpleIntroduction() {
        return simpleIntroduction;
    }

    public void setSimpleIntroduction(String simpleIntroduction) {
        this.simpleIntroduction = simpleIntroduction;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"baseInfoId\":")
                .append(baseInfoId);
        sb.append(",\"userId\":")
                .append(userId);
        sb.append(",\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"gender\":\"")
                .append(gender).append('\"');
        sb.append(",\"birthDate\":\"")
                .append(birthDate).append('\"');
        sb.append(",\"highestEdu\":\"")
                .append(highestEdu).append('\"');
        sb.append(",\"phoneNumber\":\"")
                .append(phoneNumber).append('\"');
        sb.append(",\"country\":\"")
                .append(country).append('\"');
        sb.append(",\"imagePath\":\"")
                .append(imagePath).append('\"');
        sb.append(",\"idNumber\":\"")
                .append(idNumber).append('\"');
        sb.append(",\"marriageStatus\":\"")
                .append(marriageStatus).append('\"');
        sb.append(",\"ethnicGroup\":\"")
                .append(ethnicGroup).append('\"');
        sb.append(",\"email\":\"")
                .append(email).append('\"');
        sb.append(",\"simpleIntroduction\":\"")
                .append(simpleIntroduction).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
