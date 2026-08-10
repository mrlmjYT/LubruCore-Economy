package Cool.lubruCoreEconomy.gui;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class GUIUtils {

    public static ItemStack createItem(Material material, String name, String... lore){
        ItemStack item = new ItemStack(material);

        ItemMeta meta = item.getItemMeta();

        if (meta != null){
            meta.setDisplayName(name);
            meta.setLore(Arrays.asList(lore));

            item.setItemMeta(meta);
        }

        return item;
    }

    public static ItemStack createGlass(){
        return createItem(Material.GRAY_STAINED_GLASS_PANE, " ");
    }

    public static ItemStack createBackButton() {
        return createItem(Material.ARROW, "§cBack", "§7Back to the Economy Menu");
    }

    public static ItemStack createCloseButton() {
        return createItem(Material.BARRIER, "§cClose", "§7Close Menu");
    }
}
