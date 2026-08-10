package Cool.lubruCoreEconomy.listeners;

import Cool.lubruCoreEconomy.LubruCoreEconomy;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class TabListener implements Listener {
    private final LubruCoreEconomy plugin;

    public TabListener(LubruCoreEconomy plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        String prefix = plugin.getRankManager().getRank(event.getPlayer().getUniqueId()).getPrefix();

        event.getPlayer().setPlayerListName(prefix+" §f"+event.getPlayer().getName());
    }
}
