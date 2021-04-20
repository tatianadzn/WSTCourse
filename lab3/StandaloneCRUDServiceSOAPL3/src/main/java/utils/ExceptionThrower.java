package utils;

import errors.*;

public class ExceptionThrower {
    public static void throwIllegalIdException(String msg1, String msg2) throws IllegalIdException {
        PersonServiceFault fault = PersonServiceFault.defaultInstance();
        fault.setMessage(msg1);
        throw new IllegalIdException(msg2, fault);
    }

    public static void throwIllegalNameException(String msg1, String msg2) throws IllegalNameException {
        PersonServiceFault fault = PersonServiceFault.defaultInstance();
        fault.setMessage(msg1);
        throw new IllegalNameException(msg2, fault);
    }

    public static void throwIllegalAgeException(String msg1, String msg2) throws IllegalAgeException {
        PersonServiceFault fault = PersonServiceFault.defaultInstance();
        fault.setMessage(msg1);
        throw new IllegalAgeException(msg2, fault);
    }

    public static void throwIllegalStateIdException(String msg1, String msg2) throws IllegalStateIdException {
        PersonServiceFault fault = PersonServiceFault.defaultInstance();
        fault.setMessage(msg1);
        throw new IllegalStateIdException(msg2, fault);
    }

    public static void throwIllegalRecommendedStatusException(String msg1, String msg2) throws IllegalRecommendedStatusException {
        PersonServiceFault fault = PersonServiceFault.defaultInstance();
        fault.setMessage(msg1);
        throw new IllegalRecommendedStatusException(msg2, fault);
    }


    public static void throwIllegalCreatePersonSetException(String msg1, String msg2) throws IllegalUpdatePersonSetException {
        PersonServiceFault fault = PersonServiceFault.defaultInstance();
        fault.setMessage(msg1);
        throw new IllegalUpdatePersonSetException(msg2, fault);
    }


    public static void throwBadQueryResponseException(String msg1, String msg2) throws BadQueryResponseException {
        PersonServiceFault fault = PersonServiceFault.defaultInstance();
        fault.setMessage(msg1);
        throw new BadQueryResponseException(msg2, fault);
    }

    public static void throwSQLException(String msg1, String msg2) throws SQLException {
        PersonServiceFault fault = PersonServiceFault.defaultInstance();
        fault.setMessage(msg1);
        throw new SQLException(msg2, fault);
    }



}
