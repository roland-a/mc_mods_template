package roland_a.mc_mods.template

import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin
import roland_a.mc_mods.common.conditionalMixinLoader

class Plugin: IMixinConfigPlugin by (
	conditionalMixinLoader {
	}
)
