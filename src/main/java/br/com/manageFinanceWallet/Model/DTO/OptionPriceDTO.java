package br.com.manageFinanceWallet.Model.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OptionPriceDTO {

    private Double priceOption;
    private Double delta;
    private Double teta;
    private Double gama;
    private Double vega;
    private Double rho;

}
