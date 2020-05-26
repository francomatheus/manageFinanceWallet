package br.com.manageFinanceWallet.Service;

import br.com.manageFinanceWallet.Model.Request.QuoteOptionResponse;

public interface QuoteOptionService {

    QuoteOptionResponse getQuoteOption(String option);

}
