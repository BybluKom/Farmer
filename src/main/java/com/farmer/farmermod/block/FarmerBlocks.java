package com.farmer.farmermod.block;

import com.farmer.farmermod.FarmerMod;
import com.farmer.farmermod.block.custom.Magic_block;
import com.farmer.farmermod.tabs.Tabs;
import com.farmer.farmermod.block.custom.Seeds;
import com.farmer.farmermod.item.FarmerItems;
import com.farmer.farmermod.world.features.tree.CherryTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


public class FarmerBlocks extends Block {
    public FarmerBlocks(Properties p_i48440_1_) {
        super(p_i48440_1_);
    }
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS , FarmerMod.MOD_ID);

    //properties
    public static final BlockBehaviour.Properties SEED_PROPERTY = BlockBehaviour.Properties.copy(Blocks.WHEAT).noCollission().randomTicks().sound(SoundType.CROP);
    //ORES
    public static final RegistryObject<Block> PESTICIDES_ORE = registerBlock("pesticides_ore" , () -> new Block(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).strength(-1f , 36000)));
    public static final RegistryObject<Block> MAGIC_ORE = registerBlock("magic_ore" , () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).strength(2f , 3f).requiresCorrectToolForDrops()));
    //BLOCKS
    public static final RegistryObject<Block> MAGIC_BLOCK = registerBlock("magic_block" , () -> new Magic_block(BlockBehaviour.Properties.of(Material.STONE).lightLevel((p_50876_) -> 15).strength(6f , 5f).requiresCorrectToolForDrops()));
    //CHERRY TREE
    public static final RegistryObject<Block> CHERRY_LEAVES =registerBlock("cherry_leaves" , () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).randomTicks().sound(SoundType.AZALEA_LEAVES).strength(0.25f)) {
        @Override
        public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return true;
        }
        @Override
        public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face)
        {
            return 60;
        }
        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face)
        {
            return 310;
        }
    });
    public static final RegistryObject<Block> CHERRY_SAPLING =registerBlock("cherry_sapling" , () -> new SaplingBlock(new CherryTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> CHERRY_LOG =registerBlock("cherry_log" , () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)){
        @Override
        public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return true;
        }
        @Override
        public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face)
        {
            return 30;
        }
        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face)
        {
            return 150;
        }
    });
    public static final RegistryObject<Block> CHERRY_WOOD =registerBlock("cherry_wood" , () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)){
        @Override
        public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return true;
        }
        @Override
        public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face)
        {
            return 30;
        }
        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face)
        {
            return 150;
        }
    });
    public static final RegistryObject<Block> STRIPPED_CHERRY_LOG =registerBlock("stripped_cherry_log" , () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)){
        @Override
        public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return true;
        }
        @Override
        public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face)
        {
            return 20;
        }
        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face)
        {
            return 120;
        }
    });
    public static final RegistryObject<Block> STRIPPED_CHERRY_WOOD =registerBlock("stripped_cherry_wood" , () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)){
        @Override
        public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return true;
        }
        @Override
        public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face)
        {
            return 20;
        }
        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face)
        {
            return 120;
        }
    });
    public static final RegistryObject<Block> CHERRY_PLANKS =registerBlock("cherry_planks" , () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)){
        @Override
        public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
            return true;
        }
        @Override
        public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face)
        {
            return 30;
        }
        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face)
        {
            return 200;
        }
    });
    //CROPS
    public static final RegistryObject<Block> TOMATO_CROP = BLOCKS.register("tomato_crop", () -> new Seeds(SEED_PROPERTY));
    public static final RegistryObject<Block> CORN_CROP = BLOCKS.register("corn_crop", () -> new Seeds(SEED_PROPERTY));
    public static final RegistryObject<Block> PEPPER_CROP = BLOCKS.register("pepper_crop", () -> new Seeds(SEED_PROPERTY));

    private static <B extends Block>RegistryObject<B> registerBlock (String name , Supplier<B> block){
        RegistryObject<B> toReturn = BLOCKS.register(name , block);
        registerBlockItem(name , toReturn);
        return toReturn;
    }

    private static <B extends Block> void registerBlockItem(String name , RegistryObject<B> block){
        FarmerItems.ITEMS.register(name , () -> new BlockItem(block.get(), new Item.Properties().tab(Tabs.FARMER_TAB)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
