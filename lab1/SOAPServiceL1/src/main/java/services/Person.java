package services;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private int stateId;
    private boolean isRecommended;

    public Person() {
    }

    public Person(int id, String firstName, String lastName, int age, int stateId, boolean isRecommended) {
        this.id = id;
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
    public int getAge() {
        return age;
    }
    public int getId() { return id; }
    public int getStateId() { return stateId; }
    public boolean getIsRecommended() { return isRecommended; }
    public void setId(int id) { this.id = id; }
    public void setStateId(int stateId) { this.stateId = stateId; }
    public void setIsRecommended(boolean recommended) { isRecommended = recommended; }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "services.Person{" + "id =" + id + ", first name=" + firstName + ", last name=" + lastName + ", age=" + age + ", state id=" + stateId + ", is recommended=" + isRecommended + '}';
    }
}
