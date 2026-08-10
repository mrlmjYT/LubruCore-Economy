package Cool.lubruCoreEconomy.commands;

import Cool.lubruCoreEconomy.LubruCoreEconomy;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Locale;

public class PayCommand implements CommandExecutor {

    private final LubruCoreEconomy plugin;

    public PayCommand (LubruCoreEconomy plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command,  String label, String[] args){
        if (!(sender instanceof Player player)){
            sender.sendMessage("§cThis command can only be used by a player");
            return true;
        }

        if (args.length != 2){
            player.sendMessage("§cUsage: /pay <Player> <amount>");
            return true;
        }

        Player target = Bukkit.getPlayerExact(args[0]);

        if (target == null){
            player.sendMessage("§cThis PLayer is not online.");
            return true;
        }

        if (target.equals(player)){
            player.sendMessage("§cYou can not give yourself money.");
            return true;
        }

        double amount;

        try {
            amount = Double.parseDouble(args[1].replace(",", "."));
        } catch (NumberFormatException e){
            player.sendMessage("§cThe amount must be a number");
            return true;
        }

        if (amount <= 0){
            player.sendMessage("§cThe amount must be bigger then 0.");
            return true;
        }

        amount = Math.round(amount*100) /100;

        boolean succes = plugin.getEconomyManager().transfer(player.getUniqueId(), target.getUniqueId(), amount);

        if (!succes){
            player.sendMessage("§cYou got not enough money");
            return true;
        }

        String formattedAmount = String.format(Locale.US, "%.2f", amount);

        player.sendMessage("§aYou sent §e$" + formattedAmount + " §ato §e" + target.getName());

        target.sendMessage("§aYou got §e$" + formattedAmount + " §afrom §e" + player.getName());

        return true;
    }
}
