package com.zombromine.learningmod.items;

import com.zombromine.learningmod.LearningMod;
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
}
