package com.restful.EEServiceRESTful;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "person")
public class PersonWithID extends Person {
    private Integer id;

    public PersonWithID(Integer id, String firstName, String lastName,
                        Integer age, Integer stateId, Boolean isRecommended){
        super(firstName, lastName, age, stateId, isRecommended);
        this.id = id;
    }

    public PersonWithID() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    @Override
    public String toString() {
        return "models.PersonWithID{id=" + id + ", first name=" + super.getFirstName() + ", last name=" + super.getLastName() +
                ", age=" + super.getAge() + ", state id=" + super.getStateId() + ", is recommended=" + super.getIsRecommended() + '}';
    }
}
