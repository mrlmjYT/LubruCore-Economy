package Cool.lubruCoreEconomy.commands;

import Cool.lubruCoreEconomy.LubruCoreEconomy;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Locale;


public class SetBalanceCommand implements CommandExecutor {

    private final LubruCoreEconomy plugin;

    public SetBalanceCommand(LubruCoreEconomy plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String labels, String[] args){
        if (!(sender instanceof Player player)){
            sender.sendMessage("§cThis command can only be used by a player");
            return true;
        }

        if (!player.isOp()){
            player.sendMessage("§cYou have not the rights to use this Command");
            return true;
        }

        if (args.length != 2){
            player.sendMessage("§cUsage: /setbalance <Player> <amount>");
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
            player.sendMessage("§cThe amount must be a number");
            return true;
        }

        if (amount < 0){
            player.sendMessage("§cThe amount must not be smaller then 0");
            return true;
        }

        amount = Math.round(amount * 100) / 100;

        plugin.getEconomyManager().setBalance(target.getUniqueId(), amount);

        String formattedAmount = String.format(Locale.US, "%.2f", amount);

        player.sendMessage("§aYou sent §e$" + formattedAmount + " §ato §e" + target.getName());

        target.sendMessage("§aYou got §e$" + formattedAmount + " §afrom §e" + player.getName());

        return true;
    }
}
