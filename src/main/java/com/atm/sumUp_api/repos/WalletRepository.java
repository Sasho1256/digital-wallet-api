package com.atm.sumUp_api.repos;

import com.atm.sumUp_api.models.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {}
