package com.myproject.banknoteMain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import com.myproject.banknoteMain.entities.*;
import com.myproject.banknoteMain.entities.Currency;
import com.myproject.banknoteMain.entities.dto.*;

import java.util.*;

public class Main {
    private static final String URL = "http://localhost:8081";
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final HttpHeaders headers = new HttpHeaders();
    private static final HttpEntity<Object> headersEntity = new HttpEntity<>(headers);


    public static void main(String[] args) {
        headers.setContentType(MediaType.APPLICATION_JSON);

        BanknoteMachine banknoteMachine1 = new BanknoteMachine(Currency.USD, 50);

        List<Banknote> addedBanknote = createBanknoteList(banknoteMachine1);
        List<Integer> quantity = Arrays.asList(1, 2, 3);

        BanknoteFromMachine(banknoteMachine1, addedBanknote, quantity);

        ResponseEntity<Banknote[]> response2;
        response2 = restTemplate.exchange(URL + "/banknote", HttpMethod.GET, headersEntity, Banknote[].class);
        List<Banknote> banknote = Arrays.asList(Objects.requireNonNull(response2.getBody()));
        System.out.println(banknote);

        response2 = restTemplate.exchange(URL + "/banknote", HttpMethod.GET, headersEntity, Banknote[].class);
        List<Banknote> banknoteForOrder = Arrays.asList(Objects.requireNonNull(response2.getBody()));
        System.out.println(banknoteForOrder);

        Customer customer1 = new Customer("Oleh", "Vynnyk", "PrivatBank");
        Customer customer2 = new Customer("Slava", "Marlow", "CrediAgricol");

        List<Banknote> orderForCustomer1 = new ArrayList<>(banknoteForOrder.subList(0, 2));
        makeOrder(customer1, /*banknoteMachine1, */orderForCustomer1);

        List<Banknote> orderForCustomer2 = new ArrayList<>(banknoteForOrder.subList(2, 4));
        makeOrder(customer2, /*banknoteMachine1, */orderForCustomer2);

        response2 = restTemplate.exchange(URL + "/banknote", HttpMethod.GET, headersEntity, Banknote[].class);
        System.out.println(Arrays.asList(Objects.requireNonNull(response2.getBody())));

        ResponseEntity<Customer[]> response3 = restTemplate.exchange(URL + "/customer", HttpMethod.GET, headersEntity, Customer[].class);
        List<Customer> customer = Arrays.asList(Objects.requireNonNull(response3.getBody()));
        System.out.println(customer);

        ResponseEntity<Order[]> response4 = restTemplate.exchange(URL + "/order", HttpMethod.GET, headersEntity, Order[].class);
        List<Order> order = Arrays.asList(Objects.requireNonNull(response4.getBody()));
        System.out.println(order);
    }

    public static List<Banknote> createBanknoteList(BanknoteMachine machine) {
        Banknote banknote1 = new Banknote(Currency.USD, machine);
        Banknote banknote2 = new Banknote(Currency.EUR, machine);
        Banknote banknote3 = new Banknote(Currency.UAH, machine);

        return Arrays.asList(banknote1, banknote2, banknote3);
    }

    private static void makeOrder(Customer customer, List<Banknote> orderForCustomer) {
        NewOrderDTO newOrderDTO = new NewOrderDTO();
        newOrderDTO.setCustomer(customer);
        newOrderDTO.setBanknote(orderForCustomer);

        HttpEntity<NewOrderDTO> createOrder = new HttpEntity<>(newOrderDTO);
        ResponseEntity<Void> response3 = restTemplate.exchange(URL + "/order", HttpMethod.POST, createOrder, Void.class);
    }


    private static void BanknoteFromMachine(BanknoteMachine machine, List<Banknote> banknote, List<Integer> quantities) {
        ServeDTO serveDTO = new ServeDTO();
        serveDTO.setBanknoteMachine(machine);
        serveDTO.setBanknote(banknote);
        serveDTO.setBanknoteQuantity(quantities);
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        String serveJsonStr = gson.toJson(serveDTO);

        HttpEntity<String> serveJson = new HttpEntity<>(serveJsonStr, headers);
        ResponseEntity<Void> response1 = restTemplate
                .exchange(URL + "/banknoteMachine", HttpMethod.POST, serveJson, Void.class);
    }

}
