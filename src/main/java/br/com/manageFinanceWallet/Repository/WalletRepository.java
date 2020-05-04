package br.com.manageFinanceWallet.Repository;

import br.com.manageFinanceWallet.Entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<WalletEntity, Long> {

}
