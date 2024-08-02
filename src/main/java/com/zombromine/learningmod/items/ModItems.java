package com.zombromine.learningmod.items;

import com.zombromine.learningmod.LearningMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    private static final DeferredRegister<Item> mod_items =DeferredRegister.create(ForgeRegistries.ITEMS, LearningMod.MODID);
    public static void register(IEventBus eventBus) {
        mod_items.register(eventBus);
    }
    public static final RegistryObject<Item> FILE_CRYSTALLIZATION=mod_items.register("fire_crystallization",
            ()->new Item(new Item.Properties()));
}
