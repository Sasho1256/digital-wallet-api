package com.atm.sumUp_api.controllers;

import com.atm.sumUp_api.models.Wallet;
import com.atm.sumUp_api.services.WalletService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/api/wallets")
public class WalletController {
    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping
    public ResponseEntity<Wallet> createWallet(@RequestParam String username) {
        return ResponseEntity.ok(walletService.createWallet(username));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Wallet> getWallet(@PathVariable Long id) {
        Optional<Wallet> wallet = walletService.getWallet(id);
        return wallet.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/deposit")
    public ResponseEntity<Wallet> deposit(@PathVariable Long id, @RequestParam BigDecimal amount) {
        try {
            return ResponseEntity.ok(walletService.deposit(id, amount));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/withdraw")
    public ResponseEntity<Wallet> withdraw(@PathVariable Long id, @RequestParam BigDecimal amount) {
        try {
            return ResponseEntity.ok(walletService.withdraw(id, amount));
        } catch (RuntimeException e) {
            switch (e.getMessage()) {
                case "Wallet not found":
                    return ResponseEntity.notFound().build();
                default:
                    return ResponseEntity.badRequest().body(null);
            }
        }
    }
}
