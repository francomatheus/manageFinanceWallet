package br.com.manageFinanceWallet.Service.Impl;

import br.com.manageFinanceWallet.Entity.WalletEntity;
import br.com.manageFinanceWallet.Model.DTO.WalletDTO;
import br.com.manageFinanceWallet.Repository.WalletRepository;
import br.com.manageFinanceWallet.Service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WalletServiceImpl implements WalletService {
    @Autowired
    private WalletRepository walletRepository;

    @Override
    public List<WalletDTO> getAllWallet() {
        return converterListEntityForDTO(walletRepository.findAll());
    }

    private WalletEntity converterDTOForEntity(WalletDTO walletDTO) {
        WalletEntity newWalletEntity = new WalletEntity();
        newWalletEntity.setOperation(walletDTO.getOperation());
        newWalletEntity.setName(walletDTO.getName());
        newWalletEntity.setCodigo(walletDTO.getCodigo());

        return newWalletEntity;
    }

    private List<WalletDTO> converterListEntityForDTO(List<WalletEntity> all) {
        List<WalletDTO> wallets = new ArrayList<>();
        all.forEach(walletEntity -> {
            WalletDTO newWallet = new WalletDTO();
            newWallet.setCodigo(walletEntity.getCodigo());
            newWallet.setName(walletEntity.getName());
            newWallet.setOperation(walletEntity.getOperation());

            wallets.add(newWallet);
        } );

        return wallets;
    }
    
    private WalletDTO converterEntityForDTO(Optional<WalletEntity> all) {
        if (all.isPresent()) {
            WalletDTO wallet = new WalletDTO();

            wallet.setOperation(all.get().getOperation());
            wallet.setCodigo(all.get().getCodigo());
            wallet.setName(all.get().getName());

            return wallet;
        }
        throw new IllegalArgumentException("ID doesn't exist");
    }

}
