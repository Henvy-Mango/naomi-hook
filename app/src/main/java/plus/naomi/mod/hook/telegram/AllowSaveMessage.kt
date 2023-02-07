package plus.naomi.mod.hook.telegram

import de.robv.android.xposed.XC_MethodReplacement
import de.robv.android.xposed.XposedBridge
import de.robv.android.xposed.XposedHelpers
import plus.naomi.mod.utils.xposed.base.HookRegister


/**
 * @author Naomi
 * @date 2023/2/7 11:21
 *
 */
object AllowSaveMessage : HookRegister() {

    override fun init() {
//        MethodFinder.fromClass(loadClass("org.telegram.messenger.MessagesController")).filterByName("isChatNoForwards")
//            .forEach {
//                Log.dx(it.name)
//                it.createHook {
//                    returnConstant(false)
//                }
//            }

        val messagesControllerClass =
            XposedHelpers.findClassIfExists("org.telegram.messenger.MessagesController", lpparam.classLoader)
        if (messagesControllerClass != null) {
            XposedBridge.hookAllMethods(
                messagesControllerClass,
                "isChatNoForwards",
                XC_MethodReplacement.returnConstant(false)
            )
        }
    }

}
