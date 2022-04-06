package fr.death.saofrance.command;

import fr.death.saofrance.Main;
import fr.death.saofrance.gui.SpawnGUI;
import fr.death.saofrance.serialization.Serialization;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCMD implements CommandExecutor {
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Vous devez un joueur pour cette action !");
            return false;
        }
        Player p = ((Player)commandSender).getPlayer();
        assert p != null;
        if (label.equals("spawn")) {
            if(args.length == 1) {
                Main main = Main.getInstance();
                if (p.isOp()) {
                    if (args[0].equalsIgnoreCase("item1")) {
                        main.getConfig().set("item1", Serialization.toBase64(p.getInventory().getItemInMainHand()));
                        main.saveConfig();
                        p.sendMessage("§aVous venez de changer l'item1 en " + p.getInventory().getItemInMainHand().getItemMeta().getDisplayName());
                    } else if (args[0].equalsIgnoreCase("item2")) {
                        main.getConfig().set("item2", Serialization.toBase64(p.getInventory().getItemInMainHand()));
                        main.saveConfig();
                        p.sendMessage("§aVous venez de changer l'item2 en " + p.getInventory().getItemInMainHand().getItemMeta().getDisplayName());
                    } else if (args[0].equalsIgnoreCase("item3")) {
                        main.getConfig().set("item3", Serialization.toBase64(p.getInventory().getItemInMainHand()));
                        main.saveConfig();
                        p.sendMessage("§aVous venez de changer l'item3 en " + p.getInventory().getItemInMainHand().getItemMeta().getDisplayName());
                    }
                } else {
                    p.sendMessage("§cYou're not allowed to do this !");
                }

            } else {
                SpawnGUI spawnGUI = new SpawnGUI(p);
            }
            return true;
        }
        return false;
    }
}
