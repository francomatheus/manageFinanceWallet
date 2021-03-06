package br.com.manageFinanceWallet.Service.Impl;

import br.com.manageFinanceWallet.Model.DTO.OptionPriceDTO;
import br.com.manageFinanceWallet.Model.form.OptionForm;
import br.com.manageFinanceWallet.Service.OptionService;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.springframework.stereotype.Service;

import static java.lang.Math.*;

@Service
public class OptionServiceImpl implements OptionService {


    public OptionPriceDTO getPriceOption(OptionForm optionForm){

        OptionPriceDTO optionPriceDTO = calculatedPriceOption(optionForm);

        return optionPriceDTO;
    }

    private OptionPriceDTO calculatedPriceOption(OptionForm optionForm) {
        if (optionForm.getType().toLowerCase().equals("call") ||
                optionForm.getType().toLowerCase().equals("put")) {
            NormalDistribution normalDistribution = new NormalDistribution(0, 1);
            // OptionPrice optionPrice = new OptionPrice();
            OptionPriceDTO optionPriceDTO = new OptionPriceDTO();

            Double S = optionForm.getPriceStock();
            Double K = optionForm.getPriceStrike();
            Double r = optionForm.getRiskFree();
            double vol = optionForm.getVolatility();
            double T = optionForm.getTime();
            String type = optionForm.getType();
            int sizeYear = optionForm.getSizeYear();

            Double d1 = (log(S / K) + (r + pow(vol, 2) / 2) * (T / sizeYear)) / (vol * sqrt(T / sizeYear));

            Double d2 = (log(S / K) + (r - pow(vol, 2) / 2) * (T / sizeYear)) / (vol * sqrt(T / sizeYear));

            double nLinhaD1 = (1 / sqrt(2 * PI)) * exp(-pow(d1, 2) / 2);
            double gama = nLinhaD1 / (S * vol * sqrt(T / sizeYear));
            double vega = S * sqrt(T / sizeYear) * nLinhaD1;
            double delta = getcumulativeProbabily(normalDistribution, d1);
            optionPriceDTO.setGama(gama);
            optionPriceDTO.setVega(vega);

            if ("call".equals(type.toLowerCase())) {

                optionPriceDTO.setDelta(delta);
                optionPriceDTO.setPriceOption(S * getcumulativeProbabily(normalDistribution, d1)
                        - K * exp(-r * (T / sizeYear)) * getcumulativeProbabily(normalDistribution, d2));

                double teta_call = -((S * nLinhaD1 * vol) / (2 * sqrt(T / sizeYear)))
                        - (r * K * exp(-r * (T / sizeYear)) * getcumulativeProbabily(normalDistribution, d2));

                double ro_call = K * (T / sizeYear) * exp(-r * (T / sizeYear))
                        * getcumulativeProbabily(normalDistribution, d2);
                optionPriceDTO.setTeta(teta_call/sizeYear);
                optionPriceDTO.setRho(ro_call);

            } else if ("put".equals(type.toLowerCase())) {
                optionPriceDTO.setDelta(delta - 1);
                optionPriceDTO.setPriceOption(K * exp(-r * (T / sizeYear)) * getcumulativeProbabily(normalDistribution, -d2)
                        - S * getcumulativeProbabily(normalDistribution, -d1));

                double teta_put = -((S * nLinhaD1 * vol) / (2 * sqrt(T / sizeYear)))
                        + (r * K * exp(-r * (T / sizeYear)) * getcumulativeProbabily(normalDistribution, -d2));

                double ro_put = -K * (T / sizeYear) * exp(-r * (T / sizeYear))
                        * getcumulativeProbabily(normalDistribution, -d2);
                optionPriceDTO.setTeta(teta_put/sizeYear);
                optionPriceDTO.setRho(ro_put);
            }

            return optionPriceDTO;

        }
        else{
            throw new IllegalArgumentException("Choose type of option: call or put");
        }

    }

    private double getcumulativeProbabily(NormalDistribution nd1, Double d1) {
        return nd1.cumulativeProbability(d1);
    }



}
