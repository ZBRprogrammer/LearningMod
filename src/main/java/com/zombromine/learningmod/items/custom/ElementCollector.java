package com.zombromine.learningmod.items.custom;

import com.zombromine.learningmod.items.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;
import java.util.Random;

public class ElementCollector extends Item {
    public ElementCollector(Properties pProperties) {
        super(pProperties);
    }

    private static final Random rand=new Random(System.currentTimeMillis());

    private static void Update(UseOnContext pContext, Item giveItem, int count, Block setBlock, BlockPos pos){
        Player player=pContext.getPlayer();
        Level level=pContext.getLevel();
        ItemStack stack= new ItemStack(giveItem,count);
        assert player != null;
        if(!player.getInventory().add(stack)){
            player.drop(stack,false);
        }
        level.setBlock(pos,setBlock.defaultBlockState(), 3);
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        pTooltipComponents.add(Component.translatable("tooltip.learningmod.element_collector"));
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level=pContext.getLevel();
        Player player= pContext.getPlayer();
        final var hand=player.getUsedItemHand();
        ItemStack itemStack=player.getItemInHand(hand);
        if(!level.isClientSide()){
            BlockPos pos = pContext.getClickedPos();
            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    if(pos.getY()+j<-64)continue;
                    for(int k=-1;k<=1;k++){
                        BlockPos new_pos=new BlockPos(pos.getX()+i,pos.getY()+j,pos.getZ()+k);
                        BlockState state=pContext.getLevel().getBlockState(new_pos);
                        int num=1+rand.nextInt(2);
                        int zero=rand.nextInt(2);
                        int ran=rand.nextInt(100);
                        int p=ran>=80?1:0;
                        if(state.is(Blocks.GRASS_BLOCK)){
                            Update(pContext,ModItems.GRASS_DEBRIS.get(),p,Blocks.DIRT,new_pos);
                        }
                        else if(state.is(BlockTags.LEAVES)||state.is(Blocks.SHORT_GRASS)||state.is(Blocks.TALL_GRASS)||state.is(Blocks.SEAGRASS)||state.is(Blocks.TALL_SEAGRASS)||state.is(Blocks.MOSS_BLOCK)||state.is(Blocks.MOSS_CARPET)){
                            Update(pContext,ModItems.GRASS_POLYMER_LEVEL_1.get(),p,Blocks.AIR,new_pos);
                        }
                        else if(state.is(Blocks.MOSSY_COBBLESTONE)){
                            Update(pContext,ModItems.GRASS_DEBRIS.get(),zero,Blocks.COBBLESTONE,new_pos);
                        }
                        else if(state.is(Blocks.MOSSY_COBBLESTONE_SLAB)){
                            Update(pContext,ModItems.GRASS_DEBRIS.get(),zero,Blocks.COBBLESTONE_SLAB,new_pos);
                        }
                        else if(state.is(Blocks.MOSSY_COBBLESTONE_STAIRS)){
                            Update(pContext,ModItems.GRASS_DEBRIS.get(),zero,Blocks.COBBLESTONE_STAIRS,new_pos);
                        }
                        else if(state.is(Blocks.MOSSY_COBBLESTONE_WALL)){
                            Update(pContext,ModItems.GRASS_DEBRIS.get(),zero,Blocks.COBBLESTONE_WALL,new_pos);
                        }
                        else if(state.is(Blocks.MOSSY_STONE_BRICK_SLAB)){
                            Update(pContext,ModItems.GRASS_DEBRIS.get(),zero,Blocks.STONE_BRICK_SLAB,new_pos);
                        }
                        else if(state.is(Blocks.MOSSY_STONE_BRICK_STAIRS)){
                            Update(pContext,ModItems.GRASS_DEBRIS.get(),zero,Blocks.STONE_BRICK_STAIRS,new_pos);
                        }
                        else if(state.is(Blocks.MOSSY_STONE_BRICKS)){
                            Update(pContext,ModItems.GRASS_DEBRIS.get(),zero,Blocks.STONE_BRICKS,new_pos);
                        }
                        else if(state.is(Blocks.MOSSY_STONE_BRICK_WALL)){
                            Update(pContext,ModItems.GRASS_DEBRIS.get(),zero,Blocks.STONE_BRICK_WALL,new_pos);
                        }
                        else if(state.is(Blocks.INFESTED_MOSSY_STONE_BRICKS)){
                            Update(pContext,ModItems.GRASS_DEBRIS.get(),zero,Blocks.INFESTED_STONE_BRICKS,new_pos);
                        }
                        if(state.is(Blocks.WATER)||state.is(BlockTags.ICE)){
                            Update(pContext,ModItems.WATER_POLYMER_LEVEL_1.get(),p,Blocks.AIR,new_pos);
                        }
                        else if(state.is(Blocks.WET_SPONGE)){
                            Update(pContext,ModItems.WATER_DEBRIS.get(),num+2,Blocks.SPONGE,new_pos);
                        }
                        else if(state.is(Blocks.WATER_CAULDRON)){
                            Update(pContext,ModItems.WATER_POLYMER_LEVEL_1.get(),num+2,Blocks.CAULDRON,new_pos);
                        }
                        if(state.is(Blocks.LAVA_CAULDRON)){
                            Update(pContext,ModItems.FIRE_POLYMER_LEVEL_1.get(),num+2,Blocks.CAULDRON,new_pos);
                        }
                        else if(state.is(Blocks.LAVA)||state.is(Blocks.FIRE)){
                            Update(pContext,ModItems.FIRE_POLYMER_LEVEL_1.get(),num,Blocks.AIR,new_pos);
                        }
                        else if(state.is(Blocks.MAGMA_BLOCK)){
                            Update(pContext,ModItems.FIRE_DEBRIS.get(),num,Blocks.NETHERRACK,new_pos);
                        }
                    }
                }
            }
        }
        itemStack.hurtAndBreak(1,player,LivingEntity.getSlotForHand(hand));
        return InteractionResult.SUCCESS;
    }
}
