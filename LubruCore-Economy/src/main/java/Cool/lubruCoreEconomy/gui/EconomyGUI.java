package Cool.lubruCoreEconomy.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class EconomyGUI {

    public static final String TITLE = "§8LubruCore Economy";

    public static void open(Player player){
        Inventory inv = Bukkit.createInventory(null, 45, TITLE);

        for (int i = 0; i < inv.getSize(); i++) {
            inv.setItem(i, GUIUtils.createGlass());
        }

        inv.setItem(20, GUIUtils.createItem(Material.GOLD_INGOT, "§6Balance", "§7Shows your balance"));
        inv.setItem(24, GUIUtils.createItem(Material.PAPER, "§aPay", "§aPay another Player"));
        inv.setItem(22, GUIUtils.createItem(Material.EMERALD, "§2Bank", "§7Manage your Bank Account"));
        inv.setItem(40, GUIUtils.createCloseButton());

        player.openInventory(inv);
    }
}
