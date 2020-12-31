package com.kernel.finch

import com.kernel.finch.common.contracts.Finch
import com.kernel.finch.core.FinchImpl
import com.kernel.finch.implementation.BottomSheetUiManager

@Suppress("unused")
object Finch : Finch by FinchImpl(BottomSheetUiManager())
