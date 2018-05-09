package Laba4;

import com.alibaba.fastjson.JSON;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketAdapter;

import java.io.IOException;
import java.util.Map;

//описание логики, используемой в сервлете вся логика которая будет в сервлете

public class EventSocket extends WebSocketAdapter implements CurrencyListener {
    @Override //кооогда открыл
    public void onWebSocketConnect(Session session) {
        super.onWebSocketConnect(session);
        CurrencyObserver.getInstance().addListener(this);
    }

    @Override //закрытие
    public void onWebSocketClose(int statusCode, String reason) {
        super.onWebSocketClose(statusCode, reason);
        CurrencyObserver.getInstance().removeListener(this);
    }

    @Override //будет вызываться из observer
    public void onChangeCurrencies(Map<String, Double> map) {
        try {
            this.getSession().getRemote().sendString(JSON.toJSONString(map));//отправляет данные
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}