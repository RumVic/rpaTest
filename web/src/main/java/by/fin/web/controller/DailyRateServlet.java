package by.fin.web.controller;

import by.fin.module.entity.DailyRate;
import by.fin.service.IDailyRateService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import by.fin.service.util.DataFromAPIHB;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/currency/period")
public class DailyRateServlet {

    @Autowired
    private final IDailyRateService service;

    private static String baseUrl = "https://api.nbrb.by/ExRates/Rates/Dynamics/";


    @GetMapping
    protected ResponseEntity<List<DailyRate>> get(HttpServletResponse response, HttpServletRequest request) throws IOException, InterruptedException {
        String currencyId = request.getParameter("id");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        if (currencyId.isEmpty() || startDate.isEmpty() || endDate.isEmpty())throw new IllegalStateException("You didn't pass the parameter");

        if (LocalDateTime.parse(startDate).isBefore(LocalDateTime.parse(endDate))) {
        } else {
            throw new NumberFormatException("The period of time which was entered is invalid");
        }

        service.create(DataFromAPIHB.synchronousRequest(startDate, endDate, currencyId));

        return ResponseEntity.ok(service.read(Integer.parseInt(currencyId),
                LocalDateTime.parse(startDate),
                LocalDateTime.parse(endDate)));
    }

    @GetMapping("/code")
    protected ResponseEntity<List<DailyRate>> getByCode(HttpServletResponse response, HttpServletRequest request) {
        String requestParam = request.getParameter("code");
        if (requestParam.isEmpty())throw new IllegalStateException("You didn't pass the code parameter");
        return ResponseEntity.ok(service.readByCode(Integer.parseInt(requestParam)));
    }

    @GetMapping("/mount")
    protected ResponseEntity<Double> getAverageByMonth(HttpServletResponse response, HttpServletRequest request) {
        String requestMonthParam = request.getParameter("mount");
        String requestYearParam = request.getParameter("year");
        String requestIdParam = request.getParameter("id");
        if(requestMonthParam.isEmpty()||requestIdParam.isEmpty()||requestYearParam.isEmpty())throw new IllegalStateException("You didn't pass the parameter");
        return ResponseEntity.ok(service.readByMonthAndYear
                (Integer.parseInt(requestMonthParam),
                Integer.parseInt(requestYearParam),
                Integer.parseInt(requestIdParam)));
    }

}
