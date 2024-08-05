package com.zombromine.learningmod.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class GrassCrystallizationBlock extends Block {
    public GrassCrystallizationBlock(Properties pProperties) {
        super(pProperties);
    }
    public static final Random RANDOM = new Random();

    public void reTick(Level pLevel, BlockPos pPos){
        pLevel.scheduleTick(pPos, this, RANDOM.nextInt(100)+50);
    }

    @Override
    protected void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pMovedByPiston) {
        if(!pLevel.isClientSide())reTick(pLevel, pPos);
        super.onPlace(pState, pLevel, pPos, pOldState, pMovedByPiston);
    }

    @Override
    protected void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if(!pLevel.isClientSide()) {
            if(RANDOM.nextFloat()>0.3)reTick(pLevel, pPos);
            for(int dx=-1; dx<=1; dx++) {
                for(int dy=-1; dy<=1; dy++) {
                    for(int dz=-1; dz<=1; dz++) {
                        if(dx==0 && dy==0 && dz==0) continue;
                        BlockPos pos = pPos.offset(dx, dy, dz);
                        BlockState state = pLevel.getBlockState(pos);
                        if(state.is(Blocks.AIR))continue;
                        BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL),pLevel,pos,null);
                    }
                }
            }
            reTick(pLevel, pPos);
        }
        super.tick(pState, pLevel, pPos, pRandom);
    }
}
