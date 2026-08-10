package Cool.lubruCoreEconomy.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class PayGUI {
    public static final String TITLE = "§8Give Money";

    public static void open(Player player){
        Inventory inv = Bukkit.createInventory(null, 27, TITLE);

        for (int i = 0; i < inv.getSize(); i++) {
            inv.setItem(i, GUIUtils.createGlass());
        }

        inv.setItem(11, GUIUtils.createItem(Material.PLAYER_HEAD, "§Choose a Player"));
        inv.setItem(15, GUIUtils.createItem(Material.PAPER, "§ePay with command", "§7Usage: ", "§f/pay <Player> <amount>"));
        inv.setItem(22, GUIUtils.createBackButton());

        player.openInventory(inv);
    }
}
