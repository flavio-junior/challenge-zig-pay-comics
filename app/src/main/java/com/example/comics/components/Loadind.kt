package com.example.comics.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.InfiniteTransition
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.toRect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class StrokeStyle(
    val width: Dp = 4.dp,
    val strokeCap: StrokeCap = StrokeCap.Round,
    val glowRadius: Dp? = 4.dp
)

@Composable
fun CircleLoader(
    modifier: Modifier,
    isVisible: Boolean,
    color: Color = Color.Blue,
    secondColor: Color? = color,
    tailLength: Float = 140f,
    smoothTransition: Boolean = true,
    strokeStyle: StrokeStyle = StrokeStyle(),
    cycleDuration: Int = 1400,
) {
    val tailToDisplay: Animatable<Float, AnimationVector1D> =
        remember { Animatable(initialValue = 0f) }
    LaunchedEffect(isVisible) {
        val targetTail: Float = if (isVisible) tailLength else 0f
        when {
            smoothTransition -> tailToDisplay.animateTo(
                targetValue = targetTail,
                animationSpec = tween(durationMillis = cycleDuration, easing = LinearEasing)
            )

            else -> tailToDisplay.snapTo(targetTail)
        }
    }

    val transition: InfiniteTransition = rememberInfiniteTransition()
    val spinAngel: Float by transition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = cycleDuration,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        )
    )

    Canvas(
        modifier
            .size(size = SpaceSize.spaceSize100)
            .rotate(spinAngel)
            .aspectRatio(ratio = 1f)
    ) {
        listOfNotNull(color, secondColor).forEachIndexed { index, color ->
            rotate(if (index == 0) 0f else 180f) {
                val brush: Brush = Brush.sweepGradient(
                    0f to Color.Transparent,
                    tailToDisplay.value / 360f to color,
                    1f to Color.Transparent
                )
                val paint: Paint = setupPaint(style = strokeStyle, brush = brush)
                drawIntoCanvas { canvas ->
                    canvas.drawArc(
                        rect = size.toRect(),
                        startAngle = 0f,
                        sweepAngle = tailToDisplay.value,
                        useCenter = false,
                        paint = paint
                    )
                }
            }
        }
    }
}

private fun DrawScope.setupPaint(
    style: StrokeStyle,
    brush: Brush
): Paint {
    val paint: Paint = Paint().apply paint@{
        this@paint.isAntiAlias = true
        this@paint.style = PaintingStyle.Stroke
        this@paint.strokeWidth = style.width.toPx()
        this@paint.strokeCap = style.strokeCap
        brush.applyTo(size = size, p = this@paint, alpha = 1f)
    }

    style.glowRadius?.let { radius ->
        paint.asFrameworkPaint().setShadowLayer(
            radius.toPx(),
            0f,
            0f,
            android.graphics.Color.WHITE
        )
    }
    return paint
}
