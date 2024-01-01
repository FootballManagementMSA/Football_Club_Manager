package com.example.core

import com.example.core.model.TestUiModel
import com.example.network_api.model.TestResponse

object TestMapper {
    fun mapToUiModel(testResponse: TestResponse) = TestUiModel(testResponse.data)
}