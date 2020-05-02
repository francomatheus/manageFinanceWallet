package br.com.manageFinanceWallet.Entity;

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
public class Ativo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotNull
    private String name;

    private LocalDate dateOpen;

    private LocalDate dateClose;

    @NotNull
    private Float price;

    @NotNull
    private Integer quantity;

    @Enumerated(EnumType.STRING)
    private OperationTypeEnum operationType;

}
