package com.brainacad.passwordReminder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Record {
    private String site;
    private String login;
    private String password;
    private String recordDate;

    public Record(){
    }

    public Record(String site, String login, String password){
        this.site=site;
        this.login=login;
        this.password=password;
        this.setRecordDate();
    }

    public Record(String site, String login, String password, String date){
        this(site, login, password);
        this.setRecordDate(date);
    }


    public String getRecordDate(){
        return recordDate;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }


    public void setRecordDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss-dd.MM.yyyy");
        this.recordDate = simpleDateFormat.format(new Date());
    }

    //Текст для Site, Login, Password, Created можна взяти з Language для будь-якої мови, але чи треба так робити?
    public String toString(){
        StringBuffer sb=new StringBuffer(100);

        return (sb.append("Site: ").append(site).append('\t').append(" Login: ").append(login).append('\t').append(" Password:").append(password).append('\t').append("Created: ").append(recordDate).toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(site, login, password, recordDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Record)) return false;
        Record record = (Record) o;
        return site.equals(record.site) &&
                login.equals(record.login) &&
                password.equals(record.password) &&
                recordDate.equals(record.recordDate);
    }
}
