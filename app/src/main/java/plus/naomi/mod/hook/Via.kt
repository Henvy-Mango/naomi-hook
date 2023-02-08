package plus.naomi.mod.hook

import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import de.robv.android.xposed.callbacks.XC_LoadPackage
import io.luckypray.dexkit.DexKitBridge
import io.luckypray.dexkit.enums.MatchType
import plus.naomi.mod.utils.xposed.base.AppRegister

/**
 * @author Naomi
 * @date 2023/2/8 10:27
 *
 */
object Via : AppRegister() {
    override val packageName = setOf("mark.via")

    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        System.loadLibrary("dexkit")

        val apkPath = lpparam.appInfo.sourceDir
        val classLoader = lpparam.classLoader
        DexKitBridge.create(apkPath)?.apply {
            use { bridge ->
                bridge.findMethodUsingString {
                    usingString = "di5xcS5jb20="
                    matchType = MatchType.FULL
                }.first().getMethodInstance(classLoader).createHook {
                    interrupt()
                }
            }
            close()
        }
    }

}
