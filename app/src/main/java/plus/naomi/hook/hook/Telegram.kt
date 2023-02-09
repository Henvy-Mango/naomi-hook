package plus.naomi.hook.hook

import de.robv.android.xposed.callbacks.XC_LoadPackage
import plus.naomi.hook.hook.telegram.AllowSaveMessage
import plus.naomi.hook.hook.telegram.RemoveSponsor
import plus.naomi.hook.utils.xposed.base.AppRegister

/**
 * @author Naomi
 * @date 2023/2/7 11:15
 *
 */
object Telegram : AppRegister() {
    override val packageName = setOf("nekox.messenger", "xyz.nextalone.nagram")

    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        autoInitHooks(
            lpparam,
            AllowSaveMessage,
            RemoveSponsor,
        )
    }

}
