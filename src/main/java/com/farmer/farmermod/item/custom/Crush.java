package com.farmer.farmermod.item.custom;

import com.farmer.farmermod.block.FarmerBlocks;
import com.farmer.farmermod.item.FarmerItems;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;


import java.util.Objects;


public class Crush extends Item {
    public Crush(Properties prop) {
        super(prop);
    }

    public InteractionResult onItemUseFirst(ItemStack stack, UseOnContext context) {
        Level world = context.getLevel();
        BlockState clikedblock = world.getBlockState(context.getClickedPos());
        Player playerEntity = Objects.requireNonNull(context.getPlayer());
        if(!world.isClientSide){
            if(isBlock(clikedblock)){
                if(playerEntity.getCooldowns().isOnCooldown(FarmerItems.CRUSH.get())) {
                    playerEntity.displayClientMessage(new TextComponent("Item has recharge"), false);
                }else{
                    rightClicked(clikedblock, context);
                    stack.hurtAndBreak(1, playerEntity, LivingEntity::animateHurt);
                    if(isBlock(clikedblock)) {
                        playerEntity.getCooldowns().addCooldown(FarmerItems.CRUSH.get(), 100);
                    }
                }
            }
        }
        return super.onItemUseFirst(stack, context);
    }

    private void rightClicked(BlockState clikedblock, UseOnContext context) {
        if (isBlock(clikedblock)) {
            destroyBlock(context.getLevel(), context.getClickedPos());
        }
    }

    private boolean isBlock(BlockState clicked){
        return clicked.getBlock() == FarmerBlocks.PESTICIDES_ORE.get();
    }
    private void destroyBlock(Level world , BlockPos blockPos) {
        world.destroyBlock(blockPos,true);
    }
}
