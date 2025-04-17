package net.takumii.lootoverhaul.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableSource;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.function.SetEnchantmentsLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.loot.provider.number.LootNumberProvider;
import net.minecraft.registry.RegistryKey;

import java.util.HashMap;
import java.util.Map;

public class ModLootTableModifiers {
    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register(ModLootTableModifiers::modifyLootTable);
    }

    private static void modifyLootTable(RegistryKey<LootTable> id, LootTable.Builder builder, LootTableSource source, Object unused) {
        if (!source.isBuiltin()) return;

        String path = id.getValue().getPath();

        // Chicken
        if (path.equals("entities/chicken")) {
            builder.pool(LootPool.builder()
                    .with(ItemEntry.builder(Items.CHICKEN)
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3, 5))))
                    .build());
        }

        // Cow
        if (path.equals("entities/cow")) {
            builder.pool(LootPool.builder()
                    .with(ItemEntry.builder(Items.BEEF)
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 7))))
                    .build());
            builder.pool(LootPool.builder()
                    .with(ItemEntry.builder(Items.LEATHER)
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 8))))
                    .build());
        }

        // Pig
        if (path.equals("entities/pig")) {
            builder.pool(LootPool.builder()
                    .with(ItemEntry.builder(Items.PORKCHOP)
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3, 5))))
                    .build());
        }

        // Sheep
        if (path.equals("entities/sheep")) {
            builder.pool(LootPool.builder()
                    .with(ItemEntry.builder(Items.MUTTON)
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 4))))
                    .build());
            builder.pool(LootPool.builder()
                    .with(ItemEntry.builder(Items.WHITE_WOOL)
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 3))))
                    .build());
        }

        // Zombie
        if (path.equals("entities/zombie")) {
            builder.pool(LootPool.builder()
                    .with(ItemEntry.builder(Items.IRON_NUGGET))
                    .with(ItemEntry.builder(Items.CARROT))
                    .with(ItemEntry.builder(Items.POTATO))
                    .with(ItemEntry.builder(Items.IRON_SWORD))
                    .with(ItemEntry.builder(Items.IRON_SHOVEL))
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 3)))
                    .build());
        }

        // Bonus Chest
        if (path.equals("chests/spawn_bonus_chest")) {
            builder.pool(LootPool.builder()
                    .with(ItemEntry.builder(Items.IRON_PICKAXE))
                    .with(ItemEntry.builder(Items.IRON_HELMET))
                    .with(ItemEntry.builder(Items.IRON_CHESTPLATE))
                    .with(ItemEntry.builder(Items.COOKED_BEEF))
                    .with(ItemEntry.builder(Items.BREAD))
                    .with(ItemEntry.builder(Items.TORCH))
                    .with(ItemEntry.builder(Items.OAK_LOG))
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2)))
                    .build());
        }

        // Chest Loots
        if (path.startsWith("chests/")) {

            builder.pool(LootPool.builder()
                    .with(ItemEntry.builder(Items.IRON_INGOT))
                    .with(ItemEntry.builder(Items.IRON_PICKAXE))
                    .with(ItemEntry.builder(Items.GOLDEN_CHESTPLATE))
                    .with(ItemEntry.builder(Items.GOLDEN_BOOTS))
                    .with(ItemEntry.builder(Items.LEAD))
                    .with(ItemEntry.builder(Items.ENCHANTED_BOOK))
                    .with(ItemEntry.builder(Items.COOKED_PORKCHOP))
                    .with(ItemEntry.builder(Items.DIAMOND))
                    .with(ItemEntry.builder(Items.EXPERIENCE_BOTTLE))
                    .with(ItemEntry.builder(Items.IRON_BOOTS))
                    .with(ItemEntry.builder(Items.IRON_HOE))
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 6)))
                    .build());
        }
    }
}
