package ltd.ucode.panopticon.data.datasources.implementation.client

import ltd.ucode.panopticon.core.data.AppException

data class ServiceError(val error: String) : AppException(error)
