package gg.lode.sign.api.nametag;

import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.List;

public interface INametag {
    Player getPlayer();
    void showForAll();
    void hideForAll();
    void updateVisibilityForAll();
    void updateVisibilityFor(Player viewer);
    void show(Player viewer);
    void hide(Player viewer);
    void update(Player viewer);

    /**
     * Persistently hides (or un-hides) this nametag for everyone. Unlike
     * {@link #hideForAll()}, which the visibility scheduler undoes on its
     * next pass, a hidden nametag stays hidden until this is called with
     * {@code false}.
     *
     * @param hidden whether the nametag should be hidden
     */
    void setHidden(boolean hidden);

    /**
     * Check if this nametag is persistently hidden.
     *
     * @return true if hidden via {@link #setHidden(boolean)}
     */
    boolean isHidden();

    /**
     * Restrict this nametag to a whitelist of viewers: only the given
     * players can see it until {@link #clearViewers()} is called. Distance,
     * world and vanish rules still apply on top of the whitelist.
     *
     * @param viewers the only players allowed to see this nametag
     */
    void setViewers(Collection<Player> viewers);

    /**
     * Remove the viewer whitelist, restoring visibility for everyone.
     */
    void clearViewers();

    /**
     * Check if a viewer whitelist is active.
     *
     * @return true if visibility is restricted via {@link #setViewers(Collection)}
     */
    boolean hasViewerWhitelist();

    /**
     * Override the nametag lines globally for all viewers.
     * This overrides the configured nametag until {@link #release()} is called
     * or the plugin is reloaded.
     *
     * @param lines the custom lines to display
     */
    void setLines(List<String> lines);

    /**
     * Override the nametag lines that a specific viewer sees for this player.
     * This overrides the configured nametag until {@link #release(Player)} is called
     * or the plugin is reloaded.
     *
     * @param viewer the player who will see the custom lines
     * @param lines  the custom lines to display
     */
    void setLines(Player viewer, List<String> lines);

    /**
     * Release the global override, restoring the configured nametag for all viewers.
     */
    void release();

    /**
     * Release the per-viewer override, restoring the configured nametag
     * for the given viewer.
     *
     * @param viewer the player whose override should be removed
     */
    void release(Player viewer);

    /**
     * Check if a global override is active.
     *
     * @return true if a global override is active
     */
    boolean hasOverride();

    /**
     * Check if a viewer has a per-viewer override active.
     *
     * @param viewer the player to check
     * @return true if the viewer has an active override
     */
    boolean hasOverride(Player viewer);
}
