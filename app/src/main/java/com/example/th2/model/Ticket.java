package com.example.th2.model;

public class Ticket {
    private int id;
    private String name;
    private String departure;
    private String time;
    private String luggage;
    private String service;

    public Ticket() {
    }

    public Ticket(int id, String name, String departure, String time, String luggage, String service) {
        this.id = id;
        this.name = name;
        this.departure = departure;
        this.time = time;
        this.luggage = luggage;
        this.service = service;
    }

    public Ticket(String name, String departure, String time, String luggage, String service) {
        this.name = name;
        this.departure = departure;
        this.time = time;
        this.luggage = luggage;
        this.service = service;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLuggage() {
        return luggage;
    }

    public void setLuggage(String luggage) {
        this.luggage = luggage;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
