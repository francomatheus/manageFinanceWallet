package br.com.manageFinanceWallet.Resource;

import br.com.manageFinanceWallet.Model.DTO.OptionPriceDTO;
import br.com.manageFinanceWallet.Model.Request.QuoteOptionResponse;
import br.com.manageFinanceWallet.Model.form.OptionForm;
import br.com.manageFinanceWallet.Service.Impl.OptionServiceImpl;
import br.com.manageFinanceWallet.Service.Impl.QuoteOptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/options")
public class OptionResource {

    @Autowired
    private OptionServiceImpl optionService;

    @Autowired
    private QuoteOptionServiceImpl quoteOptionService;

    @PostMapping
    public ResponseEntity<?> getPriceOption(@RequestBody OptionForm optionForm){

        OptionPriceDTO priceOption = optionService.getPriceOption(optionForm);

        return ResponseEntity.status(HttpStatus.OK).body(priceOption);
    }

    @GetMapping("/quote/{option}")
    public ResponseEntity<QuoteOptionResponse> getQuoteOption(@PathVariable String option){

        QuoteOptionResponse quoteOption = quoteOptionService.getQuoteOption(option);

        return ResponseEntity.status(HttpStatus.OK).body(quoteOption);
    }
}
