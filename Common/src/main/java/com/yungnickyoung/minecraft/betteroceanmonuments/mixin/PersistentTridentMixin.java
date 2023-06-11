package com.yungnickyoung.minecraft.betteroceanmonuments.mixin;

import com.yungnickyoung.minecraft.betteroceanmonuments.mixin.accessor.ProjectileAccessor;
import com.yungnickyoung.minecraft.betteroceanmonuments.module.TagModule;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Prevents trident from despawning if it's within a Better Ocean Monument and
 * its owner UUID is my own, meaning this behavior should never be invoked for tridents
 * thrown by ordinary players.
 * This is done so that any thrown tridents placed as part of the structure never despawn,
 * but they will despawn as normal once picked up and thrown again by a player.
 */
@Mixin(AbstractArrow.class)
public abstract class PersistentTridentMixin extends Entity {
    public PersistentTridentMixin(EntityType<?> $$0, Level $$1) {
        super($$0, $$1);
    }

    @Inject(method = "tickDespawn", at = @At("HEAD"), cancellable = true)
    protected void betteroceanmonuments_preventTridentDespawning(CallbackInfo ci) {
        if (this.level() instanceof ServerLevel serverLevel && isTrident(this) && getOwner(this).equals("e624cdc1-c238-4dde-9f22-1f76b5123ce8")) {
            StructureStart structureStart = serverLevel.structureManager().getStructureWithPieceAt(this.blockPosition(), TagModule.BETTER_OCEAN_MONUMENT);
            if (structureStart.isValid()) {
                ci.cancel();
            }
        }
    }

    @Unique
    private boolean isTrident(Object object) {
        return object instanceof ThrownTrident;
    }

    @Unique
    private String getOwner(Object object) {
        if (object instanceof Projectile projectile) {
            if (((ProjectileAccessor)projectile).getOwnerUUID() != null) {
                return ((ProjectileAccessor)projectile).getOwnerUUID().toString();
            }
        }
        return "";
    }
}