package com.zombromine.learningmod.blocks;

import com.zombromine.learningmod.LearningMod;
import com.zombromine.learningmod.items.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> ModBlocks=DeferredRegister.create(ForgeRegistries.BLOCKS, LearningMod.MODID);
    public static void register(IEventBus eventBus) {
        ModBlocks.register(eventBus);
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name,RegistryObject<T>block){
        return ModItems.ModItems.register(name,()->new BlockItem(block.get(),new Item.Properties()));
    }
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T>block){
        RegistryObject<T>toReturn=ModBlocks.register(name,block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }
    public static final RegistryObject<Block>FIRE_CRYSTALLIZATION_BLOCK=registerBlock("fire_crystallization_block",
            ()->new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)
                    .requiresCorrectToolForDrops()
                    .explosionResistance(120.0F)
                    .strength(6.0F,6.5F)
            ));
    public static final RegistryObject<Block>WATER_CRYSTALLIZATION_BLOCK=registerBlock("water_crystallization_block",
            ()->new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)
                    .requiresCorrectToolForDrops()
                    .explosionResistance(120.0F)
                    .strength(6.0F,6.5F)
            ));
    public static final RegistryObject<Block>GRASS_CRYSTALLIZATION_BLOCK=registerBlock("grass_crystallization_block",
            ()->new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)
                    .requiresCorrectToolForDrops()
                    .explosionResistance(120.0F)
                    .strength(6.0F,6.5F)
            ));
}
