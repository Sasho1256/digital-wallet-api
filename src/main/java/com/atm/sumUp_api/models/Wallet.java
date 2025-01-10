package com.atm.sumUp_api.models;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private BigDecimal balance;

    public Wallet() {
        this.balance = new BigDecimal("0.0");
    }

    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public BigDecimal getBalance(){
        return this.balance;
    }
    public void setBalance(BigDecimal balance){
        this.balance = balance;
    }
}
