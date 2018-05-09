package Laba4;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

//хранит, добавляет и удаляет в себе список всех лисенеров и когда происходит изменение, он отправляет всем

public class CurrencyObserver implements Runnable {//он создается один
    public static final int DELAY = 5000;
    private static final CurrencyObserver instance = new CurrencyObserver();//единстенный экземпляр объекта

    private final List<CurrencyListener> listeners = Collections.synchronizedList(new LinkedList<>());//список всех слушателей
    private final Map<String, Double> currencies = new TreeMap<>();//имя валюты, название и его значение
    private CurrencyObserver() {
        Thread thread = new Thread(this);
        thread.start();
    }

    public void addListener(CurrencyListener listener) {//добавить listener
        this.listeners.add(listener);
        listener.onChangeCurrencies(currencies);
    }

    public void removeListener(CurrencyListener listener) {//удалить listener
        this.listeners.remove(listener);
    }

    private String getCurrencies() throws IOException {//функция отправляет запрос на сайт и возвращает ответ от сайта
        String url = "https://min-api.cryptocompare.com/data/pricemulti?fsyms=BTC,ETH,EUR,RUB,LTC&tsyms=USD";//можно выбрать что парсить
        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    @Override
    public void run() {
        while (true) {
            try {
                String json = getCurrencies();//получает значение
                Map<?, ?> JSONMap = JSON.parseObject(json, Map.class);//парсит json возвращает Мар и надо привести, где ключ - название, значение - стоимость
                Map<String, Double> map =//полученный файл не удобный и необходимо привести к комфортному виду
                        JSONMap.entrySet().stream().map(entry ->
                        {
                            String key = entry.getKey().toString();
                            Double value = ((JSONObject) entry.getValue()).getDoubleValue("USD");//второй мар только из долларов состоит, ключ Доллар, значение - СТОИМОСТЬ в долларах
                            return new AbstractMap.SimpleEntry<>(key, value);
                        }).filter(e -> !e.getValue().equals(currencies.get(e.getKey()))).
                                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
                System.out.println(map);//теперь меняет только обновление, тут можно отследить
                if (!map.isEmpty()) {
                    listeners.forEach(currencyListener -> currencyListener.onChangeCurrencies(map));
                    map.forEach(currencies::put);
                }
                Thread.sleep(DELAY);
            } catch (IOException|InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static CurrencyObserver getInstance() {
        return instance;
    }
}
