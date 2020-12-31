package com.kernel.finch.components.special

import androidx.annotation.DrawableRes
import com.kernel.finch.common.contracts.component.Component
import com.kernel.finch.common.models.Text
import com.kernel.finch.components.Label

data class Screenshot(
    val text: Text = Text.CharSequence(DEFAULT_TEXT),
    val type: Label.Type = DEFAULT_TYPE,
    @DrawableRes val icon: Int? = DEFAULT_ICON,
    val isEnabled: Boolean = DEFAULT_IS_ENABLED,
    val onButtonPressed: () -> Unit = DEFAULT_ON_BUTTON_PRESSED
) : Component<Screenshot> {

    override val id: String = ID

    companion object {
        const val ID = "screenshot"
        private const val DEFAULT_TEXT = "Take a screenshot"
        private val DEFAULT_TYPE = Label.Type.BUTTON
        private val DEFAULT_ICON: Int? = null
        private const val DEFAULT_IS_ENABLED = true
        private val DEFAULT_ON_BUTTON_PRESSED: () -> Unit = {}
    }
}
