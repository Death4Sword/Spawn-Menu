package fr.death.saofrance.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import fr.death.saofrance.gui.SpawnGUI;


public class PlayerGUIListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        ItemStack is = e.getCurrentItem();
        InventoryView iv = e.getView();
        if (is == null || is.getType().equals(Material.AIR))
            return;
        if (e.getInventory().getName().equalsIgnoreCase("§c§lMenu de téléportation")) {
            if (is.getItemMeta().getDisplayName().equalsIgnoreCase("§7§nPalier 1") ) {
                p.closeInventory();
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mvtp " + p.getName() + " Palier1");
            }
            else if (is.getItemMeta().getDisplayName().equalsIgnoreCase("§7§nPalier 2")) {
                p.closeInventory();
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mvtp " + p.getName() + " Palier2");
            }
            else if (is.getItemMeta().getDisplayName().equalsIgnoreCase("§7§nPalier 3")) {
                p.closeInventory();
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mvtp " + p.getName() + " Palier3");
            }
        }

    }

    @EventHandler
    public void onDropItem(PlayerDropItemEvent event) {
        Material droppedItemType = event.getItemDrop().getItemStack().getType();
        if (droppedItemType == Material.REDSTONE_BLOCK)
            event.setCancelled(true);
    }
}
