package Cool.lubruCoreEconomy.economy;

import Cool.lubruCoreEconomy.LubruCoreEconomy;

import java.util.UUID;

public class EconomyManager {

    private final LubruCoreEconomy plugin;
    private final MoneyStorage moneyStorage;

    public EconomyManager(LubruCoreEconomy plugin) {
        this.plugin = plugin;
        this.moneyStorage = plugin.getMoneyStorage();
    }


    public double getBalance(UUID uuid) {
        return moneyStorage.getBalance(uuid);
    }


    public void setBalance(UUID uuid, double amount) {

        if (amount < 0) {
            amount = 0;
        }

        moneyStorage.setBalance(uuid, amount);
    }


    public void addMoney(UUID uuid, double amount) {

        if (amount <= 0) {
            return;
        }

        moneyStorage.addBalance(uuid, amount);
    }


    public boolean removeMoney(UUID uuid, double amount) {

        if (amount <= 0) {
            return false;
        }

        double balance = getBalance(uuid);

        if (balance < amount) {
            return false;
        }

        moneyStorage.removeBalance(uuid, amount);

        return true;
    }


    public boolean hasMoney(UUID uuid, double amount) {

        if (amount < 0) {
            return false;
        }

        return getBalance(uuid) >= amount;
    }

    public boolean transfer(UUID sender, UUID receiver, double amount) {

        if (amount <= 0) {
            return false;
        }

        if (!hasMoney(sender, amount)) {
            return false;
        }

        removeMoney(sender, amount);
        addMoney(receiver, amount);

        return true;
    }
}