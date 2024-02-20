package com.myproject;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationService {

    @Getter
    @Setter
    private Map<String, ComponentConfiguration> componentConfiguration = new HashMap<>();

    public ComponentConfiguration getConfigByRoutingName(final String routingName) {
        return componentConfiguration.get(routingName);
    }
}
