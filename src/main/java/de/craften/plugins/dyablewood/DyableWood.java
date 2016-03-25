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
    private List<ShapelessRecipe> recipes;

    @Override
    public void onEnable() {
        recipes = new ArrayList<>();

        //Planks
        registerDyeRecipes(
                new ItemStack(Material.WOOD, 1, (short) 0),
                new ItemStack(Material.WOOD, 1, (short) 1),
                new ItemStack(Material.WOOD, 1, (short) 2),
                new ItemStack(Material.WOOD, 1, (short) 3),
                new ItemStack(Material.WOOD, 1, (short) 4),
                new ItemStack(Material.WOOD, 1, (short) 5));

        //Slabs
        registerDyeRecipes(
                new ItemStack(Material.WOOD_STEP, 1, (short) 0),
                new ItemStack(Material.WOOD_STEP, 1, (short) 1),
                new ItemStack(Material.WOOD_STEP, 1, (short) 2),
                new ItemStack(Material.WOOD_STEP, 1, (short) 3),
                new ItemStack(Material.WOOD_STEP, 1, (short) 4),
                new ItemStack(Material.WOOD_STEP, 1, (short) 5));

        //Doors
        registerDyeRecipes(
                new ItemStack(Material.WOOD_DOOR),
                new ItemStack(Material.SPRUCE_DOOR_ITEM),
                new ItemStack(Material.BIRCH_DOOR_ITEM),
                new ItemStack(Material.JUNGLE_DOOR_ITEM),
                new ItemStack(Material.ACACIA_DOOR_ITEM),
                new ItemStack(Material.DARK_OAK_DOOR_ITEM));

        //Stairs
        registerDyeRecipes(
                new ItemStack(Material.WOOD_STAIRS),
                new ItemStack(Material.SPRUCE_WOOD_STAIRS),
                new ItemStack(Material.BIRCH_WOOD_STAIRS),
                new ItemStack(Material.JUNGLE_WOOD_STAIRS),
                new ItemStack(Material.ACACIA_STAIRS),
                new ItemStack(Material.DARK_OAK_STAIRS));

        //Fences
        registerDyeRecipes(
                new ItemStack(Material.FENCE),
                new ItemStack(Material.SPRUCE_FENCE),
                new ItemStack(Material.BIRCH_FENCE),
                new ItemStack(Material.JUNGLE_FENCE),
                new ItemStack(Material.ACACIA_FENCE),
                new ItemStack(Material.DARK_OAK_FENCE));

        //Fences gates
        registerDyeRecipes(
                new ItemStack(Material.FENCE_GATE),
                new ItemStack(Material.SPRUCE_FENCE_GATE),
                new ItemStack(Material.BIRCH_FENCE_GATE),
                new ItemStack(Material.JUNGLE_FENCE_GATE),
                new ItemStack(Material.ACACIA_FENCE_GATE),
                new ItemStack(Material.DARK_OAK_FENCE_GATE));

        getServer().getPluginManager().registerEvents(new WoodDyingListener(recipes), this);
    }

    @Override
    public void onDisable() {
        Iterator<Recipe> recipeIterator = getServer().recipeIterator();
        while (recipeIterator.hasNext()) {
            Recipe nextRecipe = recipeIterator.next();
            if (nextRecipe instanceof ShapelessRecipe) {
                Iterator<ShapelessRecipe> dyableWoodRecipes = recipes.iterator();
                while (dyableWoodRecipes.hasNext()) {
                    if (ShapelessRecipeEqualityChecker.isEqual(dyableWoodRecipes.next(), (ShapelessRecipe) nextRecipe)) {
                        recipeIterator.remove();
                        dyableWoodRecipes.remove();
                        break;
                    }
                }
            }
        }
    }

    private void registerDyeRecipes(ItemStack oakItem, ItemStack spruceItem, ItemStack birchItem, ItemStack jungleItem,
                                    ItemStack acaciaItem, ItemStack darkOakItem) {
        //any (except oak wood) + yellow dye = oak wood
        addRecipe(spruceItem, DyeColor.YELLOW, 1, oakItem);
        addRecipe(birchItem, DyeColor.YELLOW, 1, oakItem);
        addRecipe(jungleItem, DyeColor.YELLOW, 1, oakItem);
        addRecipe(acaciaItem, DyeColor.YELLOW, 1, oakItem);
        addRecipe(darkOakItem, DyeColor.YELLOW, 1, oakItem);

        //any (except spruce and dark oak wood) + cacoa beans = spruce wood
        addRecipe(oakItem, DyeColor.BROWN, 1, spruceItem);
        addRecipe(birchItem, DyeColor.BROWN, 1, spruceItem);
        addRecipe(jungleItem, DyeColor.BROWN, 1, spruceItem);
        addRecipe(acaciaItem, DyeColor.BROWN, 1, spruceItem);

        //any (except birch and dark oak wood) + bone meal = birch wood
        addRecipe(oakItem, DyeColor.WHITE, 1, birchItem);
        addRecipe(spruceItem, DyeColor.WHITE, 1, birchItem);
        addRecipe(jungleItem, DyeColor.WHITE, 1, birchItem);
        addRecipe(acaciaItem, DyeColor.WHITE, 1, birchItem);

        //any (except jungle wood) + rose red = jungle wood
        addRecipe(oakItem, DyeColor.RED, 1, jungleItem);
        addRecipe(spruceItem, DyeColor.RED, 1, jungleItem);
        addRecipe(birchItem, DyeColor.RED, 1, jungleItem);
        addRecipe(acaciaItem, DyeColor.RED, 1, jungleItem);
        addRecipe(darkOakItem, DyeColor.RED, 1, jungleItem);

        //any (except acacia wood) + orange dye = acacia wood
        addRecipe(oakItem, DyeColor.ORANGE, 1, acaciaItem);
        addRecipe(spruceItem, DyeColor.ORANGE, 1, acaciaItem);
        addRecipe(birchItem, DyeColor.ORANGE, 1, acaciaItem);
        addRecipe(jungleItem, DyeColor.ORANGE, 1, acaciaItem);
        addRecipe(darkOakItem, DyeColor.ORANGE, 1, acaciaItem);

        //any (except dark oak and spruce wood) + 2 cocoa beans = dark oak wood
        addRecipe(oakItem, DyeColor.BROWN, 2, darkOakItem);
        addRecipe(birchItem, DyeColor.BROWN, 2, darkOakItem);
        addRecipe(jungleItem, DyeColor.BROWN, 2, darkOakItem);
        addRecipe(acaciaItem, DyeColor.BROWN, 2, darkOakItem);

        //spruce wood + cocoa beans = dark oak wood
        addRecipe(spruceItem, DyeColor.BROWN, 1, darkOakItem);

        //dark oak wood + bone meal = spruce wood
        addRecipe(darkOakItem, DyeColor.WHITE, 1, spruceItem);
    }

    private void addRecipe(ItemStack inputItem, DyeColor dye, int count, ItemStack outputItem) {
        ShapelessRecipe recipe = new ShapelessRecipe(outputItem);
        recipe.addIngredient(count, new Dye(dye));
        recipe.addIngredient(1, inputItem.getData());
        getServer().addRecipe(recipe);
        recipes.add(recipe);
    }
}
