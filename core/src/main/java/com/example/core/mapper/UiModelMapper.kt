package com.example.core.mapper

import com.example.core.model.Club
import com.example.core.model.ClubInfo
import com.example.core.model.Data
import com.example.core.model.LocalScreen
import com.example.core.model.MainHomeUiModel
import com.example.core.model.MemberUiModel
import com.example.core.model.MyPageUserInfoUiModel
import com.example.core.model.Position
import com.example.core.model.PositionPresetUIModel
import com.example.core.model.Schedule2
import com.example.core.model.Student
import com.example.core.model.Team
import com.example.network_api.entity.Member
import com.example.network_api.entity.PositionPreset
import com.example.network_api.entity.RemoteScreen
import com.example.network_api.response.ClubInfoResponse
import com.example.network_api.response.MainHomeResponse
import com.example.network_api.response.RespResult
import com.example.network_api.response.SearchClubResponse
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

    fun MainHomeResponse.mapToUiModel() = MainHomeUiModel(
        status = this.status,
        code = this.code,
        data = Data(
            student = Student(
                name = this.data.student.name,
                game = this.data.student.game,
                goal = this.data.student.goal,
                position = this.data.student.position,
                foot = this.data.student.foot
            ),
            schedule = Schedule2(
                place = this.data.schedule.place,
                startTime = this.data.schedule.startTime,
                homeTeam = Team(
                    this.data.schedule.homeTeam.name,
                    this.data.schedule.homeTeam.emblem
                ),
                awayTeam = Team(
                    this.data.schedule.awayTeam.name,
                    this.data.schedule.awayTeam.emblem
                ),
            )
        ),
        message = this.message
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

    fun RespResult<SearchClubResponse>.mapToUiModel(): Club {
        return when (this) {
            is RespResult.Success -> {
                Club(
                    status = data.status,
                    message = data.message,
                    data = data.data.map { it.mapToUiModel() }
                )
            }

            is RespResult.Error -> {
                Club(
                    status = 0,
                    message = this.error.errorMessage,
                    data = listOf(
                        ClubInfo(
                            teamId = -1,
                            teamName = "err",
                            totalMemberCnt = 0,
                            uniqueNum = "err",
                            emblem = ""
                        )
                    )
                )
            }
        }
    }

    fun ClubInfoResponse.mapToUiModel() = ClubInfo(
        teamId = this.teamId,
        teamName = this.teamName,
        totalMemberCnt = this.totalMemberCnt,
        uniqueNum = this.uniqueNum,
        emblem = this.emblem
    )

}
