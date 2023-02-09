package plus.naomi.hook.utils.xposed;

import com.github.kyuubiran.ezxhelper.EzXHelper
import com.github.kyuubiran.ezxhelper.LogExtensions.logexIfThrow
import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.IXposedHookZygoteInit
import de.robv.android.xposed.callbacks.XC_LoadPackage
import plus.naomi.hook.utils.xposed.base.AppRegister

abstract class HookInit : IXposedHookLoadPackage, IXposedHookZygoteInit {
    private lateinit var packageParam: XC_LoadPackage.LoadPackageParam
    abstract val registeredApp: List<AppRegister>
    private val TAG = "NaomiMod"

    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam?) {
        packageParam = lpparam!!
        registeredApp.forEach { app ->
            if (app.packageName.contains(lpparam.packageName)) {
                EzXHelper.apply {
                    setLogTag(TAG)
                    setToastTag(TAG)
                    enableFinderExceptionMessage()
                    initHandleLoadPackage(lpparam)
                }
                runCatching { app.handleLoadPackage(lpparam) }.logexIfThrow("Failed call handleLoadPackage, package: ${app.packageName}")
            }
        }
    }

    override fun initZygote(startupParam: IXposedHookZygoteInit.StartupParam?) {
        EzXHelper.initZygote(startupParam!!)
    }
}
