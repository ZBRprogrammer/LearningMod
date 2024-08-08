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
    public static final RegistryObject<Item> FIRE_CRYSTALLIZATION = ModItems.register("fire_crystallization",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> FIRE_DEBRIS = ModItems.register("fire_debris",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> FIRE_POLYMER_LEVEL_1 = ModItems.register("fire_polymer_level_1",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> FIRE_POLYMER_LEVEL_2 = ModItems.register("fire_polymer_level_2",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> FIRE_POLYMER_LEVEL_3 = ModItems.register("fire_polymer_level_3",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> FIRE_POLYMER_LEVEL_4 = ModItems.register("fire_polymer_level_4",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> FIRE_POLYMER_LEVEL_5 = ModItems.register("fire_polymer_level_5",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> WATER_CRYSTALLIZATION= ModItems.register("water_crystallization",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> WATER_DEBRIS = ModItems.register("water_debris",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> WATER_POLYMER_LEVEL_1 = ModItems.register("water_polymer_level_1",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> WATER_POLYMER_LEVEL_2 = ModItems.register("water_polymer_level_2",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> WATER_POLYMER_LEVEL_3 = ModItems.register("water_polymer_level_3",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> WATER_POLYMER_LEVEL_4 = ModItems.register("water_polymer_level_4",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> WATER_POLYMER_LEVEL_5 = ModItems.register("water_polymer_level_5",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> GRASS_CRYSTALLIZATION= ModItems.register("grass_crystallization",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> GRASS_DEBRIS = ModItems.register("grass_debris",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> GRASS_POLYMER_LEVEL_1 = ModItems.register("grass_polymer_level_1",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> GRASS_POLYMER_LEVEL_2 = ModItems.register("grass_polymer_level_2",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> GRASS_POLYMER_LEVEL_3 = ModItems.register("grass_polymer_level_3",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> GRASS_POLYMER_LEVEL_4 = ModItems.register("grass_polymer_level_4",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> GRASS_POLYMER_LEVEL_5 = ModItems.register("grass_polymer_level_5",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item>ELEMENT_COLLECTOR= ModItems.register("element_collector",
            ()->new ElementCollector(new Item.Properties().durability(2000)));
}
