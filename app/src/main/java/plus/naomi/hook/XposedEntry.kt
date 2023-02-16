package plus.naomi.hook

import plus.naomi.hook.hook.Bilibili
import plus.naomi.hook.hook.Telegram
import plus.naomi.hook.hook.Via
import plus.naomi.hook.utils.xposed.HookInit
import plus.naomi.hook.utils.xposed.base.AppRegister

class XposedEntry : HookInit() {
    override val registeredApp: List<AppRegister> =
        listOf(
            Bilibili,
            Telegram,
            Via
        )
}
