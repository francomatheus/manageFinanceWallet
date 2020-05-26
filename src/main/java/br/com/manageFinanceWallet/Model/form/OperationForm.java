package br.com.manageFinanceWallet.Model.form;

import br.com.manageFinanceWallet.Entity.Enum.BrokersEnum;
import br.com.manageFinanceWallet.Entity.Enum.OperationTypeEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class OperationForm {

    private String stock;

    private LocalDate dateOpen;

    private LocalDate dateClose;

    private Float price;

    private Integer quantity;

    private OperationTypeEnum operationType;

    private BrokersEnum broker;

}
