package org.bitcoindotcom.bchprocessor.bip70.model

import com.bitcoin.merchant.app.util.GsonUtil
import com.google.gson.annotations.SerializedName
import java.util.*

data class InvoiceRequest @JvmOverloads constructor (
        @SerializedName("fiatAmount") var amount: String,
        @SerializedName("fiat") var fiat: String,
        @SerializedName("webhook") var webhook: String = "http://127.0.0.1/unused/webhook",
        @SerializedName("memo") var memo: String = UUID.randomUUID().toString(),
        @SerializedName("apiKey") var apiKey: String? = null,
        @SerializedName("address") var address: String? = null) {
    companion object {
        @JvmStatic
        fun fromJson(message: String): InvoiceRequest {
            return GsonUtil.gson.fromJson(message, InvoiceRequest::class.java)
        }
    }
}