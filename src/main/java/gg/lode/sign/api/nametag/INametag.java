package gg.lode.sign.api.nametag;

import org.bukkit.entity.Player;

public interface INametag {
    Player getPlayer();
    void showForAll();
    void hideForAll();
    void updateVisibilityForAll();
    void show(Player viewer);
    void hide(Player viewer);
    void update(Player viewer);
}
