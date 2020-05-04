package br.com.manageFinanceWallet.Entity;

import br.com.manageFinanceWallet.Entity.Enum.BrokersEnum;
import br.com.manageFinanceWallet.Entity.Enum.OperationTypeEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
@Entity
public class OperationEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotNull
    private String stock;

    private LocalDate dateOpen;

    private LocalDate dateClose;

    @NotNull
    private Float price;

    @NotNull
    private Integer quantity;

    @NotNull
    @Enumerated(EnumType.STRING)
    private OperationTypeEnum operationType;

    @NotNull
    @Enumerated(EnumType.STRING)
    private BrokersEnum broker;

}
