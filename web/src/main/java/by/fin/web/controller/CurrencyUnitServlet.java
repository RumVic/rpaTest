package by.fin.web.controller;

import by.fin.service.ICurrencyUnitService;
import by.fin.web.controller.DTO.CurrencyUnitDTO;
import by.fin.web.controller.JSON.JsonBodyHandler;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.Supplier;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/currency")
public class CurrencyUnitServlet {

    @Autowired
    private  ICurrencyUnitService SERVICE;

    @GetMapping
    protected ResponseEntity<String> get(HttpServletResponse response,HttpServletResponse request) throws IOException, InterruptedException {
        synchronousRequest();
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping
    protected ResponseEntity<String> get (@RequestBody @Valid CurrencyUnitDTO idto, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //response.sendRedirect(" https://api.nbrb.by/exrates/rates/431");
        //InputStream is = myMethod();
        //System.out.println(is);
        return new ResponseEntity<>("That's good request",HttpStatus.OK); //new ResponseEntity<>(products, HttpStatus.OK);
    }


    private static void synchronousRequest() throws IOException, InterruptedException {
        // create a client
        var client = HttpClient.newHttpClient();

        // create a request
        var request = HttpRequest.newBuilder(
                URI.create("https://api.nbrb.by/exrates/rates/431")).build();

        // use the client to send the request
        HttpResponse<Supplier<CurrencyUnitDTO>> response = client.send(request, new JsonBodyHandler<>(CurrencyUnitDTO.class));
        CurrencyUnitDTO currencyUnitDTO = response.body().get();
        // the response:
    }
}