package plus.naomi.mod

import plus.naomi.mod.hook.Bilibili
import plus.naomi.mod.hook.Telegram
import plus.naomi.mod.hook.Via
import plus.naomi.mod.utils.xposed.HookInit
import plus.naomi.mod.utils.xposed.base.AppRegister

class XposedEntry : HookInit() {
    override val registeredApp: List<AppRegister> =
        listOf(
            Telegram,
            Bilibili,
            Via
        )
}
