package Cool.lubruCoreEconomy.gui;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GUIListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event){
        if (!(event.getWhoClicked() instanceof Player player)){
            return;
        }

        if (event.getCurrentItem() == null){
            return;
        }

        String title = event.getView().getTitle();

        if (title.equals(EconomyGUI.TITLE)){
            event.setCancelled(true);

            switch (event.getCurrentItem().getType()){
                case GOLD_INGOT:
                    GUIManager.openBalance(player);
                    break;
                case PAPER:
                    GUIManager.openPay(player);
                    break;
                case EMERALD:
                    GUIManager.openBank(player);
                    break;
                case BARRIER:
                    player.closeInventory();
                    break;
            }
            return;
        }

        if (title.equals(BalanceGUI.TITLE)){
            event.setCancelled(true);

            if (event.getCurrentItem().getType() == Material.ARROW){
                GUIManager.openEconomy(player);
            }

            return;
        }

        if (title.equals(BankGUI.TITLE)){
            event.setCancelled(true);

            if (event.getCurrentItem().getType() == Material.ARROW){
                GUIManager.openEconomy(player);
            }
            return;
        }
    }
}
