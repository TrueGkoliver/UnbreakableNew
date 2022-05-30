package com.gkoliver.unbreakable.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class UnbreakableConfig {
    public static class Configuration {
        public final ForgeConfigSpec.BooleanValue WHITELIST_BLACKLIST;
        public Configuration(ForgeConfigSpec.Builder builderIn) {
            builderIn.comment("Core features")
                    .push("whitelist");
            WHITELIST_BLACKLIST = builderIn.comment("If this value is true, the gk_unbreakable:break_list tag will be a whitelist instead of a blacklist. By default, it's a blacklist.")
                    .translation("gk_unbreakable.config.whitelist")
                    .define("whitelist", false);
            builderIn.pop(1);
        }
    }
    public static final ForgeConfigSpec CONFIGSPEC;
    public static final Configuration CONFIG;
    static {
        final Pair<Configuration, ForgeConfigSpec> pair = new ForgeConfigSpec.Builder().configure(Configuration::new);
        CONFIGSPEC = pair.getRight();
        CONFIG = pair.getLeft();
    }
}
