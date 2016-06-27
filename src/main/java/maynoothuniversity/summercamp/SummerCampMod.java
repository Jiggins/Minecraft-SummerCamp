package maynoothuniversity.summercamp;

import maynoothuniversity.summercamp.blocks.BlockExample;
import maynoothuniversity.summercamp.blocks.BlockExample2;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
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
		 public static BlockExample2 blockexample2;

		/**
		 * Runs before the game loads.
		 * Used to add Blocks, Items, Entities etc. to the game.
		 * @EventHandler is important here, mod will not load without it
		 */
		@Mod.EventHandler
		public void preInit(FMLPreInitializationEvent event) {
				System.out.println("SummerCampMod preInit");
				 blockexample = new BlockExample();
				 blockexample.initModel();
		}

		/**
		 * Runs as the game loads.
		 * Used for adding recipes to the game
		 * @EventHandler is important here, mod will not load without it
		 */
		@Mod.EventHandler
		public void init(FMLInitializationEvent event) {
				System.out.println("SummerCampMod init");
		}
}
