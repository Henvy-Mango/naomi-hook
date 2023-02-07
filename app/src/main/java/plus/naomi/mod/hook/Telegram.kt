package plus.naomi.mod.hook

import de.robv.android.xposed.callbacks.XC_LoadPackage
import plus.naomi.mod.hook.telegram.AllowSaveMessage
import plus.naomi.mod.hook.telegram.RemoveSponsor
import plus.naomi.mod.utils.xposed.base.AppRegister

/**
 * @author Naomi
 * @date 2023/2/7 11:15
 *
 */
object Telegram : AppRegister() {
    override val packageName: String = "nekox.messenger"

    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        autoInitHooks(
            lpparam,
            AllowSaveMessage,
            RemoveSponsor,
        )
    }

}
