package Cool.lubruCoreEconomy.commands;

import Cool.lubruCoreEconomy.LubruCoreEconomy;
import Cool.lubruCoreEconomy.rank.Rank;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetRankCommand implements CommandExecutor {
    private final LubruCoreEconomy plugin;

    public SetRankCommand(LubruCoreEconomy plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if (!(sender instanceof Player player)){
            sender.sendMessage("§cOnly Players can use this Command");
            return true;
        }

        if (!player.isOp()){
            player.sendMessage("§cYou got not OP Rights");

            return true;
        }

        if (args.length != 2){
            player.sendMessage("§c Use: /setrank <Player> <Rank>");

            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if (target == null){
            player.sendMessage("§cPlayer is not Online!");
            return true;
        }

        Rank rank;

        try {
            rank = Rank.valueOf(args[1].toUpperCase());
        } catch (Exception e){
            player.sendMessage("§cThis Rank does not exist!");

            player.sendMessage("§7Ranks: OWNER, CO_OWNER, AMDIN, MOD, SUP, VIP, PLAYER");
            return true;
        }

        plugin.getRankManager().setRank(target.getUniqueId(),rank);
        plugin.getRankManager()
                .updateTab(target);


        player.sendMessage("§aYou gave" + target.getName() + " the rank " + rank.name());

        target.sendMessage("§aYour Rank is now: " + rank.name());

        return true;
    }
}
