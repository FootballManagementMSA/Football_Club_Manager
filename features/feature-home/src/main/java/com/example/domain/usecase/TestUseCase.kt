package com.example.domain.usecase

import com.example.core.datasource.TestDataSource
import javax.inject.Inject

class TestUseCase @Inject constructor(private val dataSource: TestDataSource) {
    suspend operator fun invoke() = dataSource.getResponse()
}