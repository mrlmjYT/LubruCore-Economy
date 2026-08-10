package Cool.lubruCoreEconomy.gui;

import Cool.lubruCoreEconomy.LubruCoreEconomy;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.Locale;

public class BankGUI {
    public static final String TITLE = "§8Bank";

    public static void open(Player player){
        LubruCoreEconomy plugin = LubruCoreEconomy.getInstance();

        double balance = plugin.getEconomyManager().getBalance(player.getUniqueId());

        String formatted = String.format(Locale.US, "%.2f", balance);

        Inventory inv = Bukkit.createInventory(null, 36, TITLE);

        for (int i = 0; i < inv.getSize(); i++) {
            inv.setItem(i, GUIUtils.createGlass());
        }

        inv.setItem(13, GUIUtils.createItem(Material.EMERALD_BLOCK, "§2Bank Account", "", "§7Current Balance", "§a$" + formatted));
        inv.setItem(20, GUIUtils.createItem(Material.LIME_DYE, "§aDeposit"));
        inv.setItem(24,GUIUtils.createItem(Material.RED_DYE, "§aWithdraw"));
        inv.setItem(34, GUIUtils.createBackButton());

        player.openInventory(inv);
    }
}
