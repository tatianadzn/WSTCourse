package services;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "person")
@XmlType(propOrder = {"firstName", "lastName", "age", "stateId", "isRecommended"})
public class Person {
    private String firstName;
    private String lastName;
    private Integer age;
    private Integer stateId;
    private Boolean isRecommended;

    public Person() {
    }

    public Person(String firstName, String lastName,
                  Integer age, Integer stateId, Boolean isRecommended) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.stateId = stateId;
        this.isRecommended = isRecommended;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public Integer getAge() {
        return age;
    }
    public Integer getStateId() { return stateId; }
    public Boolean getIsRecommended() { return isRecommended; }
    public void setStateId(Integer stateId) { this.stateId = stateId; }
    public void setIsRecommended(Boolean recommended) { isRecommended = recommended; }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "models.services.Person{first name=" + firstName + ", last name=" + lastName +
                ", age=" + age + ", state id=" + stateId + ", is recommended=" + isRecommended + '}';
    }
}
