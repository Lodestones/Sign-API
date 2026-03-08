package gg.lode.sign.api;

import gg.lode.sign.api.nametag.INametagManager;

public final class SignAPI {
    private static ISign instance;

    private SignAPI() {}

    public static void register(ISign sign) {
        instance = sign;
    }

    public static ISign get() {
        if (instance == null) {
            throw new IllegalStateException("Sign has not been initialized yet.");
        }
        return instance;
    }

    public static INametagManager getNametagManager() {
        return get().getNametagManager();
    }
}
