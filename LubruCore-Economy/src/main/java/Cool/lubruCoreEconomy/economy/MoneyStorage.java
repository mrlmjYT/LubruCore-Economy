package Cool.lubruCoreEconomy.economy;

import Cool.lubruCoreEconomy.LubruCoreEconomy;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class MoneyStorage {


    private final LubruCoreEconomy plugin;

    private File file;
    private FileConfiguration config;



    public MoneyStorage(LubruCoreEconomy plugin) {

        this.plugin = plugin;

        setup();

    }



    private void setup() {


        if (!plugin.getDataFolder().exists()) {

            plugin.getDataFolder().mkdirs();

        }


        file = new File(
                plugin.getDataFolder(),
                "money.yml"
        );


        if (!file.exists()) {

            try {

                file.createNewFile();

            } catch (IOException e) {

                e.printStackTrace();

            }

        }


        config = YamlConfiguration.loadConfiguration(file);

    }




    public double getBalance(UUID uuid) {


        return config.getDouble(
                "players." + uuid + ".balance",
                0
        );

    }




    public void setBalance(UUID uuid, double amount) {


        config.set(
                "players." + uuid + ".balance",
                amount
        );


        save();

    }




    public void addBalance(UUID uuid, double amount) {


        double current = getBalance(uuid);


        setBalance(
                uuid,
                current + amount
        );


    }




    public void removeBalance(UUID uuid, double amount) {


        double current = getBalance(uuid);


        setBalance(
                uuid,
                current - amount
        );


    }




    public void save() {


        try {

            config.save(file);

        } catch (IOException e) {

            e.printStackTrace();

        }

    }


}