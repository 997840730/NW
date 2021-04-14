package com.wangkaisheng.www.po;

/**
 * @author Administrator
 */
public class Organizer {
    @AnnotationUser("organizer_id")
    private int id;
    @AnnotationUser("organizername")
    private String username;
    @AnnotationUser("password")
    private String password;
    @AnnotationUser("associationname")
    private String name;
    @AnnotationUser("personname")
    private String person;
    @AnnotationUser("phone")
    private String phone;
    @AnnotationUser("introduction")
    private String introduction;

    private TimePictures timePictures;

    public TimePictures getTimePictures() {
        return timePictures;
    }

    public void setTimePictures(TimePictures timePictures) {
        this.timePictures = timePictures;
    }

    public Organizer() {
    }

    public Organizer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Organizer(String username, String password, String name, String person, String phone, String introduction) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.person = person;
        this.phone = phone;
        this.introduction = introduction;
    }

    public Organizer(String password, String name, String person, String phone, String introduction) {
        this.password = password;
        this.name = name;
        this.person = person;
        this.phone = phone;
        this.introduction = introduction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }


}
