package br.com.manageFinanceWallet.Service;

import br.com.manageFinanceWallet.Model.DTO.WalletDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface WalletService {

    List<WalletDTO> getAllWallet();

}
