package Entities;

import java.io.Serializable;
import java.util.*;

public class Person implements Serializable {
    private final Date birthday;
    private final String firstName;
    private final String surname;
    private final String patronymic;

    Person(){
        birthday = null;
        firstName = null;
        surname = null;
        patronymic = null;
    }

    public Person(Date date, String firstName, String surname, String patronymic){
        if( date == null || firstName == null || surname == null) {
            throw new IllegalArgumentException();
        }

        this.birthday = date;
        this.firstName = firstName;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Person person = (Person) o;
        return Objects.equals(birthday, person.birthday) && Objects.equals(firstName, person.firstName) &&
                Objects.equals(surname, person.surname) && Objects.equals(patronymic, person.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(birthday, firstName, surname, patronymic);
    }

}
