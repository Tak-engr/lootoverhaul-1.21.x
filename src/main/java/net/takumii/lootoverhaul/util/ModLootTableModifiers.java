package net.takumii.lootoverhaul.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableSource;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKey;

public class ModLootTableModifiers {
    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register(ModLootTableModifiers::modifyLootTable);
    }

    private static void modifyLootTable(RegistryKey<LootTable> id, LootTable.Builder builder, LootTableSource source, Object unused) {
        if (!source.isBuiltin()) return;

        // 🐔 Chicken — 3 to 5 raw chicken
        if (id.getValue().getPath().equals("entities/chicken")) {
            System.out.println("[LootOverhaul] Chicken loot table detected and modified.");
            LootPool pool = LootPool.builder()
                    .with(ItemEntry.builder(Items.CHICKEN)
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3, 5))))
                    .build();
            builder.pool(pool);
        }

        // 🐄 Cow — 3 to 5 beef, 4 to 6 leather
        if (id.getValue().getPath().equals("entities/cow")) {
            System.out.println("[LootOverhaul] Cow loot table detected and modified.");
            LootPool beefPool = LootPool.builder()
                    .with(ItemEntry.builder(Items.BEEF)
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3, 5))))
                    .build();
            LootPool leatherPool = LootPool.builder()
                    .with(ItemEntry.builder(Items.LEATHER)
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4, 6))))
                    .build();
            builder.pool(beefPool);
            builder.pool(leatherPool);
        }

        // 📦 All chests — better loot
        if (id.getValue().getPath().startsWith("chests/")) {
            System.out.println("[LootOverhaul] Chest loot table modified: " + id.getValue().toString());
            LootPool loot = LootPool.builder()
                    .with(ItemEntry.builder(Items.DIAMOND))
                    .with(ItemEntry.builder(Items.GOLDEN_APPLE))
                    .with(ItemEntry.builder(Items.ENCHANTED_BOOK))
                    .with(ItemEntry.builder(Items.COOKED_BEEF))
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2)))
                    .build();
            builder.pool(loot);
        }
    }
}
