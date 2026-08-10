package Cool.lubruCoreEconomy.commands;

import Cool.lubruCoreEconomy.gui.EconomyGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EconomyCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if(!(sender instanceof Player player)){
            sender.sendMessage("Only Players can use this Command");
            return true;
        }


        EconomyGUI.open(player);

        return true;
    }
}