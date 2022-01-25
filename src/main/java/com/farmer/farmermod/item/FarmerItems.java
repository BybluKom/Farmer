package com.farmer.farmermod.item;

import com.farmer.farmermod.FarmerMod;
import com.farmer.farmermod.item.custom.Chisel;
import com.farmer.farmermod.item.custom.Weather_stick;
import com.farmer.farmermod.tabs.Tabs;
import com.farmer.farmermod.block.FarmerBlocks;
import com.farmer.farmermod.item.custom.Crush;
import com.farmer.farmermod.util.Sounds;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class FarmerItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS , FarmerMod.MOD_ID);

    //properties
    public static final Item.Properties ITEM_PROPERTIES = new Item.Properties().tab(Tabs.EAT_TAB);
    public static final Item.Properties LOW_FOOD_NUTRITION = new Item.Properties().tab(Tabs.EAT_TAB).food(new FoodProperties.Builder().nutrition(1).saturationMod(0.1f).build()).stacksTo(64);
    public static final Item.Properties MEDIUM_FOOD_NUTRITION = new Item.Properties().tab(Tabs.EAT_TAB).food(new FoodProperties.Builder().nutrition(3).saturationMod(0.3f).build()).stacksTo(32);
    public static final Item.Properties HIGH_FOOD_NUTRITION = new Item.Properties().tab(Tabs.EAT_TAB).food(new FoodProperties.Builder().nutrition(6).saturationMod(0.6f).build()).stacksTo(16);
    public static final Item.Properties ULTRA_FOOD_NUTRITION = new Item.Properties().tab(Tabs.EAT_TAB).food(new FoodProperties.Builder().nutrition(8).saturationMod(1f).build()).stacksTo(4);

    //ITEMS
    public static final RegistryObject<Item> CANVAS = ITEMS.register("canvas" , () -> new Item(new Item.Properties().tab(Tabs.FARMER_TAB)));
    public static final RegistryObject<Item> CHERRY = ITEMS.register("cherry", () -> new Item(LOW_FOOD_NUTRITION));
    public static final RegistryObject<Item> PESTICIDES = ITEMS.register("pesticides", () -> new Item(new Item.Properties().tab(Tabs.FARMER_TAB)));
    public static final RegistryObject<Item> MAGIC_INGOT = ITEMS.register("magic_ingot", () -> new Item(new Item.Properties().tab(Tabs.FARMER_TAB)));
    public static final RegistryObject<Item> WEATHER = ITEMS.register("weather", () -> new Item(new Item.Properties().tab(Tabs.FARMER_TAB)));

    //tools
    public static final RegistryObject<Item> CRUSH = ITEMS.register("crush", () -> new Crush(new Item.Properties().tab(Tabs.FARMER_TAB).defaultDurability(10).setNoRepair()));
    public static final RegistryObject<Item> WEATHER_STICK = ITEMS.register("weather_stick" , () -> new Weather_stick(new Item.Properties().durability(1).tab(Tabs.FARMER_TAB).setNoRepair()));
    public static final RegistryObject<Item> CHISEL = ITEMS.register("chisel", () -> new Chisel(new Item.Properties().tab(Tabs.FARMER_TAB).defaultDurability(10)));

    //seeds and food
    public static final RegistryObject<Item> CORN = ITEMS.register("corn", () -> new Item(MEDIUM_FOOD_NUTRITION));
    public static final RegistryObject<Item> CORN_SEED = ITEMS.register("corn_seed", () -> new BlockItem(FarmerBlocks.CORN_CROP.get(), new Item.Properties().tab(Tabs.EAT_TAB)));
    public static final RegistryObject<Item> TOMATO = ITEMS.register("tomato", () -> new Item(MEDIUM_FOOD_NUTRITION));
    public static final RegistryObject<Item> TOMATO_SEED = ITEMS.register("tomato_seed", () -> new BlockItem(FarmerBlocks.TOMATO_CROP.get(), new Item.Properties().tab(Tabs.EAT_TAB)));
    public static final RegistryObject<Item> PEPPER = ITEMS.register("pepper", () -> new Item(MEDIUM_FOOD_NUTRITION));
    public static final RegistryObject<Item> PEPPER_SEED = ITEMS.register("pepper_seed", () -> new BlockItem(FarmerBlocks.PEPPER_CROP.get(), new Item.Properties().tab(Tabs.EAT_TAB)));

    //music disk
    public static final RegistryObject<Item> MORANDI_SAVE_DISC = ITEMS.register("morandi_save_disc", () -> new RecordItem(1 , Sounds.MORANDI_SAVE , new Item.Properties().tab(Tabs.FARMER_TAB).stacksTo(1)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
