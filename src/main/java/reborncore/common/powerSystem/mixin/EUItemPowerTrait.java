package reborncore.common.powerSystem.mixin;

import ic2.api.item.IElectricItem;
import net.minecraft.item.ItemStack;
import reborncore.api.power.EnumPowerTier;
import reborncore.api.power.IEnergyInterfaceItem;
import reborncore.mixin.api.Inject;
import reborncore.mixin.api.Mixin;

@Mixin(target = "")
public class EUItemPowerTrait implements IElectricItem {

	@Override
	public boolean canProvideEnergy(ItemStack itemStack) {
		return getInterface().canAcceptEnergy(itemStack);
	}

	@Inject
	@Override
	public double getMaxCharge(ItemStack itemStack) {
		return getInterface().getMaxPower(itemStack);
	}

	@Inject
	@Override
	public int getTier(ItemStack itemStack) {
		return EnumPowerTier.getTeir((int) getInterface().getMaxTransfer(itemStack)).getIC2Tier();
	}

	@Inject
	@Override
	public double getTransferLimit(ItemStack itemStack) {
		return getInterface().getMaxTransfer(itemStack);
	}

	@Inject
	public IEnergyInterfaceItem getInterface() {
		return (IEnergyInterfaceItem) this;
	}
}
