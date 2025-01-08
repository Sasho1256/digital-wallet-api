package com.atm.sumUp_api.models;

import jakarta.persistence.*;

@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private Double balance;

    public Wallet() {
        this.balance = 0.0;
    }

    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public Double getBalance(){
        return this.balance;
    }
    public void setBalance(Double balance){
        this.balance = balance;
    }
}
