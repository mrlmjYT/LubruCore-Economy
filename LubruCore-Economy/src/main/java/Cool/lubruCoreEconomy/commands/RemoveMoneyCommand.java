package Cool.lubruCoreEconomy.commands;

import Cool.lubruCoreEconomy.LubruCoreEconomy;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Locale;

public class RemoveMoneyCommand implements CommandExecutor {

    private final LubruCoreEconomy plugin;

    public RemoveMoneyCommand(LubruCoreEconomy plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if (!(sender instanceof Player player)){
            sender.sendMessage("§COnly a player can use this command");
            return true;
        }

        if (!player.isOp()){
            player.sendMessage("§cYou got not enough rights to use this command");
            return true;
        }

        if (args.length != 2){
            player.sendMessage("§cUsage: /removemoney <Player> <Amount>");
            return true;
        }

        Player target = Bukkit.getPlayerExact(args[0]);

        if (target == null){
            player.sendMessage("§cThis Player is not online");
            return true;
        }

        double amount;

        try {
            amount = Double.parseDouble(args[1].replace(",", "."));
        } catch (NumberFormatException e){
            player.sendMessage("§cThe Amount must be a number");
            return true;
        }

        if (amount <= 0){
            player.sendMessage("§cThe amount must be bigger then 0");
            return true;
        }

        amount = Math.round(amount * 100) / 100;

        boolean success = plugin.getEconomyManager().removeMoney(target.getUniqueId(), amount);

        if (!success){
            player.sendMessage("§cThe Player has not enough Money");
            return true;
        }

        String formattedAmount = String.format(Locale.US, "%.2f", amount);

        player.sendMessage("§aYou sent §e$" + formattedAmount + " §ato §e" + target.getName());

        target.sendMessage("§aYou got §e$" + formattedAmount + " §afrom §e" + player.getName());

        return true;
    }
}
