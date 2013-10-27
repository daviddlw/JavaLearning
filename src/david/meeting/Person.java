package david.meeting;

import java.util.Calendar;
import java.util.Date;

public class Person {

    private int id;
    private String name;
    private String address;
    private String cellphone;
    private Calendar birth;
    
    public Person() {
	// TODO Auto-generated constructor stub
    }

    public Person(int id, String name, String address, String cellphone,
	    Calendar birth) {
	this.id = id;
	this.name = name;
	this.address = address;
	this.cellphone = cellphone;
	this.birth = birth;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;

    }

    public String getCellphone() {
	return cellphone;
    }

    public void setCellphone(String cellphone) {
	this.cellphone = cellphone;
    }

    public Date getBirth() {
	return birth.getTime();
    }

    public void setBirth(Calendar birth) {
	this.birth = birth;
    }

    @Override
    public String toString() {
	// TODO Auto-generated method stub
	return String.format(
		"¡¾id: %d|name£º%s|address£º%s|cellphone£º%s|birth£º%s ¡¿", id, name,
		address, cellphone, birth.getTime());
    }
}
