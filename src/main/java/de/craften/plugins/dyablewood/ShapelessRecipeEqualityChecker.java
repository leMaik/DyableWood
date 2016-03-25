package de.craften.plugins.dyablewood;

import org.bukkit.inventory.ShapelessRecipe;

/**
 * A comparator for shapeless recipes.
 */
public class ShapelessRecipeEqualityChecker {
    /**
     * Checks if the two given recipes are equal.
     *
     * @param a a recipe
     * @param b another recipe
     * @return true of both recipes are equal, false if not
     */
    public static boolean isEqual(ShapelessRecipe a, ShapelessRecipe b) {
        return a.getResult().equals(b.getResult()) && a.getIngredientList().equals(b.getIngredientList());
    }
}
