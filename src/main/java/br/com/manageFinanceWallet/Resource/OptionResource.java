package br.com.manageFinanceWallet.Resource;

import br.com.manageFinanceWallet.Model.DTO.OptionPriceDTO;
import br.com.manageFinanceWallet.Model.Request.OptionRequest;
import br.com.manageFinanceWallet.Service.Impl.OptionServiceImpl;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/options")
public class OptionResource {

    @Autowired
    private OptionServiceImpl optionService;

    @PostMapping
    public ResponseEntity<?> getPriceOption(@RequestBody OptionRequest optionRequest){

        OptionPriceDTO priceOption = optionService.getPriceOption(optionRequest);

        return ResponseEntity.status(HttpStatus.OK).body(priceOption);
    }
}
