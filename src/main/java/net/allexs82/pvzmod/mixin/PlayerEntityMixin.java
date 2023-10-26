package net.allexs82.pvzmod.mixin;

import net.allexs82.pvzmod.PVZMod;
import net.allexs82.pvzmod.util.IPlayerEntityDataSaver;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin implements IPlayerEntityDataSaver {

	@Unique
	private NbtCompound persistenceData;

	public @NotNull NbtCompound PVZModFabric$getPersistenceData() {
		if (this.persistenceData == null){
			return this.persistenceData = new NbtCompound();
		}
		return this.persistenceData;
	}

	@Inject(method = "writeCustomDataToNbt", at = @At("HEAD"))
	public void injectWriteMethod(NbtCompound nbt, CallbackInfo ci) {
		if (persistenceData != null){
			nbt.put(PVZMod.NBT_MODIFIER, persistenceData);
		}
	}

	@Inject(method = "readCustomDataFromNbt", at = @At("HEAD"))
	public void injectReadMethod(NbtCompound nbt, CallbackInfo ci) {
		if (nbt.contains(PVZMod.NBT_MODIFIER, NbtElement.COMPOUND_TYPE)) {
			persistenceData = nbt.getCompound(PVZMod.NBT_MODIFIER);
		}
	}

}
