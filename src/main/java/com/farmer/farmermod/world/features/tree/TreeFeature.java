package com.farmer.farmermod.world.features.tree;

import com.farmer.farmermod.FarmerMod;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.material.Material;

import java.util.Random;

public class TreeFeature extends Feature<TreeConfiguration> {
    public TreeFeature(Codec<TreeConfiguration> pCodec) {
        super(pCodec);
    }

    private static final ResourceLocation CHERRY_TREE_FEATURE = new ResourceLocation(FarmerMod.MOD_ID, "berry_tree_feature");


    public static boolean isAirOrLeavesAt(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, (state) -> {
            return state.isAir() || state.is(BlockTags.LEAVES);
        });
    }

    public static boolean isAirOrLeavesOrLogsAt(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, (state) -> {
            return state.isAir() || state.is(BlockTags.LEAVES) || state.is(BlockTags.LOGS);
        });
    }

    private static boolean isSandOrClayAt(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, (state) -> {
            Material material = state.getMaterial();
            return material == Material.SAND || material == Material.CLAY;
        });
    }

    private static boolean isDirtOrFarmlandAt(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, (state) -> {
            Block block = state.getBlock();
            return isDirt(state) || block == Blocks.FARMLAND;
        });
    }

    @Override
    public boolean place(FeaturePlaceContext<TreeConfiguration> context) {
        WorldGenLevel reader = context.level();
        TreeConfiguration config = context.config();
        BlockPos pos = context.origin();
        Random rand = context.random();

        if (!reader.getBlockState(pos).isAir()) {
            if (reader.getBlockState(pos).getMaterial() == Material.WATER || reader.getBlockState(pos.above()).getMaterial() == Material.WATER
                    && (!reader.getBlockState(pos.above()).isAir()
                    || (!isSandOrClayAt(reader, pos.below()) && !isDirtOrFarmlandAt(reader, pos.below())))) {
                return false;
            }
        }
        else {
            if (!isDirtOrFarmlandAt(reader, pos.below()))
                return false;
        }

        Feature.TREE.place(context);

        return true;
    }
}
