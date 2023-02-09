package plus.naomi.hook.hook

import de.robv.android.xposed.callbacks.XC_LoadPackage
import plus.naomi.hook.hook.bilibili.UnlockBigAccount
import plus.naomi.hook.utils.xposed.base.AppRegister

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
