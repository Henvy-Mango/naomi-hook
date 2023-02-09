package plus.naomi.hook.hook.bilibili

import com.github.kyuubiran.ezxhelper.ClassUtils.loadClass
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.github.kyuubiran.ezxhelper.finders.MethodFinder
import plus.naomi.hook.utils.xposed.base.HookRegister


/**
 * @author Naomi
 * @date 2023/2/7 11:21
 *
 */
object UnlockBigAccount : HookRegister() {

    override fun init() {
        MethodFinder.fromClass(loadClass("com.bilibili.lib.accountinfo.model.VipUserInfo"))
            .filterByName("isEffectiveVip").first()
            .createHook {
                returnConstant(true)
            }
        MethodFinder.fromClass(loadClass("com.bilibili.lib.accountinfo.model.VipExtraUserInfo"))
            .filterByName("isEffectiveVip").first()
            .createHook {
                returnConstant(true)
            }
    }

}
