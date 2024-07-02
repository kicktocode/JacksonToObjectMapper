package com.example.JacksonObjectMapper;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Car {
   private String type;
   private String colour;

    // Default constructor (required for Jackson)
    public Car() {}


    public Car(String type, String colour) {
        this.type = type;
        this.colour = colour;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Car{" +
                "type='" + type + '\'' +
                ", colour='" + colour + '\'' +
                '}';
    }
}
