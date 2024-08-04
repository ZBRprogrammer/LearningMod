package com.zombromine.learningmod.items;

import com.zombromine.learningmod.LearningMod;
import com.zombromine.learningmod.blocks.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTab {
    public static final DeferredRegister<CreativeModeTab>LearningModTabs = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LearningMod.MODID);
    public static final RegistryObject<CreativeModeTab>LearningModTab=LearningModTabs.register("learning_tab",
            ()-> CreativeModeTab.builder().icon(()->new ItemStack(ModItems.FILE_CRYSTALLIZATION.get()))
                    .title(Component.translatable("creativetab.learning_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.FILE_CRYSTALLIZATION.get());
                        output.accept(ModItems.WATER_CRYSTALLIZATION.get());
                        output.accept(ModItems.GRASS_CRYSTALLIZATION.get());
                        output.accept(ModBlocks.FIRE_CRYSTALLIZATION_BLOCK.get());
                        output.accept(ModBlocks.WATER_CRYSTALLIZATION_BLOCK.get());
                        output.accept(ModBlocks.GRASS_CRYSTALLIZATION_BLOCK.get());
                        output.accept(ModItems.ELEMENT_COLLECTOR.get());
                    })
                    .build());
    public static void register(IEventBus eventBus) {
        LearningModTabs.register(eventBus);
    }
}
