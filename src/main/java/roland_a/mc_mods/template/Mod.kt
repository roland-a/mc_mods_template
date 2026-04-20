package roland_a.mc_mods.template

import net.fabricmc.api.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import roland_a.mc_mods.common.config.ConfigLoaderBuilder.Companion.withDefaultLocation
import roland_a.mc_mods.common.config.ConfigLoaderBuilder.Companion.withDefaultSerialization
import roland_a.mc_mods.common.config.ConfigLoaderBuilder.Companion.withLogger
import roland_a.mc_mods.common.config.loadConfig
import roland_a.mc_mods.template.config.Config

object Mod: ModInitializer {
	@JvmField
	val MOD_ID: String = Mod::class.java.packageName.split(".").last()

	@JvmStatic
	val logger: Logger = LoggerFactory.getLogger(MOD_ID)

	@JvmStatic
	val config: Config by lazy {
		loadConfig {
			withDefaultLocation(MOD_ID)

			withLogger(logger)

			withDefaultSerialization(Config.default)
		}
	}

	override fun onInitialize() {
		// Ensures that config does not initialize after startup
		config
	}
}
