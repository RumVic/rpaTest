package by.fin.web.controller;

import by.fin.module.entity.CurrencyUnit;
import by.fin.service.ICurrencyUnitService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import static by.fin.service.util.DataFromAPIHBForCurrencyUnit.synchronousRequest;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/currency")
public class CurrencyUnitServlet {

    @Autowired
    private final ICurrencyUnitService SERVICE;

    @GetMapping
    protected ResponseEntity<CurrencyUnit> get(HttpServletResponse response, HttpServletRequest request) throws IOException, InterruptedException {
        String idOnSite = request.getParameter("id");
        if (idOnSite.isEmpty()) throw new IllegalStateException("You didn't pass the id on site");
        SERVICE.create(synchronousRequest(idOnSite));
        return ResponseEntity.ok(SERVICE.read(Integer.parseInt(idOnSite)));
    }


}