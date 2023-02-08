package plus.naomi.mod.hook

import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.finders.MethodFinder
import de.robv.android.xposed.callbacks.XC_LoadPackage
import plus.naomi.mod.utils.xposed.base.AppRegister

/**
 * @author Naomi
 * @date 2023/2/8 10:27
 *
 */
object Via : AppRegister() {
    override val packageName = setOf("mark.via")

    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        // TODO DexKit, now only work on 4.4.7
        MethodFinder.fromClass(loadClass("i.a.r.c.a"))
            .filterByName("s").filterByParamTypes(loadClass("i.a.r.c.b")).firstOrNull()?.createHook { interrupt() }
    }

}
