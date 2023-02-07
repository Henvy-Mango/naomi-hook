package plus.naomi.mod.hook.telegram

import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.Log
import com.github.kyuubiran.ezxhelper.finders.MethodFinder
import plus.naomi.mod.utils.xposed.base.HookRegister


/**
 * @author Naomi
 * @date 2023/2/7 11:21
 *
 */
object AllowSaveMessage : HookRegister() {

    override fun init() {
        MethodFinder.fromClass(loadClass("org.telegram.messenger.MessagesController")).filterByName("isChatNoForwards")
            .forEach {
                Log.d(it.name)
                it.createHook {
                    returnConstant(false)
                }
            }
    }

}
