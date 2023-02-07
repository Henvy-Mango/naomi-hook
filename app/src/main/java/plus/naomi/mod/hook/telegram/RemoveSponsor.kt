package plus.naomi.mod.hook.telegram

import com.github.kyuubiran.ezxhelper.ClassUtils
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.Log
import com.github.kyuubiran.ezxhelper.finders.MethodFinder
import plus.naomi.mod.utils.xposed.base.HookRegister


/**
 * @author Naomi
 * @date 2023/2/7 11:23
 *
 */
object RemoveSponsor : HookRegister() {

    override fun init() {
        MethodFinder.fromClass(ClassUtils.loadClass("org.telegram.messenger.MessagesController"))
            .filterByName("getSponsoredMessages").onEach {
                it.createHook {
                    Log.dx(it.name)
                    returnConstant(null)
                }
            }

        MethodFinder.fromClass(ClassUtils.loadClass("org.telegram.ui.ChatActivity"))
            .filterByName("addSponsoredMessages").onEach {
                it.createHook {
                    returnConstant(null)
                }
            }
    }

}
