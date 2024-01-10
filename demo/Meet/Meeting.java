package com.example.demo.Meet;

public class Meeting {

private int duration;
 private String uname,pwd,projectId,meetName,desc,starttime,contact;
 public String getContact() {
	return contact;
}

public void setContact(String contact) {
	this.contact = contact;
}


public int getDuration() {
	return duration;
}

public void setDuration(int duration) {
	this.duration = duration;
}

public String getStarttime() {
	return starttime;
}

public void setStarttime(String starttime) {
	this.starttime = starttime;
}

public String getUname() {
	return uname;
}

public void setUname(String uname) {
	this.uname = uname;
}

public String getPwd() {
	return pwd;
}

public void setPwd(String pwd) {
	this.pwd = pwd;
}

public String getProjectId() {
	return projectId;
}

public void setProjectId(String projectId) {
	this.projectId = projectId;
}

public String getMeetName() {
	return meetName;
}

public void setMeetName(String meetName) {
	this.meetName = meetName;
}

public String getDesc() {
	return desc;
}

public void setDesc(String desc) {
	this.desc = desc;
}

}
