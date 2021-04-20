package utils;

import errors.*;
import models.Person;
import models.PersonWithID;

public class PersonFieldsChecker {
    private static final int NUM_OF_STATES = 50;
    private static final int CREDIT_AGE_LOWER_BORDER = 18;
    private static final int CREDIT_AGE_UPPER_BORDER = 60;

    public static void checkAllFieldsNotNull(Person person) throws IllegalNameException, IllegalAgeException,
            IllegalStateIdException, IllegalRecommendedStatusException, IllegalIdException {
        if (person instanceof PersonWithID){
            checkIdNotNull(((PersonWithID) person).getId());
        }
        checkFirstNameNotNull(person.getFirstName());
        checkLastNameNotNull(person.getLastName());
        checkAgeNotNull(person.getAge());
        checkStateIdNotNull(person.getStateId());
        checkRecommendedStateNotNull(person.getIsRecommended());
    }

    public static void checkAllFieldsCouldBeNull(Person person) throws IllegalNameException, IllegalAgeException,
            IllegalStateIdException, IllegalIdException {
        if (person instanceof PersonWithID){
            checkIdCouldBeNull(((PersonWithID) person).getId());
        }
        checkFirstNameCouldBeNull(person.getFirstName());
        checkLastNameCouldBeNull(person.getLastName());
        checkAgeCouldBeNull(person.getAge());
        checkStateIdCouldBeNull(person.getStateId());
    }

    public static void checkIdNotNull(Integer id) throws IllegalIdException {
        if (id == null || isNotCorrectId(id)) {
            ExceptionThrower.throwIllegalIdException("id cannot be null or not positive",
                    "person ID is not specified");
        }
    }

    private static void checkIdCouldBeNull(Integer id) throws IllegalIdException {
        if (id != null && isNotCorrectId(id)) {
            ExceptionThrower.throwIllegalIdException("id cannot be not positive",
                    "person ID is not specified");
        }
    }

    private static void checkFirstNameNotNull(String name) throws IllegalNameException {
        if (name == null || isNotCorrectName(name)) {
            ExceptionThrower.throwIllegalNameException("person firstName cannot be null or empty",
                    "person first name is not specified");
        }
    }

    private static void checkFirstNameCouldBeNull(String name) throws IllegalNameException {
        if (name != null && isNotCorrectName(name)) {
            ExceptionThrower.throwIllegalNameException("person firstName cannot be empty",
                    "person first name is not specified");
        }
    }

    private static void checkLastNameNotNull(String name) throws IllegalNameException {
        if (name == null || isNotCorrectName(name)){
            ExceptionThrower.throwIllegalNameException("person lastName cannot be null or empty",
                    "person last name is not specified");
        }
    }

    private static void checkLastNameCouldBeNull(String name) throws IllegalNameException {
        if (name != null && isNotCorrectName(name)){
            ExceptionThrower.throwIllegalNameException("person lastName cannot empty",
                    "person last name is not specified");
        }
    }

    private static void checkAgeNotNull(Integer age) throws IllegalAgeException {
        if (age == null || isNotCorrectAge(age)) {
            ExceptionThrower.throwIllegalAgeException("person age cannot be null or less than " + CREDIT_AGE_LOWER_BORDER +
                            " or bigger than " + CREDIT_AGE_UPPER_BORDER,
                    "person age is not specified");
        }
    }

    private static void checkAgeCouldBeNull(Integer age) throws IllegalAgeException {
        if (age != null && isNotCorrectAge(age)) {
            ExceptionThrower.throwIllegalAgeException("person age cannot be less than " + CREDIT_AGE_LOWER_BORDER +
                            " or bigger than " + CREDIT_AGE_UPPER_BORDER,
                    "person age is not specified");
        }
    }

    private static void checkStateIdNotNull(Integer stateId) throws IllegalStateIdException {
        if (stateId == null || isNotCorrectStateId(stateId)){
            ExceptionThrower.throwIllegalStateIdException("person state id cannot be null or not positive or " +
                            "greater than current number of states in USA: " + NUM_OF_STATES,
                    "person state id is not specified");
        }
    }

    private static void checkStateIdCouldBeNull(Integer stateId) throws IllegalStateIdException {
        if (stateId != null && isNotCorrectStateId(stateId)){
            ExceptionThrower.throwIllegalStateIdException("person state id cannot be not positive or " +
                            "greater than current number of states in USA: " + NUM_OF_STATES,
                    "person state id is not specified");
        }
    }

    private static void checkRecommendedStateNotNull(Boolean isRecommended) throws IllegalRecommendedStatusException {
        if (isRecommended == null){
            ExceptionThrower.throwIllegalRecommendedStatusException("person recommended status cannot be null",
                    "person state id is not specified");
        }
    }

    private static boolean isNotCorrectId(int id) {
        return id <= 0;
    }

    private static boolean isNotCorrectName(String name){
        return name.trim().isEmpty();
    }

    private static boolean isNotCorrectAge(int age){
        return (age <= CREDIT_AGE_LOWER_BORDER || age >= CREDIT_AGE_UPPER_BORDER);
    }

    private static boolean isNotCorrectStateId(int stateId){
        return (stateId <= 0 || stateId > NUM_OF_STATES);
    }
}
