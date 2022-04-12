package org.acme;

import io.quarkus.runtime.annotations.StaticInitSafe;
import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "potato")
@StaticInitSafe
public interface PotatoConfig {

    public String test();

}
