package com.zombromine.learningmod.blocks.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class FireCrystallizationBlock extends Block {
    public FireCrystallizationBlock(Properties pProperties) {
        super(pProperties);
    }

    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if (pEntity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)pEntity)) {
            pEntity.hurt(pLevel.damageSources().hotFloor(), 2.0F);
        }
        super.stepOn(pLevel, pPos, pState, pEntity);
    }

    private static final Random RANDOM = new Random();

    @Override
    protected void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pMovedByPiston) {
        super.onPlace(pState, pLevel, pPos, pOldState, pMovedByPiston);
        if(!pLevel.isClientSide()) {
            pLevel.scheduleTick(pPos, this, RANDOM.nextInt(4) + 1);
        }
    }

    @Override
    protected void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if(!pLevel.isClientSide()) {
            if(RANDOM.nextFloat()<0.5F){
                for(int dx=-1;dx<=1;dx++){
                    for(int dy=-1;dy<=1;dy++){
                        for(int dz=-1;dz<=1;dz++){
                            BlockPos pos = pPos.offset(dx,dy,dz);
                            if(pLevel.getBlockState(pos).is(Blocks.AIR)){
                                if(hasFlammableBlockNearby(pLevel,pos)){
                                    pLevel.setBlock(pos,Blocks.FIRE.defaultBlockState(),3);
                                }
                            }
                            else if(pLevel.getBlockState(pos).is(Blocks.WATER)){
                                if((dx!=0&&dy!=0)||(dy!=0&&dz!=0)||(dx!=0&&dz!=0))continue;
                                pLevel.setBlock(pos,Blocks.STONE.defaultBlockState(),3);
                            }
                        }
                    }
                }
            }
        }
        if(!pLevel.isClientSide()) {
            pLevel.scheduleTick(pPos, this, RANDOM.nextInt(4) + 1);
        }
        super.tick(pState, pLevel, pPos, pRandom);
    }
    public boolean hasFlammableBlockNearby(Level pLevel, BlockPos pPos) {
        for(int dx=-1;dx<=1;dx++){
            for(int dy=-1;dy<=1;dy++){
                for(int dz=-1;dz<=1;dz++){
                    if((dx!=0&&dy!=0)||(dy!=0&&dz!=0)||(dx!=0&&dz!=0))continue;
                    BlockPos pos = pPos.offset(dx,dy,dz);
                    BlockState state = pLevel.getBlockState(pos);
                    if (state.isFlammable(pLevel,pos,null)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
