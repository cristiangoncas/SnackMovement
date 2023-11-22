package com.cristiangoncas.snackmovement

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

fun applicationScope() = CoroutineScope(SupervisorJob() + Dispatchers.IO)
