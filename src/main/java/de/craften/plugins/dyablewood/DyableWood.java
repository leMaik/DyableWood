package de.craften.plugins.dyablewood;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.material.Dye;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A plugin for dying wood.
 */
public class DyableWood extends JavaPlugin {
    private List<Recipe> recipes;

    @Override
    public void onEnable() {
        recipes = new ArrayList<>();
        registerPlankRecipes();
    }

    @Override
    public void onDisable() {
        Iterator<Recipe> recipeIterator = getServer().recipeIterator();
        while (recipeIterator.hasNext()) {
            if (recipes.contains(recipeIterator.next())) {
                recipeIterator.remove();
            }
        }
    }

    private void registerPlankRecipes() {
        for (short woodType = 0; woodType <= 5; woodType++) {
            if (woodType != 0) {
                ShapelessRecipe recipe = new ShapelessRecipe(new ItemStack(Material.WOOD, 1, (short) 0));
                recipe.addIngredient(1, new Dye(DyeColor.YELLOW)); //dandelion yellow
                recipe.addIngredient(1, new ItemStack(Material.WOOD, 1, woodType).getData());
                getServer().addRecipe(recipe);
                recipes.add(recipe);
            }
            if (woodType != 1 && woodType != 5) {
                ShapelessRecipe recipe = new ShapelessRecipe(new ItemStack(Material.WOOD, 1, (short) 1));
                recipe.addIngredient(1, new Dye(DyeColor.BROWN)); //cocoa beans
                recipe.addIngredient(1, new ItemStack(Material.WOOD, 1, woodType).getData());
                getServer().addRecipe(recipe);
                recipes.add(recipe);
            }
            if (woodType != 2 && woodType != 5) {
                ShapelessRecipe recipe = new ShapelessRecipe(new ItemStack(Material.WOOD, 1, (short) 2));
                recipe.addIngredient(1, new Dye(DyeColor.WHITE)); //bone meal
                recipe.addIngredient(1, new ItemStack(Material.WOOD, 1, woodType).getData());
                getServer().addRecipe(recipe);
                recipes.add(recipe);
            }
            if (woodType != 3) {
                ShapelessRecipe recipe = new ShapelessRecipe(new ItemStack(Material.WOOD, 1, (short) 3));
                recipe.addIngredient(1, new Dye(DyeColor.RED)); //rose red
                recipe.addIngredient(1, new ItemStack(Material.WOOD, 1, woodType).getData());
                getServer().addRecipe(recipe);
                recipes.add(recipe);
            }
            if (woodType != 4) {
                ShapelessRecipe recipe = new ShapelessRecipe(new ItemStack(Material.WOOD, 1, (short) 4));
                recipe.addIngredient(1, new Dye(DyeColor.ORANGE)); //orange dye
                recipe.addIngredient(1, new ItemStack(Material.WOOD, 1, woodType).getData());
                getServer().addRecipe(recipe);
                recipes.add(recipe);
            }
            if (woodType != 5) {
                ShapelessRecipe recipe = new ShapelessRecipe(new ItemStack(Material.WOOD, 1, (short) 5));
                recipe.addIngredient(1, new Dye(DyeColor.BROWN)); //cocoa beans
                if (woodType != 1) {
                    recipe.addIngredient(1, new Dye(DyeColor.BROWN)); //cocoa beans
                }
                recipe.addIngredient(1, new ItemStack(Material.WOOD, 1, woodType).getData());
                getServer().addRecipe(recipe);
                recipes.add(recipe);
            }
        }
        {
            ShapelessRecipe recipe = new ShapelessRecipe(new ItemStack(Material.WOOD, 1, (short) 1));
            recipe.addIngredient(1, new Dye(DyeColor.WHITE)); //bone meal
            recipe.addIngredient(1, new ItemStack(Material.WOOD, 1, (short) 5).getData());
            getServer().addRecipe(recipe);
            recipes.add(recipe);
        }
    }
}
