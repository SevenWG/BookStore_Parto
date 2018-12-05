package com.team404.bookstore.service;

import java.sql.Timestamp;
/*
 * Implementation of Facade Pattern
 * */

public interface TimeGeneratorInterface {
    public String GetOrderGenerationTime();
    public Timestamp GetTimestampValue();
}
