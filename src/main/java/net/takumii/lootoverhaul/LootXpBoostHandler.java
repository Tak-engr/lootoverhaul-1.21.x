package net.takumii.lootoverhaul;

import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;

public class LootXpBoostHandler {
    public static void register() {
        ServerEntityCombatEvents.AFTER_KILLED_OTHER_ENTITY.register(LootXpBoostHandler::afterKilledOtherEntity);
    }

    private static void afterKilledOtherEntity(ServerWorld world, Entity attacker, LivingEntity killedEntity) {
        if (!(attacker instanceof ServerPlayerEntity player)) return;

        int bonusXp;

        // Boosted mobs
        EntityType<?> type = killedEntity.getType();
        if (type == EntityType.ZOMBIE ||
                type == EntityType.SKELETON ||
                type == EntityType.CREEPER ||
                type == EntityType.ENDERMAN ||
                type == EntityType.COW ||
                type == EntityType.PIG ||
                type == EntityType.CHICKEN ||
                type == EntityType.SHEEP) {
            bonusXp = 80;
        } else {
            bonusXp = 45;
        }

        player.addExperience(bonusXp);
    }
}
