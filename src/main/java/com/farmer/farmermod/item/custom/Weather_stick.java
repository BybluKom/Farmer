package com.farmer.farmermod.item.custom;

import com.farmer.farmermod.block.FarmerBlocks;
import com.farmer.farmermod.block.custom.Magic_block;
import com.farmer.farmermod.item.FarmerItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.chat.ChatListener;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.LevelData;
import net.minecraftforge.event.world.NoteBlockEvent;

import java.util.Objects;
import java.util.TimerTask;

public class Weather_stick extends Item {
    public Weather_stick(Properties properties) {
        super(properties);
    }

    public static int timer = 0;
    public InteractionResult onItemUseFirst(ItemStack stack, UseOnContext context) {
        Level world = context.getLevel();
        Player playerEntity = Objects.requireNonNull(context.getPlayer());
        BlockState state = context.getLevel().getBlockState(context.getClickedPos());
        if (!world.isClientSide()) {
            if(playerEntity.getItemInHand(InteractionHand.MAIN_HAND).is((FarmerItems.WEATHER_STICK.get()))) {
                if (world.isRaining() || world.isThundering() || (world.isThundering() && world.isRaining())) {
                    playerEntity.displayClientMessage(new TextComponent("Raining!"), false);
                } else {
                    RightClick(stack, world, context);
                    if (IsBlock(state)) {
                        stack.hurtAndBreak(1, playerEntity, LivingEntity::animateHurt);
                        timer = 14000;
                        Magic_block.uses--;
                        if(Magic_block.uses == 0){
                            destroyBlock(context.getLevel() , context.getClickedPos());
                        }
                    }
                }
            }
        }
        return super.onItemUseFirst(stack, context);
    }

    public ItemStack RightClick(ItemStack stack, Level world,UseOnContext context) {
        LevelData worldInfo = world.getLevelData();
        BlockState state = world.getBlockState(context.getClickedPos());
        Player player = context.getPlayer();
            if(IsBlock(state)){
                if (!worldInfo.isRaining()) {
                    worldInfo.setRaining(true);
                    assert player != null;
                    player.displayClientMessage(new TextComponent("Starting"), false);
                }
            }else{
                assert player != null;
                player.displayClientMessage(new TextComponent("You need the magic block!"), false);
            }
            return stack;
        }

    public boolean IsBlock(BlockState state){
        return state.getBlock() == FarmerBlocks.MAGIC_BLOCK.get();
    }
    private void destroyBlock(Level world , BlockPos blockPos) {
        world.destroyBlock(blockPos,false);
    }
}
