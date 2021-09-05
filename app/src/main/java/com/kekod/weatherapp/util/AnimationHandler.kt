import android.content.Context
import android.view.animation.Animation
import android.view.animation.AnimationUtils

fun createAnimation(
    animId: Int,
    context: Context,
    animationListener: Animation.AnimationListener? = null,
): Animation {
    val anim = AnimationUtils.loadAnimation(context, animId)

    anim.setAnimationListener(animationListener)
    return anim

}