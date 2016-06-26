package maynoothuniversity.summercamp;

import maynoothuniversity.summercamp.blocks.BlockExample;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * This class is the main class for our mod.  The three @EventHandler methods below is similar to a main method.
 * This is where all the methods and objects from all other classes will be called.
 * This code will produce a lot of errors as its being typed because we use so many different classes.
 * Usually the fix is simply pressing ctrl+shift+o to automatically import the required classes.
 *
 * Note: Don't worry about the imports in any of these classes
 * eclipse will automatically import everything needed with the shortcut
 * ctrl+shift+o (Mac: Command+shift+o)
 * if it asks you what to import, always pick the one with either forge, fml or minecraft in its name.
 *
 * The `@Mod` annotation tells the game that this class is a mod and to add it to the game.
 */
@Mod(modid = SummerCampMod.MODID, version = SummerCampMod.VERSION)
public class SummerCampMod {

		public static final String MODID = "summercamp";
		public static final String VERSION = "1.0";

		public static BlockExample blockexample;

		@SidedProxy
		public static CommonProxy proxy;

		@Mod.Instance
		public static SummerCampMod instance;

		/**
		 * Runs before the game loads.
		 * Used to add Blocks, Items, Entities etc. to the game.
		 * @EventHandler is important here, mod will not load without it
		 */
		@Mod.EventHandler
		public void preInit(FMLPreInitializationEvent event) {
				System.out.println("SummerCampMod preInit");
				proxy.preInit(event);
		}

		/**
		 * Runs as the game loads.
		 * Used for adding names and recipes to the game
		 * @EventHandler is important here, mod will not load without it
		 */
		@Mod.EventHandler
		public void init(FMLInitializationEvent event) {
				System.out.println("SummerCampMod init");
				proxy.init(event);
		}

		@Mod.EventHandler
		public void postInit(FMLPostInitializationEvent event) {
				System.out.println("SummerCampMod postInit");
				proxy.postInit(event);
		}

		/**
		 * The proxy classes control what is loaded on the client or server.
		 * The `Common Proxy` loads objects that are used on both the client and server.
		 * This is where we will load blocks and items
		 */
		public static class CommonProxy {
				/**
				 * Common pre-initialisation event.
				 * Initialization of blocks and items typically goes here:
				 */
				public void preInit(FMLPreInitializationEvent event) {
						blockexample = new BlockExample();
				}

				public void init(FMLInitializationEvent event) {

				}

				public void postInit(FMLPostInitializationEvent event) {

				}
		}

		/**
		 * Client Proxy.
		 * Loads objects only on the client side, this is useful for things that the
		 * server doesn't need like textures, particles and sounds.
		 */
		public static class ClientProxy extends CommonProxy {
				@Override
				public void preInit(FMLPreInitializationEvent event) {
						super.preInit(event);
						// Typically initialization of models and such goes here:
						blockexample.initModel();
				}
		}

		public static class ServerProxy extends CommonProxy {

		}
}
