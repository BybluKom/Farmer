package com.farmer.farmermod.tabs;

import com.farmer.farmermod.item.FarmerItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class Tabs{

    public static final CreativeModeTab FARMER_TAB = new CreativeModeTab("farmer_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(FarmerItems.PESTICIDES.get());
        }
    };
    public static final CreativeModeTab EAT_TAB = new CreativeModeTab("eatTab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(FarmerItems.CORN.get());
        }
    };

}
