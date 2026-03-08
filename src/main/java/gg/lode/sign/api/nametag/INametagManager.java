package gg.lode.sign.api.nametag;

import org.bukkit.entity.Player;

import java.util.Collection;

public interface INametagManager {
    INametag get(Player player);
    Collection<? extends INametag> getAll();
    void create(Player player);
    void remove(Player player);
    void createAll();
    void removeAll();
}
