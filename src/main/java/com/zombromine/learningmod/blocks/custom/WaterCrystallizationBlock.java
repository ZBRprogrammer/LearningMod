package com.zombromine.learningmod.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class WaterCrystallizationBlock extends Block {
    public WaterCrystallizationBlock(Properties pProperties) {
        super(pProperties);
    }
    public static final Random RANDOM = new Random();

    @Override
    protected void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pMovedByPiston) {
        super.onPlace(pState, pLevel, pPos, pOldState, pMovedByPiston);
        if(!pLevel.isClientSide())pLevel.scheduleTick(pPos, this, RANDOM.nextInt(4)+1);
    }

    @Override
    protected void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if(!pLevel.isClientSide()) {
            for(int dx=-1;dx<=1;dx++) {
                for(int dy=-1;dy<=1;dy++) {
                    for(int dz=-1;dz<=1;dz++) {
                        BlockPos pos = pPos.offset(dx,dy,dz);
                        BlockState state = pLevel.getBlockState(pos);
                        if(state.is(Blocks.LAVA)){
                            pLevel.setBlock(pos,Blocks.OBSIDIAN.defaultBlockState(), 3);
                        }
                        else if(state.is(Blocks.FIRE)){
                            pLevel.setBlock(pos,Blocks.AIR.defaultBlockState(), 3);
                        }
                    }
                }
            }
            pLevel.scheduleTick(pPos, this, RANDOM.nextInt(4)+1);
        }
        super.tick(pState, pLevel, pPos, pRandom);
    }
}
