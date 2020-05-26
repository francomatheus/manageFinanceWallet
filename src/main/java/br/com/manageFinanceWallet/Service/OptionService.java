package br.com.manageFinanceWallet.Service;

import br.com.manageFinanceWallet.Model.DTO.OptionPriceDTO;
import br.com.manageFinanceWallet.Model.form.OptionForm;

public interface OptionService {

    OptionPriceDTO getPriceOption(OptionForm optionForm);

}
