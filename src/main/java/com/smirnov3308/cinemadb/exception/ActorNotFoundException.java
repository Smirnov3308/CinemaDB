package com.smirnov3308.cinemadb.exception;

public class ActorNotFoundException extends RuntimeException {
    public ActorNotFoundException(Long id) {
        super("Actor id not found : " + id);
    }
}