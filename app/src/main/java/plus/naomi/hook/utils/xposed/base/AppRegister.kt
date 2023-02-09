package plus.naomi.hook.utils.xposed.base

import com.github.kyuubiran.ezxhelper.Log
import com.github.kyuubiran.ezxhelper.LogExtensions.logexIfThrow
import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.callbacks.XC_LoadPackage

abstract class AppRegister: IXposedHookLoadPackage {

    abstract val packageName: Set<String>

    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {}

    protected fun autoInitHooks(lpparam: XC_LoadPackage.LoadPackageParam, vararg hook: HookRegister) {
        hook.also {
            Log.dx("Try to Hook [${lpparam.packageName}]")
        }.forEach {
            runCatching {
                if (it.isInit) return@forEach
                it.setLoadPackageParam(lpparam)
                it.init()
                it.isInit = true
            }.logexIfThrow("Failed to Hook [${lpparam.packageName}]")
        }
    }

}
