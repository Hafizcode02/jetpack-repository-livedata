package com.hafizcode.moviesandtv.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TVRatedResponse(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("results")
	val results: List<ResultsItemTV?>? = null
)

data class ResultsItemTV(

	@field:SerializedName("iso_3166_1")
	val iso31661: String? = null,

	@field:SerializedName("rating")
	val rating: String? = null
)
