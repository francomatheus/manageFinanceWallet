package br.com.manageFinanceWallet.Model.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class OptionForm {

    private String type;
    @NotNull
    private Double priceStock;
    @NotNull
    private Double priceStrike;
    @NotNull
    private Double time;
    @NotNull
    private Double volatility;
    @NotNull
    private Double riskFree;
    private Integer sizeYear;

}
