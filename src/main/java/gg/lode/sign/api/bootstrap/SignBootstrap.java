package gg.lode.sign.api.bootstrap;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Lifecycle contract that the runtime-loaded Sign implementation fulfils.
 * The public {@code Sign-Loader} jar is a JavaPlugin shim that loads an
 * implementation (via cloud or local jar), instantiates the entry class,
 * and forwards Bukkit lifecycle calls to it.
 *
 * <p>Implementations MUST have a public no-arg constructor so the loader
 * can instantiate them via reflection.
 */
public interface SignBootstrap {

    void onLoad(JavaPlugin host);

    void onEnable(JavaPlugin host);

    void onDisable(JavaPlugin host);
}
