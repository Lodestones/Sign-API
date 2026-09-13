package gg.lode.sign.api.nametag;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * A nametag above something that is not a player.
 *
 * <p>Every other nametag here belongs to a {@link Player} and reads its state — health, sneaking,
 * voice, distance — to decide what to draw and who to draw it to. This one belongs to a bare entity
 * id and reads nothing: the caller says what the lines are and who can see them.
 *
 * <p>It exists for entities the server does not have. A replayed match is packet-built players — a
 * recording played back is not a {@code Player} and never appears in {@code getOnlinePlayers()} — and
 * those need labelling most, because a stand-in bot in a replay wears the real player's name and skin
 * and nothing else says nobody was driving.
 *
 * <p>The tag rides its vehicle: it is mounted on the entity id, so the client keeps it above that
 * entity as it moves, with no position updates from the server. Nothing is drawn until somebody is
 * shown it.
 */
public interface IVirtualNametag {

    /** The entity id this tag rides on. */
    int getVehicleEntityId();

    /**
     * Replaces what the tag says.
     *
     * <p>Lines are joined top to bottom. Already-shown viewers see the change at once.
     */
    void setLines(List<Component> lines);

    /** Convenience for a single line. */
    void setLine(Component line);

    /**
     * Replaces what the tag says for one viewer only.
     *
     * <p>For anything that is true of the watcher rather than the subject — a health readout staff can
     * see and players cannot, most obviously. Each viewer is sent their own text, so two people looking
     * at the same subject can be shown different things, and the line counts need not match.
     *
     * <p>Passing null clears the override and puts that viewer back on the shared lines.
     */
    void setLines(Player viewer, List<Component> lines);

    /** Draws the tag for one viewer, and keeps drawing it until hidden. */
    void show(Player viewer);

    /** Stops drawing it for one viewer. */
    void hide(Player viewer);

    /** Everybody currently shown this tag. */
    List<Player> getViewers();

    /** Takes the tag down for everybody and forgets it. The handle is spent afterwards. */
    void remove();
}
