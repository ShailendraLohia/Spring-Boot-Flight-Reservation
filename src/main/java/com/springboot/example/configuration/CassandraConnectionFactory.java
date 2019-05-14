package com.springboot.example.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;

public class CassandraConnectionFactory {

    @Autowired
    CassandraProperties cassandraProperties;

    CassandraProperties activeProperties;

    private void setActiveProperty() {
        activeProperties = cassandraProperties;
    }
    public CassandraProperties getProperties() {
        if (activeProperties == null) setActiveProperty();
        return activeProperties;
    }



}
