package com.zombromine.learningmod;

import com.zombromine.learningmod.blocks.ModBlocks;
import com.zombromine.learningmod.items.ModCreativeTab;
import com.zombromine.learningmod.items.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(LearningMod.MODID)
public class LearningMod
{
    public static final String MODID = "learningmod";
    public LearningMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModCreativeTab.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event){
        if(event.getTabKey()==CreativeModeTabs.INGREDIENTS){
            event.accept(ModItems.FIRE_CRYSTALLIZATION);
        }
    }
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
        }
    }
}
