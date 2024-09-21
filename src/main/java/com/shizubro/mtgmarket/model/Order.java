package com.shizubro.mtgmarket.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Table(name = "orders")
public class Order {

    @Id
    private Integer id;

    private LocalDateTime orderDate;
    //customerID

    private String customerEmail;
}
