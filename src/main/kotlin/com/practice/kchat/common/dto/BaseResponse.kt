package com.practice.kchat.common.dto

import com.practice.kchat.common.status.ResultCode

data class BaseResponse<T> (
        val resultCode: String = ResultCode.SUCCESS.name,
        val data: T? = null,
        val message: String = ResultCode.SUCCESS.msg
)