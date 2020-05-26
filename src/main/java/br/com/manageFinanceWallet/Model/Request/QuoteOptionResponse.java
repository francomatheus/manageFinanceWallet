package br.com.manageFinanceWallet.Model.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuoteOptionResponse {

    @JsonProperty("BizSts")
    public BizSts bizSts;
    @JsonProperty("Msg")
    public Msg msg;
    @JsonProperty("TradgFlr")
    public TradgFlr tradgFlr;

    @Override
    public String toString() {
        return "QuoteOptionResponse{" +
                "bizSts=" + bizSts +
                ", msg=" + msg +
                ", tradgFlr=" + tradgFlr +
                '}';
    }
}

@Getter
@Setter
class BizSts {

    @JsonProperty("cd")
    public String cd;

    @Override
    public String toString() {
        return "BizSts{" +
                "cd='" + cd + '\'' +
                '}';
    }
}

@Getter
@Setter
class LstQtn {

    @JsonProperty("closPric")
    public Double closPric;
    @JsonProperty("dtTm")
    public String dtTm;
    @JsonProperty("prcFlcn")
    public Double prcFlcn;

    @Override
    public String toString() {
        return "LstQtn{" +
                "closPric=" + closPric +
                ", dtTm='" + dtTm + '\'' +
                ", prcFlcn=" + prcFlcn +
                '}';
    }
}

@Getter
@Setter
class Msg {

    @JsonProperty("dtTm")
    public String dtTm;

    @Override
    public String toString() {
        return "Msg{" +
                "dtTm='" + dtTm + '\'' +
                '}';
    }
}
@Getter
@Setter
class Scty {

    @JsonProperty("lstQtn")
    public List<LstQtn> lstQtn = null;
    @JsonProperty("symb")
    public String symb;

    @Override
    public String toString() {
        return "Scty{" +
                "lstQtn=" + lstQtn +
                ", symb='" + symb + '\'' +
                '}';
    }
}
@Getter
@Setter
class TradgFlr {

    @JsonProperty("TradgFlrSts")
    public TradgFlrSts tradgFlrSts;
    @JsonProperty("date")
    public String date;
    @JsonProperty("scty")
    public Scty scty;

    @Override
    public String toString() {
        return "TradgFlr{" +
                "tradgFlrSts=" + tradgFlrSts +
                ", date='" + date + '\'' +
                ", scty=" + scty +
                '}';
    }
}

@Getter
@Setter
class TradgFlrSts {
    public String algo;

    @Override
    public String toString() {
        return "TradgFlrSts{" +
                "algo='" + algo + '\'' +
                '}';
    }
}
