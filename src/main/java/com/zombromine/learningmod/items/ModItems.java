package com.zombromine.learningmod.items;

import com.zombromine.learningmod.LearningMod;
import com.zombromine.learningmod.items.custom.ElementCollector;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ModItems =DeferredRegister.create(ForgeRegistries.ITEMS, LearningMod.MODID);
    public static void register(IEventBus eventBus) {
        ModItems.register(eventBus);
    }
    public static final RegistryObject<Item> FILE_CRYSTALLIZATION= ModItems.register("fire_crystallization",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> WATER_CRYSTALLIZATION= ModItems.register("water_crystallization",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> GRASS_CRYSTALLIZATION= ModItems.register("grass_crystallization",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item>ELEMENT_COLLECTOR= ModItems.register("element_collector",
            ()->new ElementCollector(new Item.Properties().durability(2000)));
}
