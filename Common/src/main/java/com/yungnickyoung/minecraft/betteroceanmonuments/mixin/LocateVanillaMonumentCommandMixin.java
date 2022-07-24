package com.yungnickyoung.minecraft.betteroceanmonuments.mixin;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import com.yungnickyoung.minecraft.betteroceanmonuments.BetterOceanMonumentsCommon;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.ResourceOrTagLocationArgument;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.commands.LocateCommand;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

/**
 * Overrides behavior of /locate monument.
 */
@Mixin(LocateCommand.class)
public class LocateVanillaMonumentCommandMixin {
    private static final SimpleCommandExceptionType OLD_MONUMENT_EXCEPTION =
        new SimpleCommandExceptionType(new TextComponent("Use /locate betteroceanmonuments:ocean_monument instead!"));

    @Inject(method = "locate", at = @At(value = "HEAD"), cancellable = true)
    private static void overrideLocateVanillaMonument(CommandSourceStack cmdSource,
                                                     ResourceOrTagLocationArgument.Result<ConfiguredStructureFeature<?, ?>> result,
                                                     CallbackInfoReturnable<Integer> ci) throws CommandSyntaxException {
        Optional<ResourceKey<ConfiguredStructureFeature<?, ?>>> optional = result.unwrap().left();
        if (BetterOceanMonumentsCommon.CONFIG.general.disableVanillaMonuments && optional.isPresent() && optional.get().location().equals(new ResourceLocation("monument"))) {
            throw OLD_MONUMENT_EXCEPTION.create();
        }
    }
}
