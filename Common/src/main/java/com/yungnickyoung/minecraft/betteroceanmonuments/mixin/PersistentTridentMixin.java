package com.yungnickyoung.minecraft.betteroceanmonuments.mixin;

import com.yungnickyoung.minecraft.betteroceanmonuments.BetterOceanMonumentsCommon;
import com.yungnickyoung.minecraft.betteroceanmonuments.mixin.accessor.ProjectileAccessor;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import org.spongepowered.asm.mixin.Mixin;
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
    private static final ResourceLocation monumentResourceLocation = new ResourceLocation(BetterOceanMonumentsCommon.MOD_ID, "ocean_monument");

    public PersistentTridentMixin(EntityType<?> $$0, Level $$1) {
        super($$0, $$1);
    }

    @Inject(method = "tickDespawn", at = @At("HEAD"), cancellable = true)
    protected void preventTridentDespawning(CallbackInfo ci) {
        if (level instanceof ServerLevel && isTrident(this) && getOwner(this).equals("e624cdc1-c238-4dde-9f22-1f76b5123ce8")) {
            ResourceKey<ConfiguredStructureFeature<?, ?>> monumentKey = ResourceKey.create(Registry.CONFIGURED_STRUCTURE_FEATURE_REGISTRY, monumentResourceLocation);
            StructureStart structureStart = ((ServerLevel) this.level).structureFeatureManager().getStructureWithPieceAt(this.blockPosition(), monumentKey);
            if (structureStart.isValid()) {
                ci.cancel();
            }
        }
    }

    private boolean isTrident(Object object) {
        return object instanceof ThrownTrident;
    }

    private String getOwner(Object object) {
        if (object instanceof Projectile projectile) {
            if (((ProjectileAccessor)projectile).getOwnerUUID() != null) {
                return ((ProjectileAccessor)projectile).getOwnerUUID().toString();
            }
        }
        return "";
    }
}