package Cool.lubruCoreEconomy.rank;

import Cool.lubruCoreEconomy.LubruCoreEconomy;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


public class RankManager {
    private final LubruCoreEconomy plugin;

    private File file;
    private FileConfiguration config;

    public RankManager(LubruCoreEconomy plugin){
        this.plugin = plugin;
        setup();
    }
    private void setup(){
        file = new File(plugin.getDataFolder(), "ranks.yml");

        if (!file.exists()){
            try {
                plugin.getDataFolder().mkdirs();
                file.createNewFile();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        config = YamlConfiguration.loadConfiguration(file);
    }

    public Rank getRank(UUID uuid){
        String rank = config.getString("players."+uuid+".rank", "PLAYER");

        return Rank.valueOf(rank);
    }

    public void setRank(UUID uuid, Rank rank){
        config.set("players."+uuid+".rank", rank.name());
        save();
    }

    private void save(){
        try {
            config.save(file);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void updateTab(Player player){
        Rank rank = getRank(player.getUniqueId());

        player.setPlayerListName(rank.getPrefix() + " §f" + player.getName());
    }
}
