package br.com.manageFinanceWallet.Service;

import br.com.manageFinanceWallet.Model.DTO.OptionPriceDTO;
import br.com.manageFinanceWallet.Model.Request.OptionRequest;

public interface OptionService {

    OptionPriceDTO getPriceOption(OptionRequest optionRequest);

}
