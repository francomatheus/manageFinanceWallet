package br.com.manageFinanceWallet.Resource;

import br.com.manageFinanceWallet.Model.DTO.WalletDTO;
import br.com.manageFinanceWallet.Service.Impl.WalletServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/wallet")
public class WalletResource {

    @Autowired
    private WalletServiceImpl walletService;

    @GetMapping
    public ResponseEntity<List<WalletDTO>> getAllWallets(){
        return ResponseEntity.status(HttpStatus.OK).body(walletService.getAllWallet());
    }
}
