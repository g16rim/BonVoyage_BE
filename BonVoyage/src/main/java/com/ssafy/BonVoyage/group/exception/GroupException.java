package com.ssafy.BonVoyage.group.exception;

public class GroupException extends Exception{

    private final GroupExceptionType groupExceptionType;

    public GroupException(GroupExceptionType groupExceptionType) {
        this.groupExceptionType = groupExceptionType;
    }
}
