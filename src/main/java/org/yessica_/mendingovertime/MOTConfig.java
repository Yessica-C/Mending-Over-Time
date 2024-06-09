package org.yessica_.mendingovertime;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "mendingovertime")
class MOTConfig implements ConfigData
{
    @ConfigEntry.Gui.Tooltip
    int repairAmount = 1;

    @ConfigEntry.Gui.Tooltip
    int hitBound = 800;
}