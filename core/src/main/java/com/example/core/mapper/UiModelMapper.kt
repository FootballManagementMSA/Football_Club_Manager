package com.example.core.mapper

import com.example.core.model.LocalScreen
import com.example.core.model.MemberUiModel
import com.example.core.model.MyPageUserInfoUiModel
import com.example.core.model.Position
import com.example.core.model.PositionPresetUIModel
import com.example.network_api.entity.Member
import com.example.network_api.entity.PositionPreset
import com.example.network_api.entity.RemoteScreen
import com.example.network_api.response.RespResult
import com.example.network_api.response.UserInfoResponse

object UiModelMapper {
    fun PositionPreset.mapToUiModel() =
        PositionPresetUIModel(
            screenSize = this.screenSize.mapToUiModel(),
            members = this.members.map { it.mapToUiModel() }
        )

    fun RemoteScreen.mapToUiModel() =
        LocalScreen(this.width, this.height)

    fun com.example.network_api.entity.Position.mapToUiModel() = Position(
        x = this.x,
        y = this.y
    )

    fun Member.mapToUiModel() = MemberUiModel(
        id = this.id,
        name = this.name,
        role = this.role,
        number = this.number,
        position = this.position.mapToUiModel()
    )

    fun RespResult<UserInfoResponse>.mapToUiModel(): MyPageUserInfoUiModel {
        return when (this) {
            is RespResult.Success -> {
                MyPageUserInfoUiModel(
                studentId = data.userData.studentId,
                name = data.userData.name,
                image = data.userData.image
            )
            }
            is RespResult.Error -> {
                MyPageUserInfoUiModel(
                    studentId = "err",
                    name = "err",
                    image = null
                )
            }
        }
    }

}
