package Cool.lubruCoreEconomy.listeners;


import Cool.lubruCoreEconomy.LubruCoreEconomy;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class JoinListener implements Listener {


    private final LubruCoreEconomy plugin;


    public JoinListener(LubruCoreEconomy plugin){

        this.plugin = plugin;

    }



    @EventHandler
    public void onJoin(PlayerJoinEvent event){


        if(event.getPlayer().isOp()){

            plugin.getRankManager()
                    .setRank(
                            event.getPlayer().getUniqueId(),
                            Cool.lubruCoreEconomy.rank.Rank.ADMIN
                    );

        }


        plugin.getRankManager()
                .updateTab(
                        event.getPlayer()
                );


    }

}