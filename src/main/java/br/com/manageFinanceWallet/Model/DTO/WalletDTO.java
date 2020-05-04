package br.com.manageFinanceWallet.Model.DTO;

import br.com.manageFinanceWallet.Entity.OperationEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class WalletDTO {

    private Long codigo;

    private String name;

    private List<OperationEntity> operation;
}
