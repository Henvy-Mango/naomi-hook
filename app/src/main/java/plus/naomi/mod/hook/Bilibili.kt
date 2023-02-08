package plus.naomi.mod.hook

import de.robv.android.xposed.callbacks.XC_LoadPackage
import plus.naomi.mod.hook.bilibili.UnlockBigAccount
import plus.naomi.mod.utils.xposed.base.AppRegister

/**
 * @author Naomi
 * @date 2023/2/8 9:56
 *
 */
object Bilibili : AppRegister() {
    override val packageName = setOf("tv.danmaku.bili")

    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        autoInitHooks(
            lpparam,
            UnlockBigAccount,
        )
    }

}
