package com.zombromine.learningmod.datagen;

import com.zombromine.learningmod.LearningMod;
import com.zombromine.learningmod.blocks.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, LearningMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                ModBlocks.FIRE_CRYSTALLIZATION_BLOCK.get(),
                ModBlocks.WATER_CRYSTALLIZATION_BLOCK.get(),
                ModBlocks.GRASS_CRYSTALLIZATION_BLOCK.get()
        );

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(
                ModBlocks.FIRE_CRYSTALLIZATION_BLOCK.get(),
                ModBlocks.WATER_CRYSTALLIZATION_BLOCK.get(),
                ModBlocks.GRASS_CRYSTALLIZATION_BLOCK.get()
        );
    }
}
