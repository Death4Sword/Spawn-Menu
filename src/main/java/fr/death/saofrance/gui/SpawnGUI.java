package fr.death.saofrance.gui;

import fr.death.saofrance.Main;
import fr.death.saofrance.serialization.Serialization;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SpawnGUI {
    private final Main main;

    public SpawnGUI(Player p){
        main = Main.getInstance();
        openInv(p);
    }

    public void openInv(Player p) {
        Inventory inv = Bukkit.createInventory(p, 9, "§c§lMenu de téléportation");
        inv.setItem(2, palier1());
        inv.setItem(4, palier2());
        inv.setItem(6, palier3());
        p.openInventory(inv);
    }

    public ItemStack palier1() {
        ItemStack item;
        if(main.getConfig().getString("item1") != null)
            item = Serialization.fromBase64(main.getConfig().getString("item1"));
        else
            item = new ItemStack(Material.REDSTONE_BLOCK);
        assert item != null;
        ItemMeta itemM = item.getItemMeta();
        assert itemM != null;
        itemM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        itemM.setDisplayName("§7§nPalier 1");
        itemM.setUnbreakable(true);
        item.setItemMeta(itemM);
        return item;
    }
    public ItemStack palier2(){
        ItemStack item2;
        if(main.getConfig().getString("item1") != null)
            item2 = Serialization.fromBase64(main.getConfig().getString("item2"));
        else
            item2 = new ItemStack(Material.DIAMOND_BLOCK);
        assert item2 != null;
        ItemMeta itemM2 = item2.getItemMeta();
        assert itemM2 != null;
        itemM2.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        itemM2.setDisplayName("§7§nPalier 2");
        itemM2.setUnbreakable(true);
        item2.setItemMeta(itemM2);
        return item2;
    }
    public ItemStack palier3(){
        ItemStack item3;
        if(main.getConfig().getString("item2") != null)
            item3 = Serialization.fromBase64(main.getConfig().getString("item3"));
        else
            item3 = new ItemStack(Material.DIAMOND_BLOCK);
        assert item3 != null;
        ItemMeta itemM3 = item3.getItemMeta();
        assert itemM3 != null;
        itemM3.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        itemM3.setDisplayName("§7§nPalier 3");
        itemM3.setUnbreakable(true);
        item3.setItemMeta(itemM3);
        return item3;
    }
}
