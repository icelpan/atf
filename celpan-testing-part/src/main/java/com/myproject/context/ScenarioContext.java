package com.myproject.context;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@Component
public class ScenarioContext {

    private final Map<DataKeys, Object> data = Collections.synchronizedMap(new HashMap<>());

    public void saveData(DataKeys key, Object value) {
        data.put(key, value);
    }

    public Object gatData(DataKeys key) {
        return data.get(key);
    }

    public void resetContext() {
        data.clear();
    }

}
