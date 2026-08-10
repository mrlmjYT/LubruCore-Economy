package Cool.lubruCoreEconomy.commands;

import Cool.lubruCoreEconomy.LubruCoreEconomy;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Locale;

public class BalanceCommand implements CommandExecutor {
    private final LubruCoreEconomy plugin;

    public BalanceCommand(LubruCoreEconomy plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if (!(sender instanceof Player player)){
            sender.sendMessage("§cThis Command can only be used by a player");
            return true;
        }

        double balance = plugin.getEconomyManager().getBalance(player.getUniqueId());

        player.sendMessage("§6Your Balance: §a$" + String.format(Locale.US, "%.2f", balance));
        return true;
    }
}
