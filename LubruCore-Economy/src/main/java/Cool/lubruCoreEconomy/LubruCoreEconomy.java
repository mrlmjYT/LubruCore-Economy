package Cool.lubruCoreEconomy;

import Cool.lubruCoreEconomy.commands.*;
import Cool.lubruCoreEconomy.economy.EconomyManager;
import Cool.lubruCoreEconomy.economy.MoneyStorage;
import Cool.lubruCoreEconomy.gui.GUIListener;
import Cool.lubruCoreEconomy.listeners.JoinListener;
import Cool.lubruCoreEconomy.listeners.TabListener;
import Cool.lubruCoreEconomy.rank.RankConfig;
import Cool.lubruCoreEconomy.rank.RankManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class LubruCoreEconomy extends JavaPlugin {

    private static LubruCoreEconomy instance;

    private MoneyStorage moneyStorage;
    private EconomyManager economyManager;

    private RankConfig rankConfig;
    private RankManager rankManager;


    @Override
    public void onEnable() {
        instance = this;

        //Data
        moneyStorage = new MoneyStorage(this);
        economyManager = new EconomyManager(this);

        rankManager = new RankManager(this);

        // Commands
        getCommand("economy").setExecutor(new EconomyCommand());
        getCommand("balance").setExecutor(new BalanceCommand(this));
        getCommand("pay").setExecutor(new PayCommand(this));

        getCommand("setbalance").setExecutor(new SetBalanceCommand(this));
        getCommand("addmoney").setExecutor(new AddMoneyCommand(this));
        getCommand("removeMoney").setExecutor(new RemoveMoneyCommand(this));

        getCommand("setrank").setExecutor(new SetRankCommand(this));

        //Listener

        getServer().getPluginManager().registerEvents(new GUIListener(), this);
        getServer().getPluginManager().registerEvents(new JoinListener(this), this);
        getServer().getPluginManager().registerEvents(new TabListener(this), this);
    }



    @Override
    public void onDisable() {
        getLogger().info("LubruCoreEconomy disabled!");
    }

    public static LubruCoreEconomy getInstance() {
        return instance;
    }

    public MoneyStorage getMoneyStorage() {
        return moneyStorage;
    }

    public EconomyManager getEconomyManager() {
        return economyManager;
    }

    public RankConfig getRankConfig() {
        return rankConfig;
    }

    public RankManager getRankManager() {
        return rankManager;
    }
}
