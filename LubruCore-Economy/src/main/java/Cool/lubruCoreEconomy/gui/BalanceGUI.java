package Cool.lubruCoreEconomy.gui;

import Cool.lubruCoreEconomy.LubruCoreEconomy;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.Locale;

public class BalanceGUI {
    public static final String TITLE = "§8Your Balance";

    public static void open(Player player){
        LubruCoreEconomy plugin = LubruCoreEconomy.getInstance();

        double balance = plugin.getEconomyManager().getBalance(player.getUniqueId());

        String formattedBalance = String.format(Locale.US, "%.2f", balance);

        Inventory inv = Bukkit.createInventory(null, 27, TITLE);

        for (int i = 0; i < inv.getSize(); i++) {
            inv.setItem(i, GUIUtils.createGlass());
        }

        inv.setItem(13, GUIUtils.createItem(Material.GOLD_BLOCK, "§6Your Balance", "", "§7Balance:", "§a$" + formattedBalance, "", "§7UUID: ", "§8" + player.getUniqueId()));
        inv.setItem(22, GUIUtils.createBackButton());
        player.openInventory(inv);
    }
}
