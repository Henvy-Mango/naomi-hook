package plus.naomi.hook.hook.telegram

import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.finders.MethodFinder
import plus.naomi.hook.utils.xposed.base.HookRegister


/**
 * @author Naomi
 * @date 2023/2/7 11:21
 *
 */
object AllowSaveMessage : HookRegister() {

    override fun init() {
        MethodFinder.fromClass(loadClass("org.telegram.messenger.MessagesController")).filterByName("isChatNoForwards")
            .forEach {
                it.createHook {
                    returnConstant(false)
                }
            }
    }

}
