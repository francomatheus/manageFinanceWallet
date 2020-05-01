package br.com.manageFinanceWallet.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table()
public class Ativo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String name;

    private LocalDate dateOpen;

    private LocalDate dateClose;

    private Float price;

    private Integer quantity;

}
