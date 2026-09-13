package gg.lode.sign.api.nametag;

import org.bukkit.entity.Player;

import java.util.Collection;

public interface INametagManager {
    INametag get(Player player);

    /**
     * Makes a nametag for something that is not a player, riding the given entity id.
     *
     * <p>For entities the server does not have: a replayed match is packet-built players, and a
     * stand-in bot in one wears the real player's name and skin with nothing to say nobody was
     * driving. Unlike a player's nametag this one reads no state and picks no viewers — the caller
     * sets the lines and shows it to whoever should see it.
     *
     * <p>Default-implemented so an older Sign keeps linking; it returns null, and a caller that gets
     * null should carry on without a tag rather than fail.
     *
     * @param vehicleEntityId the entity id to ride, which may be one the server has never heard of
     * @return the tag, or null on a build that cannot make one
     */
    default IVirtualNametag createVirtual(int vehicleEntityId) {
        return null;
    }
    Collection<? extends INametag> getAll();
    void create(Player player);
    void remove(Player player);
    void createAll();
    void removeAll();
}
