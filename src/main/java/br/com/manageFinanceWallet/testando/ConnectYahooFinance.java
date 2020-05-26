package br.com.manageFinanceWallet.testando;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ConnectYahooFinance {


    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        String URL = "https://query1.finance.yahoo.com/v7/finance/download/%5EBVSP?period1=1558128555&period2=1589750955&interval=1d&events=history";
        String acao = "https://query1.finance.yahoo.com/v7/finance/download/BBDC4.SA?period1=1558128752&period2=1589751152&interval=1d&events=history";
        String acao2 =   "https://query2.finance.yahoo.com/v7/finance/quote?formatted=true&crumb=yhRUTwKm6V6&lang=en-US&region=US&symbols=BBDC4.SA&fields=messageBoardId%2ClongName%2CshortName%2CmarketCap%2CunderlyingSymbol%2CunderlyingExchangeSymbol%2CheadSymbolAsString%2CregularMarketPrice%2CregularMarketChange%2CregularMarketChangePercent%2CregularMarketVolume%2Cuuid%2CregularMarketOpen%2CfiftyTwoWeekLow%2CfiftyTwoWeekHigh%2CtoCurrency%2CfromCurrency%2CtoExchange%2CfromExchange&corsDomain=finance.yahoo.com";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(new URI(acao)).GET().build();
        List<String> bbdc4 = new ArrayList<>();
        HttpResponse<String> send = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(send.body());
        String[] split = send.body().split(",");
        System.out.println(split[100]);
        for (String s : split) {
            System.out.println(s);
        }
/*

        ObjectMapper obj = new ObjectMapper();
        Linha linha = obj.readValue(send.body(), Linha.class);

        System.out.println(linha);
*/

    }

    @Getter
    @Setter
    public class Linha{
        private String date;
        private String abertura;
        private String high;
        private String low;
        private String close;
        private String closeAdjust;
        private String volume;
    }

}
