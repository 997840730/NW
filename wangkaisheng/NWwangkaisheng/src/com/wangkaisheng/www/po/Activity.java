package com.wangkaisheng.www.po;

import com.wangkaisheng.www.po.Allpo.AllActivity;

import java.util.Date;

/**
 * @author Administrator
 */
public class Activity {
    @AnnotationUser("activity_id")
    private int activity_id;
    @AnnotationUser("activity_name")
    private String activity_name;
    @AnnotationUser("activity_content")
    private String activity_content;
    @AnnotationUser("activity_date")
    private Date activity_date;
    @AnnotationUser("activity_address")
    private String activity_address;
    @AnnotationUser("activity_organizer")
    private String activity_organizer;
    @AnnotationUser("activity_person")
    private String activity_person;
    @AnnotationUser("activity_phone")
    private String activity_phone;
    @AnnotationUser("activity_oid")
    private int activity_oid;

    public Activity() {
    }

    public Activity(String activity_name, String activity_content, Date activity_date, String activity_address, String activity_organizer, String activity_person, String activity_phone, int activity_oid) {
        this.activity_name = activity_name;
        this.activity_content = activity_content;
        this.activity_date = activity_date;
        this.activity_address = activity_address;
        this.activity_organizer = activity_organizer;
        this.activity_person = activity_person;
        this.activity_phone = activity_phone;
        this.activity_oid = activity_oid;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "activity_id=" + activity_id +
                ", activity_name='" + activity_name + '\'' +
                ", activity_content='" + activity_content + '\'' +
                ", activity_date=" + activity_date +
                ", activity_address='" + activity_address + '\'' +
                ", activity_organizer='" + activity_organizer + '\'' +
                ", activity_person='" + activity_person + '\'' +
                ", activity_phone='" + activity_phone + '\'' +
                ", activity_oid=" + activity_oid +
                '}';
    }


    public int getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(int activity_id) {
        this.activity_id = activity_id;
    }

    public String getActivity_name() {
        return activity_name;
    }

    public void setActivity_name(String activity_name) {
        this.activity_name = activity_name;
    }

    public String getActivity_content() {
        return activity_content;
    }

    public void setActivity_content(String activity_content) {
        this.activity_content = activity_content;
    }

    public Date getActivity_date() {
        return activity_date;
    }

    public void setActivity_date(Date activity_date) {
        this.activity_date = activity_date;
    }

    public String getActivity_address() {
        return activity_address;
    }

    public void setActivity_address(String activity_address) {
        this.activity_address = activity_address;
    }

    public String getActivity_organizer() {
        return activity_organizer;
    }

    public void setActivity_organizer(String activity_organizer) {
        this.activity_organizer = activity_organizer;
    }

    public String getActivity_person() {
        return activity_person;
    }

    public void setActivity_person(String activity_person) {
        this.activity_person = activity_person;
    }

    public String getActivity_phone() {
        return activity_phone;
    }

    public void setActivity_phone(String activity_phone) {
        this.activity_phone = activity_phone;
    }

    public int getActivity_oid() {
        return activity_oid;
    }

    public void setActivity_oid(int activity_oid) {
        this.activity_oid = activity_oid;
    }


}
