package currency.controllers.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import currency.dto.ReadDto;
import currency.entity.Currency;
import currency.service.CurrencyService;
import currency.service.api.IService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CurrencyServlet", urlPatterns = "/currency")
public class CurrencyServlet extends HttpServlet {

    IService<Currency> service = CurrencyService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper()
               .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
               .registerModule(new JavaTimeModule());


        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        String id = req.getParameter("id");
        Currency read = null;
        if (id != null){
             read = service.read(Long.parseLong(id));
        }
        PrintWriter writer = resp.getWriter();
        ReadDto dto = new ReadDto();
        dto.setCode(read.getCode());
        dto.setDescription(read.getDescription());
        dto.setName(read.getName());
       writer.println( mapper.writeValueAsString(dto));


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
