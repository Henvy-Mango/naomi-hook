package plus.naomi.hook.hook.telegram

import com.github.kyuubiran.ezxhelper.ClassUtils
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.finders.MethodFinder
import plus.naomi.hook.utils.xposed.base.HookRegister


/**
 * @author Naomi
 * @date 2023/2/7 11:23
 *
 */
object RemoveSponsor : HookRegister() {

    override fun init() {
        MethodFinder.fromClass(ClassUtils.loadClass("org.telegram.messenger.MessagesController"))
            .filterByName("getSponsoredMessages").forEach {
                it.createHook {
                    returnConstant(null)
                }
            }

        MethodFinder.fromClass(ClassUtils.loadClass("org.telegram.ui.ChatActivity"))
            .filterByName("addSponsoredMessages").forEach {
                it.createHook {
                    returnConstant(null)
                }
            }
    }

}
