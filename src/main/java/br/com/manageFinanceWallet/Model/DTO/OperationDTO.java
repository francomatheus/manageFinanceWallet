package br.com.manageFinanceWallet.Model.DTO;

import br.com.manageFinanceWallet.Entity.Enum.BrokersEnum;
import br.com.manageFinanceWallet.Entity.Enum.OperationTypeEnum;
import br.com.manageFinanceWallet.Entity.WalletEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class OperationDTO {

    private Long codigo;

    private String stock;

    private LocalDate dateOpen;

    private LocalDate dateClose;

    private Float price;

    private Integer quantity;

    private OperationTypeEnum operationType;

    private BrokersEnum broker;

    private WalletEntity walletEntity;
}
