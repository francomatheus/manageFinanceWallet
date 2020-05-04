package br.com.manageFinanceWallet.Repository;

import br.com.manageFinanceWallet.Entity.OperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<OperationEntity, Long> {

}
