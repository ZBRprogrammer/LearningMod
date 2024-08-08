package com.zombromine.learningmod.datagen;

import com.zombromine.learningmod.blocks.ModBlocks;
import com.zombromine.learningmod.items.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider{
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

//    private static final List<ItemLike> SAPPHIRE_SMELTABLES = List.of(ModItems.RAW_SAPPHIRE.get(),
//            ModBlocks.SAPPHIRE_ORE.get(), ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), ModBlocks.NETHER_SAPPHIRE_ORE.get(),
//            ModBlocks.END_STONE_SAPPHIRE_ORE.get());


    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.FIRE_CRYSTALLIZATION_BLOCK.get())
                .pattern("OOO")
                .pattern("OOO")
                .pattern("OOO")
                .define('O', ModItems.FIRE_CRYSTALLIZATION.get())
                .unlockedBy(getHasName(ModItems.FIRE_CRYSTALLIZATION.get()),has(ModItems.FIRE_CRYSTALLIZATION.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WATER_CRYSTALLIZATION_BLOCK.get())
                .pattern("OOO")
                .pattern("OOO")
                .pattern("OOO")
                .define('O', ModItems.WATER_CRYSTALLIZATION.get())
                .unlockedBy(getHasName(ModItems.WATER_CRYSTALLIZATION.get()),has(ModItems.WATER_CRYSTALLIZATION.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GRASS_CRYSTALLIZATION_BLOCK.get())
                .pattern("OOO")
                .pattern("OOO")
                .pattern("OOO")
                .define('O', ModItems.GRASS_CRYSTALLIZATION.get())
                .unlockedBy(getHasName(ModItems.GRASS_CRYSTALLIZATION.get()),has(ModItems.GRASS_CRYSTALLIZATION.get()))
                .save(recipeOutput);


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ELEMENT_COLLECTOR.get())
                .pattern("BIA")
                .pattern("ILI")
                .pattern("MI ")
                .define('L', Items.LODESTONE)
                .define('A', Items.MAGMA_CREAM)
                .define('B', Items.BLUE_ICE)
                .define('M', Items.MOSS_BLOCK)
                .define('I', Items.IRON_INGOT)
                .unlockedBy(getHasName(Items.LODESTONE),has(Items.LODESTONE))
                .unlockedBy(getHasName(Items.MAGMA_CREAM),has(Items.MAGMA_CREAM))
                .unlockedBy(getHasName(Items.BLUE_ICE),has(Items.BLUE_ICE))
                .unlockedBy(getHasName(Items.MOSS_BLOCK),has(Items.MOSS_BLOCK))
                .unlockedBy(getHasName(Items.IRON_INGOT),has(Items.IRON_INGOT))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.FIRE_CRYSTALLIZATION.get(),9)
                .requires(ModBlocks.FIRE_CRYSTALLIZATION_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.FIRE_CRYSTALLIZATION_BLOCK.get()),has(ModBlocks.FIRE_CRYSTALLIZATION_BLOCK.get()))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.WATER_CRYSTALLIZATION.get(),9)
                .requires(ModBlocks.WATER_CRYSTALLIZATION_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.WATER_CRYSTALLIZATION_BLOCK.get()),has(ModBlocks.WATER_CRYSTALLIZATION_BLOCK.get()))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.GRASS_CRYSTALLIZATION.get(),9)
                .requires(ModBlocks.GRASS_CRYSTALLIZATION_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.GRASS_CRYSTALLIZATION_BLOCK.get()),has(ModBlocks.GRASS_CRYSTALLIZATION_BLOCK.get()))
                .save(recipeOutput);
    }

//    @Override
//    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
//        oreSmelting(pWriter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 0.25f, 200, "sapphire");
//        oreBlasting(pWriter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 0.25f, 100, "sapphire");
//
//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SAPPHIRE_BLOCK.get())
//                .pattern("SSS")
//                .pattern("SSS")
//                .pattern("SSS")
//                .define('S', ModItems.SAPPHIRE.get())
//                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
//                .save(pWriter);
//
//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 9)
//                .requires(ModBlocks.SAPPHIRE_BLOCK.get())
//                .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(ModBlocks.SAPPHIRE_BLOCK.get()))
//                .save(pWriter);
//    }
//
//    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
//        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
//    }
//
//    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
//        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
//    }
//
//    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
//        for(ItemLike itemlike : pIngredients) {
//            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
//                    pExperience, pCookingTime, pCookingSerializer)
//                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
//                    .save(pFinishedRecipeConsumer,  TutorialMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
//        }
//    }
}
