package com.cenfotec.examen.post.post.enums;

public enum Status {
    ACTIVE(1),
    INACTIVE(0);
    private final int status;

    private Status(int status) {
        this.status = status;
    }
}
