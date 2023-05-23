package by.fin.service.util;

import by.fin.service.dto.DailyRateDTO;
import by.fin.service.json.JsonBodyHandler;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.Supplier;

public class DataFromAPIHB {
    public static String baseUrl = "https://api.nbrb.by/ExRates/Rates/Dynamics/";

    public static DailyRateDTO[] synchronousRequest(String startDate, String endDate, String id) throws IOException, InterruptedException {
        // create a client
        var client = HttpClient.newHttpClient();

        String myUrl = baseUrl + id + "?" + "startDate=" + startDate + "&" + "endDate=" + endDate;
        // create a request
        var request = HttpRequest.newBuilder(
                URI.create(myUrl)).build();
        // use the client to send the request
        HttpResponse<Supplier<DailyRateDTO[]>> response = client.send(request, new JsonBodyHandler<>(DailyRateDTO[].class));
        // the response:
        DailyRateDTO[] dtos = response.body().get();
        if (dtos.length == 0) {
            throw new IllegalArgumentException("try to enter another Date or Id");
        }
        return dtos;
    }

}
