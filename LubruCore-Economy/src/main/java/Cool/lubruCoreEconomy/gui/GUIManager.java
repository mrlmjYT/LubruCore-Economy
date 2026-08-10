package Cool.lubruCoreEconomy.gui;

import org.bukkit.entity.Player;

public class GUIManager {

    public static void openEconomy(Player player){
        EconomyGUI.open(player);
    }

    public static void openBalance(Player player){
        BalanceGUI.open(player);
    }

    public static void openBank(Player player){
        BankGUI.open(player);
    }

    public static void openPay(Player player){
        PayGUI.open(player);
    }

}
