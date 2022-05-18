package Entities;


public class Human {
    private String name;
    private String secondName;
    private String fathersName;
    private int age;
    private Sex sex;

    public Human() {
    }

    public Human(String name, String secondName, String fathersName, int age) {
        this.name = name;
        this.secondName = secondName;
        this.fathersName = fathersName;
        this.age = age;
    }

    public Human(Human human) {
        this(human.getName(), human.getSecondName(), human.getFathersName(), human.getAge());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getFathersName() {
        return fathersName;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Human clone() {

        return new Human(this.getName(), this.getSecondName(), this.getFathersName(), this.getAge());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Human person = (Human) obj;

        if (age != person.age) {
            return false;
        }
        if (!name.equals(person.name)) {
            return false;
        }
        if (!fathersName.equals(person.fathersName)) {
            return false;
        }
        if (!secondName.equals(person.secondName)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
