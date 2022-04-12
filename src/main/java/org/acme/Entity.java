package org.acme;

import org.eclipse.microprofile.config.ConfigProvider;

import io.smallrye.config.SmallRyeConfig;

public class Entity {

    private String test;

    Entity(String test) {
        this.test = test;
    }

    Entity() {}

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    @Override
    public String toString() {
        // PotatoConfig config = Arc.container().instance(PotatoConfig.class).get();
        PotatoConfig config = ConfigProvider.getConfig().unwrap(SmallRyeConfig.class)
                .getConfigMapping(PotatoConfig.class);
        return "Entity [test=" + test + "]" + config.test();
    }

}
