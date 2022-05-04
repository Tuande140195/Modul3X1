package service;

import model.Customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements CustomerServiceI{
    private static Map<String, Customer> customerMap;

    static {
        customerMap = new HashMap<>();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            customerMap.put("S1", new Customer("Tuan", format.parse("26/03/2000"),"Ngux Hành Sơn","Image/a.jpg"));
            customerMap.put("S2", new Customer("Hien", format.parse("10/03/2000"),"Sơn Trà","Image/b.jpg"));
            customerMap.put("S3", new Customer("Nam", format.parse("30/2/2000"),"Liên Chiểu","Image/c.jpg"));
            customerMap.put("S4", new Customer("Nu", format.parse("22/12/2000"),"Sơn Trà","Image/d.jpg"));


        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customerMap.values());
    }
}
