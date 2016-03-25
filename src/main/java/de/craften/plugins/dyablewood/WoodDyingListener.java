package de.craften.plugins.dyablewood;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ShapelessRecipe;

import java.util.Collection;

/**
 * A listeners for players that try to dye wood.
 */
public class WoodDyingListener implements Listener {
    private final Collection<ShapelessRecipe> recipes;

    public WoodDyingListener(Collection<ShapelessRecipe> recipes) {
        this.recipes = recipes;
    }

    @EventHandler
    public void onCraft(CraftItemEvent e) {
        if (e.getRecipe() instanceof ShapelessRecipe && !e.getWhoClicked().hasPermission("dyablewood.dye")) {
            for (ShapelessRecipe recipe : recipes) {
                if (ShapelessRecipeEqualityChecker.isEqual(recipe, (ShapelessRecipe) e.getRecipe())) {
                    e.getWhoClicked().sendMessage(ChatColor.RED + "You have no permission to dye wood.");
                    e.setCancelled(true);
                    return;
                }
            }
        }
    }
}
