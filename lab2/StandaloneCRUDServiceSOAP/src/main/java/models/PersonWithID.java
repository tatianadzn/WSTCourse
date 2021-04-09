package models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "person")
public class PersonWithID extends Person {
    private Integer id;

    public PersonWithID(int id, String firstName, String lastName,
                        int age, int stateId, Boolean isRecommended){
        super(firstName, lastName, age, stateId, isRecommended);
        this.id = id;
    }

    public PersonWithID() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
}
