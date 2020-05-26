package br.com.manageFinanceWallet.Service.Impl;

import br.com.manageFinanceWallet.Model.Request.QuoteOptionResponse;
import br.com.manageFinanceWallet.Service.QuoteOptionService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class QuoteOptionServiceImpl implements QuoteOptionService {

    private String URL = "http://cotacao.b3.com.br/mds/api/v1/DailyFluctuationHistory/{option}";

    @Override
    public QuoteOptionResponse getQuoteOption(String option){

        URI uri = UriComponentsBuilder
                .fromUriString(URL)
                .buildAndExpand(option)
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity entity = new HttpEntity(headers);
        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<QuoteOptionResponse> exchange = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    entity,
                    new ParameterizedTypeReference<QuoteOptionResponse>() {
                    }
            );

            return exchange.getBody();
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }

}
