package by.fin.service.util;

import by.fin.service.dto.CurrencyUnitDTO;
import by.fin.service.json.JsonBodyHandler;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.Supplier;

public class DataFromAPIHBForCurrencyUnit {

    private static String baseUrl = "https://api.nbrb.by/exrates/rates/";

    public static CurrencyUnitDTO synchronousRequest(String idOnSite) throws IOException, InterruptedException {
        // create a client
        var client = HttpClient.newHttpClient();

        String myUrl = baseUrl+idOnSite;
        // create a request
        var request = HttpRequest.newBuilder(
                URI.create(myUrl)).build();

        // use the client to send the request
        HttpResponse<Supplier<CurrencyUnitDTO>> response = client.send(request, new JsonBodyHandler<>(CurrencyUnitDTO.class));
        CurrencyUnitDTO currencyUnitDTO = response.body().get();
        // the response:
        return currencyUnitDTO;
    }
}
