package org.yessica_.mendingovertime;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;

public class PreInitEntrypoint implements PreLaunchEntrypoint {
    public void onPreLaunch()
    {

        AutoConfig.register(MOTConfig.class, GsonConfigSerializer::new);
    }
}
