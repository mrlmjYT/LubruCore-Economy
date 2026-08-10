package Cool.lubruCoreEconomy.rank;

public enum Rank {
    OWNER("§4Owner"),
    CO_Owner("$cCo-Owner"),
    ADMIN("§4Admin"),
    MOD("§2Mod"),
    SUP("§bSup"),
    VIP("§6VIP"),
    PLAYER("§7Player");

    private final String prefix;

    Rank(String prefix){
        this.prefix  = prefix;
    }

    public String getPrefix(){
        return prefix;
    }
}
